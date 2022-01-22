package live

expect class Live<S>(state: S) {
    var value: S
    fun watch(ignoreImmediateValue: Boolean = false, callable: (state: S) -> Unit): Watcher<S>
    fun stop(watcher: Watcher<S>): Boolean
    fun stopAll()
}