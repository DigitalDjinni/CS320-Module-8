import java.util.HashMap;
import java.util.Map;

public class ContactService {
    
    // This map stores contacts and is indexed by their contactID
    private Map<String, Contact> contacts;
    
    // Constructor for initializing the ContactService with an empty map of contacts
    public ContactService(){
        contacts = new HashMap<>();
    }

    // Method to add a new contact
    public void addContact(Contact contact){
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already exists in database");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Method to delete a contact by contactID
    public void deleteContact(String contactID){
        contacts.remove(contactID);
    }

    // Updates the first name of an existing contact
    public void updateFirstName(String contactID, String firstName){
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setFirstName(firstName);
        } else {
            throw new IllegalArgumentException("Contact doesn't exist");
        }
    }

    // Updates the last name of an existing contact
    public void updateLastName(String contactID, String lastName){
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setLastName(lastName);
        } else {
            throw new IllegalArgumentException("Contact doesn't exist");
        }
    }

    // Updates the phone number of an existing contact
    public void updatePhoneNumber(String contactID, String phoneNumber){
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setPhone(phoneNumber);
        } else {
            throw new IllegalArgumentException("Contact doesn't exist");
        }
    }

    // Updates the address of an existing contact
    public void updateAddress(String contactID, String address){
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setAddress(address);
        } else {
            throw new IllegalArgumentException("Contact doesn't exist");
        }
    }

    // Retrieves a contact object by its contactID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
