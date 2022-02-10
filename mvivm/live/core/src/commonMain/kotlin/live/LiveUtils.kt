package live

internal fun <S> Live<S>.watch(mode: WatchMode, watchers: MutableList<Watcher<S>>, callable: (S) -> Unit): Watcher<S> {
    val watcher = Watcher(callable, watchers)
    watchers.add(watcher)
    if (mode is WatchMode.Eagerly) callable(value)
    return watcher
}