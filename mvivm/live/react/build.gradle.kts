plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    signing
}

dependencies {
    api(enforcedPlatform(kotlinw.bom))
}

kotlin {
    js(IR) { browserLib() }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":live-core"))
                api(kotlinw.react.core)
            }
        }
        val test by getting {
            dependencies {
                implementation(asoft.expect.core)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(), description = "An extension of the Live<T> targeted for react"
)