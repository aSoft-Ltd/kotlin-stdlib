package viewmodel.internal

import functions.Function
import koncurrent.Executor
import logging.Logger
import viewmodel.ViewModelConfig

class ViewModelConfigImpl<out S>(
    override val initial: S,
    override val executor: Executor,
    override val logger: Logger
) : ViewModelConfig<S> {
    override fun <R> map(transform: Function<S, R>): ViewModelConfig<R> = map(transform::invoke)

    override fun <R> map(transform: (S) -> R): ViewModelConfig<R> = ViewModelConfigImpl(
        transform(initial), executor, logger
    )

    operator fun <R> invoke(initial: R): ViewModelConfig<R> = ViewModelConfigImpl(initial, executor, logger)
}