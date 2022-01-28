import expect.expect
import expect.requireFromRootDir
import live.mutableLiveOf
import live.value
import kotlin.test.Ignore
import kotlin.test.Test

@Ignore
class InteroperabilityTest {
    val it: IndexTest get() = TODO() //requireFromRootDir<IndexTest>("mvivm/live/core/src/jsTest/resources/IndexTest.js")

    val live = mutableLiveOf(123)

    @Test
    fun should_be_able_to_run() {
        expect(1 + 1).toBe(2)
    }

    @Test
    fun should_be_able_to_consume_live() {
        it.consumeLive(live)
    }

    @Test
    fun should_be_able_to_watch_a_live() {
        it.canWatchALive(live)
        live.value = 456
        live.value = 789
    }

    @Test
    fun should_be_able_to_peek_a_live() {
        it.canPeekALive(live)
        live.value = 456
        live.value = 789
    }

    @Test
    fun should_be_able_to_change_value_from_js() {
        it.canChangeValueFromJs(live)
        console.log(live)
        expect(live.value).toBe(444)
    }
}