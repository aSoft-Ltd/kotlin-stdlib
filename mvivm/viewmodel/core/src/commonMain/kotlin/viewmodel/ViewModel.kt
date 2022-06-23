@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package viewmodel

import live.*
import kotlin.js.JsExport
import kotlin.js.JsName

abstract class ViewModel<S> constructor(private val config: ViewModelConfig<S>) : PlatformViewModel() {
    @JsName("withInitialState")
    constructor(initial: S) : this(ViewModelConfig(initial))

    protected val logger get() = config.logger.with("source" to this::class.simpleName)

    protected val executor get() = config.executor

    val ui: MutableLive<S> = mutableLiveOf(config.initial)

    init {
        ui.watch(WatchMode.Eagerly) { log("State at ${it?.toDetailedString}") }
    }

    override fun onCleared() {
        ui.stopAll()
    }

    protected fun log(msg: String) = when {
        msg.contains("error", ignoreCase = true) -> logger.error(msg)
        msg.contains("fail", ignoreCase = true) -> logger.failure(msg)
        else -> logger.info(msg)
    }
}