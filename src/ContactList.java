import java.util.ArrayList;
import java.util.Scanner;

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

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p.toString());
        }
    }

    public void sort(int sortBy) {
        for(int pass = 0; pass < contacts.size()-1; pass++) {
            for(int comp = 0; comp < contacts.size()-1-pass; comp++){
                Person contact1 = contacts.get(comp);
                Person contact2 = contacts.get(comp+1);
                if (sortBy == 0) {
                    if (contact1.getFirstName().compareTo(contact2.getFirstName()) > 0) {
                        Person temp = contact1;
                        contacts.set(comp, contact2);
                        contacts.set(comp+1, contact1);
                    }
                }
                else if (sortBy == 1) {
                    if (contact1.getLastName().compareTo(contact2.getLastName()) > 0) {
                        Person temp = contact1;
                        contacts.set(comp, contact2);
                        contacts.set(comp+1, contact1);
                    }
                }
                else if (sortBy == 2) {
                    if (contact1.getPhoneNumber().compareTo(contact2.getPhoneNumber()) > 0) {
                        Person temp = contact1;
                        contacts.set(comp, contact2);
                        contacts.set(comp+1, contact1);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student) {
                System.out.println(p.toString());
            }
        }
    }

    public void printConsole() {
        System.out.println("Welcome to your Contacts List" +
                            "\nPlease pick from the following menu options" +
                            "\n\nMenu:" +
                            "\n1. Add Contact" +
                            "\n2. List All Contacts By First Name" +
                            "\n3. List All Contacts By Last Name" +
                            "\n4. List All Contacts By Phone Number" +
                            "\n5. List All Students" +
                            "\n6. Search By First Name" +
                            "\n7. Search By Last Name" +
                            "\n8. Search By Phone Number" +
                            "\n0. Exit");
    }

    public void run() {
        printConsole();
        Scanner scan = new Scanner(System.in);
        int answer = 10;
        while (answer != 0) {
            answer = scan.nextInt();

        }
    }

    public static void main(String[] args) {

    }
}
