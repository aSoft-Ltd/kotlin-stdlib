@file:JsExport

import react.*
import live.Live

fun <S> useLive(live: Live<S>): S {
    var state by useState(live.value)
    useEffectOnce {
        val watcher = live.watch(ignoreImmediateValue = true) { state = it }
        cleanup { watcher.stop() }
    }
    return state
}