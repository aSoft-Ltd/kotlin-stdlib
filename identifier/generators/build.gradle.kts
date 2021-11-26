plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    val nativeTargets = nativeTargets(true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":identifier-core"))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft.expect.coroutines)
                api(kotlinx.serialization.json)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(),
    description = "An multiplatform representation of a Live<T> object"
)