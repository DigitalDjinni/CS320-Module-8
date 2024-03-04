import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test the creation of a Contact object with valid parameters
    @Test
    public void createContactTest() {
        Contact contact = new Contact("ID0001", "Joe", "Rogan", "1234567890", "123 Elk Street");
        assertNotNull(contact);
        assertEquals("ID0001", contact.getContactID());
        assertEquals("Joe", contact.getFirstName());
        assertEquals("Rogan", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elk Street", contact.getAddress());

    }

    // IllegalArgumentException is thrown when Contact ID is null
    @Test
    public void testInvalidContactID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Joe", "Rogan", "1234567890", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when Contact ID is too long
    @Test
    public void testInvalidContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID00000000000001", "Joe", "Rogan", "1234567890", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when firstName is null
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", null, "Rogan", "1234567890", "123 Elk Street");
        });

    }

    // IllegalArgumentException is thrown when firstName is too long
    @Test
    public void testInvalidFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "MyNameIsJoesephIMeanJoe", "Rogan", "1234567890", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when lastName is null
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", null, "1234567890", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when lastName is too long
    @Test
    public void testInvalidLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", "TotallyIsNotRogan", "1234567890", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when phoneNumber is null
    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", "Rogan", null, "123 Elk Street");
        });

    }

    // IllegalArgumentException is thrown when phoneNumber is not all digits
    @Test
    public void testInvalidPhoneNumberWithCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", "Rogan", "abc123", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when phoneNumber is too short
    @Test
    public void testInvalidPhoneNumberTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", "Rogan", "12345", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when phoneNumber is too long
    @Test
    public void testInvalidPhoneNumberTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", "Rogan", "123456789012", "123 Elk Street");
        });
    }

    // IllegalArgumentException is thrown when address is null
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", "Rogan", "1234567890", null);
        });
    }

    // IllegalArgumentException is thrown when address is too long
    @Test
    public void testInvalidAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0001", "Joe", "Rogan", "1234567890",
                    "123 Totally Super Long Address That Is Totally A Legit Place Of Existance Somewhere In The World");
        });
    }

}
