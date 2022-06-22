plugins {
    kotlin("js")
    id(asoft.plugins.library.get().pluginId)
    signing
}

kotlin {
    js(IR) { browserLib() }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":theme-css"))
                api(kotlinw.react.old)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.stdlib.get(), description = "A theme engine for kotlin/react"
)
