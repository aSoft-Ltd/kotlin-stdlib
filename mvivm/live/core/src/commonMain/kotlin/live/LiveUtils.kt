package live

internal fun <S> Live<S>.watch(watchers: MutableList<Watcher<S>>, callable: (S) -> Unit): Watcher<S> {
    val watcher = Watcher(callable, watchers)
    watchers.add(watcher)
    callable(value)
    return watcher
}