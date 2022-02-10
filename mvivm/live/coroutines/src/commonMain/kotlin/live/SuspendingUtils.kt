package live

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun <S> Live<S>.watch(scope: CoroutineScope, mode: WatchMode = WatchMode.DEFAULT, callback: suspend CoroutineScope.(S) -> Unit) = watch(mode) {
    scope.launch { callback(it) }
}

fun <S> CoroutineScope.watch(live: Live<S>, mode: WatchMode = WatchMode.DEFAULT, callback: suspend CoroutineScope.(S) -> Unit): Job = launch {
    live.watch(mode).collect { callback(it) }
}