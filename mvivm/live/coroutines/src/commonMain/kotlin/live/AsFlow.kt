package live

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.callbackFlow

fun <S> Live<S>.watchAsFlow(mode: WatchMode = WatchMode.EAGERLY): Flow<S> = callbackFlow {
    val watcher = watch(mode) { trySend(it) }
    awaitClose { watcher.stop() }
}