package live.internal

import functions.Consumer
import koncurrent.Executor
import koncurrent.Executors
import live.Live
import live.WatchMode
import live.Watcher

internal abstract class AbstractLive<out S> : Live<S> {

    abstract override fun watch(callback: (state: S) -> Unit, mode: WatchMode?, executor: Executor?): Watcher

    override fun watch(consumer: Consumer<@UnsafeVariance S>) = watch(consumer::accept, null, null)

    override fun watch(consumer: Consumer<@UnsafeVariance S>, executor: Executor) = watch(consumer::accept, null, null)

    override fun watch(consumer: Consumer<@UnsafeVariance S>, mode: WatchMode) = watch(consumer::accept, null, null)

    override fun watch(consumer: Consumer<@UnsafeVariance S>, mode: WatchMode, executor: Executor) = watch(callback = consumer::accept, mode, executor)
}