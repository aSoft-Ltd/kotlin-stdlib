@file:JsExport

import live.Live
import live.WatchMode
import react.useEffectOnce
import react.useState

fun <S> useLive(live: Live<S>): S {
    var state by useState(live.value)
    useEffectOnce {
        val watcher = live.watch(WatchMode.CASUALLY) { state = it }
        cleanup { watcher.stop() }
    }
    return state
}