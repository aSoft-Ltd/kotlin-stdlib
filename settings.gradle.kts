pluginManagement {
    enableFeaturePreview("VERSION_CATALOGS")
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    dependencyResolutionManagement {
        versionCatalogs {
            file("gradle/versions").listFiles().map { it.nameWithoutExtension }.forEach {
                create(it) { from(files("gradle/versions/$it.toml")) }
            }
        }
    }
}

fun includeRoot(name: String, path: String) {
    include(":$name")
    project(":$name").projectDir = File(path)
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

rootProject.name = "stdlib"

includeSubs("live", "mvivm/live", "core", "react", "compose", "coroutines")
includeSubs("viewmodel", "mvivm/viewmodel", "core", "react", "compose", "coroutines")
includeSubs("viewmodel-test", "mvivm/viewmodel/test", "core", "expect")

includeSubs("identifier", "identifier", "core", "generators")

includeSubs("color", "aesthetics/color", "core", "css", "compose")
includeSubs("theme", "aesthetics/theme", "core", "css", "compose", "react")
includeSubs("reakt", "reakt", "core", "web", "icons")

includeSubs("kash", "finance/kash", "core")
includeSubs("payments-requests", "finance/payments/requests", "core")