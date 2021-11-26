import identifier.Email
import identifier.Phone
import payments.requests.Address
import kotlin.test.Test

class AddressTest {
    @Test
    fun should_instantiate_properly() {
        val address = Address.LocationWithContacts(
            country = "Tanzania",
            city = "Dar es Salaam",
            street = "Kariakoo",
            phone = Phone(752748674),
            email = Email("andy@test.com")
        )
    }
}