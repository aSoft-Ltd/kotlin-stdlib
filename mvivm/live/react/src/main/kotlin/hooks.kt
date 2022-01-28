@file:JsExport

import react.*
import live.Live
import live.value

fun <S> useLive(live: Live<S>): S {
    var state by useState(live.value)
    useEffectOnce {
        val watcher = live.peek { state = it }
        cleanup { watcher.stop() }
    }
    return state
}