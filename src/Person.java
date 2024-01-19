// Person superclass
public class Person {

    // Instance Variables
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor
    public Person(String fName, String lName, String pNumber) {
        firstName = fName;
        lastName = lName;
        phoneNumber = pNumber;
    }

    // Returns first name
    public String getFirstName() {
        return firstName;
    }

    // Sets first name to a new given first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Returns last name
    public String getLastName() {
        return lastName;
    }

    // Sets last name to a new given last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Sets phone number to a new given phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Returns contact information, overrides Object superclass' toString
    @Override
    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
