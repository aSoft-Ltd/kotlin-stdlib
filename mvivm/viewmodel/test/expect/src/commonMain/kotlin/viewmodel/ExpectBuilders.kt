@file:JvmName("ExpectBuilders")

package viewmodel

import live.WatchMode
import live.watch
import viewmodel.internal.ViewModelExpectationImpl
import viewmodel.internal.ViewModelStatesExpectationImpl
import kotlin.jvm.JvmName

fun <S, V : ViewModel<S>> expect(viewModel: V) = ViewModelExpectationImpl(viewModel)

inline fun <S, V : ViewModel<S>> V.expect(builder: V.() -> Unit): ViewModelStatesExpectationImpl<S> {
    val states = mutableListOf<S>()
    val watcher = ui.watch(WatchMode.Casually) { states.add(it) }
    builder()
    watcher.stop()
    return ViewModelStatesExpectationImpl(states)
}