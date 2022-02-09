package live

internal fun <S> Live<S>.watch(ignoreImmediateValue: Boolean, watchers: MutableList<Watcher<S>>, callable: (S) -> Unit): Watcher<S> {
    val watcher = Watcher(callable, watchers)
    watchers.add(watcher)
    if (!ignoreImmediateValue) callable(value)
    return watcher
}