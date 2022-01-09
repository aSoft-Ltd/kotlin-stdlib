plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    signing
}

kotlin {
    js(IR) { browserLib() }

    sourceSets {
        val main by getting {
            dependencies {
                api(kotlinw.react.old)
                api(npm("react-icons", "3.10.0"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(),
    description = "A kotlin js wrapper for the react-icons React lib"
)