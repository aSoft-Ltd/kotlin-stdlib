package viewmodel

import viewmodel.CounterViewModel.State

class CounterViewModel : ViewModel<State>(State(0)) {

    data class State(val value: Int)

    val countState get() = ui.value.value

    fun countUp(by: Int) {
        repeat(by) {
            ui.value = State(ui.value.value + 1)
        }
    }

    fun countDown(by: Int) {
        repeat(by) {
            ui.value = State(ui.value.value - 1)
        }
    }
}