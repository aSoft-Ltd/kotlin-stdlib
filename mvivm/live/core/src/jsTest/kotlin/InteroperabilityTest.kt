import expect.expect
import live.liveOf
import live.mutableLiveOf
import kotlin.test.Test

class InteroperabilityTest {

    @Test
    fun should_be_able_to_consume_live() {
        val live = mutableLiveOf(123)
        globalThis.live = live
        val value: Int = globalThis.live.value
        expect(value).toBe(123)
    }

    @Test
    fun should_be_able_to_watch_a_live() {
        val pLive = mutableLiveOf(1234)
        globalThis.live = pLive
        val live = globalThis.live
        live.watch { int -> console.log("Watching: $int") }
        live.value = 456
        live.value = 789

        val value: Int = live.value
        expect(value).toBe(789)
    }

    @Test
    fun should_be_able_to_peek_a_live() {
        val pLive = liveOf(1234)
        globalThis.live = pLive
        val live = globalThis.live
        live.peek { int -> console.log("Peeking: $int") }
        live.value = 456
        live.value = 789
    }
}