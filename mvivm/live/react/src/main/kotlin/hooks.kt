@file:JsExport

import live.Live
import react.*

fun <S> useLive(live: Live<S>): S {
    var state by useState(live.value)
    useEffectOnce {
        val watcher = live.watch { state = it }
        cleanup { watcher.stop() }
    }
    return state
}