package viewmodel

import koncurrent.Executor
import live.*
import kotlin.jvm.JvmOverloads

open class IntentBus<I> @JvmOverloads constructor(val executor: Executor = SynchronousExecutor.Default) {
    private val INTENT = mutableLiveOf<I?>(null)

    fun post(i: I) {
        INTENT.value = i
    }

    fun onIntent(callback: (I) -> Unit): Watcher = INTENT.watch(WatchMode.Casually, executor) {
        if (it != null) callback(it)
    }
}