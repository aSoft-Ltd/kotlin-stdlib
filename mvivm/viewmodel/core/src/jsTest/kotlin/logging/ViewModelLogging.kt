@file:Suppress("PackageDirectoryMismatch")

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import logging.ConsoleAppender
import logging.Logger
import logging.TodoViewModel
import logging.TodoViewModel.Intent
import viewmodel.ViewModelConfig
import kotlin.test.Test

class ViewModelLogging {
    val config = ViewModelConfig(logger = Logger(ConsoleAppender()), builder = { CoroutineScope(SupervisorJob()) })

    @Test
    fun should_print_logging_output() = runTest {
        val vm = TodoViewModel(config)
        delay(50)
        vm.post(Intent.ReInit)
    }
}