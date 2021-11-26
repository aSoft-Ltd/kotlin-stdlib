plugins {
    kotlin("multiplatform")
    id(asoft.plugins.library.get().pluginId)
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    nativeTargets(true)
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":color-core"))
            }
        }
        val commonTest by getting {
            dependencies {
                api(asoft.expect.core)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(),
    description = "A platform/framework agnostic theme engine"
)