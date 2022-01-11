plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id(asoft.plugins.library.get().pluginId)
    signing
}

kotlin {
    android { library() }
    jvm { library() }
    js(IR) { library() }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":color-core"))
            }
        }
        val commonTest by getting {
            dependencies { api(asoft.expect.core) }
        }

        val jvmAndAndroidMain by creating {
            dependsOn(commonMain)
            dependencies {
                api(compose.ui)
            }
        }

        val androidMain by getting {
            dependsOn(jvmAndAndroidMain)
        }

        val jvmMain by getting {
            dependsOn(jvmAndAndroidMain)
        }

        val jsMain by getting {
            dependencies {
                api(compose.web.core)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(),
    description = "A platform agnostic color library for compose"
)
