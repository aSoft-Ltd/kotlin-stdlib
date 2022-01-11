plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    signing
}

kotlin {
    jvm {
        library();
        withJava();
    }
    js(IR) { library() }

    nativeTargets(true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlinx.serialization.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(asoft.expect.core)
                implementation(kotlinx.serialization.json)
            }
        }
    }
}

val generate by tasks.creating(CodeGenerator::class)

val assemble by tasks.getting {
    dependsOn(generate)
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(),
    description = "A kotlin multiplatform library to deal with money and currencies"
)