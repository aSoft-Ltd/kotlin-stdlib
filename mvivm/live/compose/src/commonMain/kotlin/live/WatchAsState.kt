package live

import androidx.compose.runtime.*

@Composable
fun <S> Live<S>.watchAsState(): S {
    var state by remember { mutableStateOf(value) }
    DisposableEffect(this) {
        val watcher = peek { state = it }
        onDispose { watcher.stop() }
    }
    return state
}