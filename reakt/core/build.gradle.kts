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
                api(project.dependencies.platform(kotlinw.bom))
                api(kotlinw.react.old)
                api(kotlinw.styled)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(), description = "A react wrapper tool library for kotlin-react"
)