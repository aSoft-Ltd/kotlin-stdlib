package live

expect interface Live<out S> {

    companion object {
        operator fun <S> invoke(value: S): Live<S>
    }

    val value: S

    fun watch(ignoreImmediateValue: Boolean, callable: (state: S) -> Unit): Watcher<*>

    fun watch(callable: (state: S) -> Unit): Watcher<*>

    fun stopAll()
}