package live

import koncurrent.Executor
import koncurrent.Executors

inline fun <S> Live<S>.watch(
    mode: WatchMode = WatchMode.Default,
    executor: Executor = Executors.default(),
    noinline callback: (state: S) -> Unit
): Watcher = watch(callback, mode, executor)