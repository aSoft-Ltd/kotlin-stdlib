package live

import koncurrent.Executor
import koncurrent.Executors

//inline fun <S> Live<S>.watch(
//    mode: WatchMode? = null,
//    executor: Executor? = null,
//    noinline callback: (state: S) -> Unit
//): Watcher = when {
//    mode != null && executor != null -> watch(callback, mode, executor)
//    mode != null && executor == null -> watch(callback, mode)
//    mode == null && executor != null -> watch(callback, executor)
//    mode == null && executor == null -> watch(callback)
//    else -> watch(callback)
//}

inline fun <S> Live<S>.watch(
    mode: WatchMode,
    executor: Executor,
    noinline callback: (state: S) -> Unit
): Watcher = watch(callback, mode, executor)

inline fun <S> Live<S>.watch(
    mode: WatchMode,
    noinline callback: (state: S) -> Unit
): Watcher = watch(callback, mode)

inline fun <S> Live<S>.watch(
    executor: Executor,
    noinline callback: (state: S) -> Unit
): Watcher = watch(callback, executor)

inline fun <S> Live<S>.watch(
    noinline callback: (state: S) -> Unit
): Watcher = watch(callback)