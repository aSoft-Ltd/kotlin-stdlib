plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    darwinTargets(true)
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":viewmodel-test-core"))
                api(asoft.expect.coroutines)
                api(kotlinx.coroutines.test)
                api(asoft.kotlinx.collections.atomic)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(),
    description = "A multiplatfrom library to help test viewmodels with the expect library"
)