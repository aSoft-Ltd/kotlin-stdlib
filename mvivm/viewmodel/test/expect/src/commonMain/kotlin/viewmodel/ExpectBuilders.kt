@file:JvmName("ExpectBuilders")

package viewmodel

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.withContext
import live.WatchMode
import kotlin.jvm.JvmName
import kotlin.jvm.JvmSynthetic

fun <I, S, V : ViewModel<I, S>> expect(viewModel: V) = ViewModelExpectation(viewModel)

@JvmSynthetic
suspend fun <I, S> ViewModel<I, S>.expect(intent: I): ViewModelStateExpectation<S> {
    val states = mutableListOf<S>()
    val watcher = ui.watch(WatchMode.CASUALLY) { states.add(it) }
    coroutineScope { start(intent) }
    watcher.stop()
    return ViewModelStateExpectation(states)
}