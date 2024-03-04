public class Contact {

    private final String contactID; // Final variable for unique contact ID
    private String firstName;       // Variable for the first name
    private String lastName;        // Variable for the last name
    private String phone;           // Variable for the phone number
    private String address;         // Variable for the address

    // Constructor for initializing a new Contact object
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contactID");
        }
        this.contactID = contactID;

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Getter for Contact ID
    public String getContactID() {
        return contactID;
    }

    // Getter for First Name
    public String getFirstName() {
        return firstName;
    }

    // Setter for First Name
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // Getter for Last Name
    public String getLastName() {
        return lastName;
    }

    // Setter for Last Name
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // Getter for Phone
    public String getPhone() {
        return phone;
    }

    // Setter for Phone
    public void setPhone(String phone) {
        String regex = "^[0-9]{10}$";
        if (phone == null || !phone.matches(regex)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    // Getter for Address
    public String getAddress() {
        return address;
    }

    // Setter for Address
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
