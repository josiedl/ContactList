import java.util.ArrayList;

public class ContactList {
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person person) {
        contacts.add(person);
    }
}
