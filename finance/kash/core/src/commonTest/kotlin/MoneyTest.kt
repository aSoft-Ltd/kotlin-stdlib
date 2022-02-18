import expect.expect
import kash.Money
import kash.TZS
import kash.UGX
import kash.USD
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class MoneyTest {
    @Test
    fun should_equal() {
        val m = 45.TZS
        println(m)
        println(Json.encodeToString(Money.serializer(), m))
    }

    @Test
    fun should_deserialize_correctly() {
        val json = """{"amount":50000,"currency":"TZS"}"""
        val money = Json.decodeFromString<Money>(json)
        expect(money).toBe(500.TZS)
        expect("TZS 500").toBe(money.toLongString())
    }

    @Test
    fun should_print_usd_correctly() {
        assertEquals("US$ 3", 3.00.USD.toLongString())
        assertEquals("US$ 3.15", 3.15.USD.toLongString())
        assertEquals("USh 4.49", 4.49.UGX.toLongString())
    }
}