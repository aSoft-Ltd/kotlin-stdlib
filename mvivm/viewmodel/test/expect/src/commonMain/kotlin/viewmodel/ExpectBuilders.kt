@file:JvmName("ExpectBuilders")

package viewmodel

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import live.WatchMode
import kotlin.jvm.JvmName

fun <I, S, V : ViewModel<I, S>> expect(viewModel: V) = ViewModelExpectation(viewModel)

suspend fun <I, S> ViewModel<I, S>.expect(intent: I, with: CoroutineDispatcher = Dispatchers.Default): ViewModelStateExpectation<S> {
    val states = mutableListOf<S>()
    val watcher = ui.watch(WatchMode.CASUALLY) { states.add(it) }
    withContext(with) { start(intent) }
    watcher.stop()
    return ViewModelStateExpectation(states)
}