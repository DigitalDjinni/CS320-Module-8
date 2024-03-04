import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    
    // Tests that a new contact can be successfully added to the ContactService
    @Test
    public void testAddContact(){
        ContactService service = new ContactService();
        service.addContact(new Contact("0002", "Bill", "Nye", "1800252220", "432 Space Ave"));
        
        // Verification that the contact is added correctly
        assertNotNull(service.getContact("0002"));
        assertEquals("Bill", service.getContact("0002").getFirstName());
        assertEquals("Nye", service.getContact("0002").getLastName());
        assertEquals("1800252220", service.getContact("0002").getPhone());
        assertEquals("432 Space Ave", service.getContact("0002").getAddress());
    }

    // Tests that adding a duplicate contact ID to the ContactService throws an IllegalArgumentException
    @Test
    public void testAddDuplicateContactID(){
        ContactService service = new ContactService();
        Contact contact1 = new Contact("0002", "Bill", "Nye", "1800252220", "432 Space Ave");
        service.addContact(contact1);

        Contact contact2 = new Contact("0002", "Harry", "Mack", "1800242520", "422 Hip Hop Ave");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    // Verification that the contact is deleted correctly
    @Test
    public void testDeleteContact(){
        ContactService service = new ContactService();
        service.addContact(new Contact("0002", "Bill", "Nye", "1800252220", "432 Space Ave"));
        service.deleteContact("0002");
        assertNull(service.getContact("0002"));
    }

    // Verification that the contact FirstName is updated correctly
    @Test
    public void testUpdateContactFirstName(){
        ContactService service = new ContactService();
        service.addContact(new Contact("0002", "Bill", "Nye", "1800252220", "432 Space Ave"));

        service.updateFirstName("0002", "Marc");
        assertEquals("Marc", service.getContact("0002").getFirstName());
    }

    // Verification that the contact LastName is updated correctly
    @Test
    public void testUpdateContactLastName(){
        ContactService service = new ContactService();
        service.addContact(new Contact("0002", "Bill", "Nye", "1800252220", "432 Space Ave"));

        service.updateLastName("0002", "Gates");
        assertEquals("Gates", service.getContact("0002").getLastName());
    }

    // Verification that the contact Phone Number is updated correctly
    @Test
    public void testUpdateContactPhoneNumber(){
        ContactService service = new ContactService();
        service.addContact(new Contact("0002", "Bill", "Nye", "1798252220", "432 Space Ave"));

        service.updatePhoneNumber("0002", "1798253335");
        assertEquals("1798253335", service.getContact("0002").getPhone());
    }

    // Verification that the contact Address is updated correctly
    @Test
    public void testUpdateContactAddress(){
        ContactService service = new ContactService();
        service.addContact(new Contact("0002", "Bill", "Nye", "1798252220", "432 Space Ave"));

        service.updateAddress("0002", "9 Deep Space");
        assertEquals("9 Deep Space", service.getContact("0002").getAddress());
    }
}

