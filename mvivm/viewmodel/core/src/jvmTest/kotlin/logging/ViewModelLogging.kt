@file:Suppress("PackageDirectoryMismatch")

import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import logging.ConsoleAppender
import logging.TodoViewModel
import logging.TodoViewModel.Intent
import viewmodel.expect
import kotlin.test.Test

class ViewModelLogging {
    @Test
    fun should_print_logging_output() = runTest {
        val vm = TodoViewModel()
        delay(50)
        vm.expect(Intent.ReInit).toGoThrough(TodoViewModel.State.Init)
    }
}