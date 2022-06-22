import static expect.Builders.expect;

import identifier.Email;
import identifier.Phone;
import payments.requests.Address;

import org.junit.jupiter.api.Test;

public class AddressJavaTest {
    @Test
    public void should_instantiate_intuitively() {
        var address1 = new Address.LocationWithContacts(
                "Tanzania",
                "Dar Es Salaam",
                "Bunju",
                new Phone(711111122),
                new Email("andy@lamax.net")
        );

        var address2 = new Address.Contacts(
                new Phone("255711111122"),
                new Email("andy@lamax.net")
        );

        expect(address1.getPhone().toString()).toBe(address2.getPhone().toString());
    }
}
