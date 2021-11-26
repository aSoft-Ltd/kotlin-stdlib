plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    signing
}

kotlin {
    js(IR) { library() }

    sourceSets {
        val main by getting {
            dependencies {
                api(kotlinx.coroutines.core)
                api(kotlinw.react)
                api(kotlinw.styled)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(),
    description = "A react wrapper tool library for kotlin-react"
)