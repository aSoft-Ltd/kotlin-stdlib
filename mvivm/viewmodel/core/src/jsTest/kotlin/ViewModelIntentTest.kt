import CounterViewModel.Intent
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import viewmodel.ViewModel
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Give a [ViewModel] [CounterViewModel]
 */
class ViewModelIntentTest {
    @Test
    fun state_should_follow_intents() = runTest {
        val vm = CounterViewModel()
        assertEquals(0, vm.countState)
        delay(10)
        vm.post(Intent.CountUp(1))
        assertEquals(1, vm.countState)
    }
}