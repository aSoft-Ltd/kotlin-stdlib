import expect.expect
import live.WATCH_MODE
import live.WatchMode
import live.liveOf
import live.mutableLiveOf
import kotlin.test.Test

class InteroperabilityTest {

    @Test
    fun should_be_able_to_get_a_live_value() {
        val live = mutableLiveOf(123)
        globalThis.live = live
        val value: Int = globalThis.live.value
        expect(value).toBe(123)
    }

    @Test
    fun should_be_able_to_watch_a_live_casually() {
        val pLive = mutableLiveOf(1234)
        globalThis.live = pLive
        val live = globalThis.live
        var number = 0
        live.watch(WATCH_MODE.CASUALLY) { int: Int ->
            number = int
            console.log("Watching: $int")
        }
        expect(number).toBe(0)
        live.value = 456
        expect(number).toBe(456)
        live.value = 789

        val value: Int = live.value
        expect(value).toBe(789)
    }

    @Test
    fun should_be_able_to_watch_a_live_eagerly() {
        val pLive = liveOf(1234)
        globalThis.live = pLive
        val live = globalThis.live
        var number: Int = 0
        live.watch(WATCH_MODE.EAGERLY) { int: Int ->
            number = int
            console.log("Watching")
        }
        expect(number).toBe(1234)
        live.value = 456
        live.value = 789
    }
}