# MVIVM

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

A collection of kotlin multiplatform libs to facilitate the MVIVM architecture while authoring authoring multiplatform applications

## Samples

```kotlin
class CounterViewModel : VModel<Intent, State>(State(0)) {

    data class State(val value: Int)

    sealed class Intent {
        data class CountUp(val by: Int) : Intent()
        data class CountDown(val by: Int) : Intent()
    }

    override fun execute(i: Intent) = when (i) {
        is Intent.CountUp -> ui.value = State(value = ui.value.value + i.by)
        is Intent.CountDown -> ui.value = State(value = ui.value.value - i.by)
    }
}
```

## Setup: Gradle

```kotlin
dependencies {
    implementation("tz.co.asoft:viewmodel-core:0.1.0") //
    // or
    implementation("tz.co.asoft:viewmodel-react:0.1.0") // if using intended to be used in kotlin/react 
}
```

## Compatibility
|ViewModel Version|Kotlin Version|
|-----------------|--------------|
| 0.1.0           | 1.5.10       |

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/viewmodel-core/0.1.0?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
