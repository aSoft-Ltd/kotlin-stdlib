package viewmodel

import expect.BasicExpectation
import kotlin.test.assertEquals
import live.value

interface ViewModelAssertion<S, V : ViewModel<*, S>> : BasicExpectation<V> {
    fun toBeIn(expectedState: S) = assertEquals(expectedState, value.ui.value)
}