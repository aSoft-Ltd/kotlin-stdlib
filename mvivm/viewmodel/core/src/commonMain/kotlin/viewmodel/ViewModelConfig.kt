@file:Suppress("NON_EXPORTABLE_TYPE", "WRONG_EXPORTED_DECLARATION")

package viewmodel

import functions.Function
import koncurrent.Executor
import live.SynchronousExecutor
import logging.ConsoleAppender
import logging.Logger
import viewmodel.internal.ViewModelConfigImpl
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.*

@JsExport
interface ViewModelConfig<out S> {
    val initial: S
    val executor: Executor
    val logger: Logger

    @JsName("_ignore_map")
    fun <R> map(transform: Function<S, R>): ViewModelConfig<R>

    @JvmSynthetic
    fun <R> map(transform: (S) -> R): ViewModelConfig<R>

    companion object {
        @JvmField
        val DEFAULT_LOGGER = Logger(ConsoleAppender())

        @JvmField
        val DEFAULT_EXECUTOR = SynchronousExecutor.Default

        @JsName("of")
        @JvmName("create")
        @JvmOverloads
        @JvmStatic
        operator fun <S> invoke(
            initial: S,
            executor: Executor = DEFAULT_EXECUTOR,
            logger: Logger = DEFAULT_LOGGER
        ): ViewModelConfig<S> = ViewModelConfigImpl(initial, executor, logger)

        @JsName("create")
        @JvmName("create")
        @JvmOverloads
        @JvmStatic
        operator fun invoke(
            executor: Executor = DEFAULT_EXECUTOR,
            logger: Logger = DEFAULT_LOGGER
        ): ViewModelConfig<*> = ViewModelConfigImpl(initial = Unit, executor, logger)
    }
}