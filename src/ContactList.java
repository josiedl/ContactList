// ContactList by Josie Lee

// Import ArrayList and Scanner classes
import java.util.ArrayList;
import java.util.Scanner;

// ContactList class
public class ContactList {

    //Instance Variables
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // Returns entire ContactList
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Adds a new person to ContactList
    public void addContact(Person person) {
        contacts.add(person);
    }

    // Prints all the contacts in ContactList
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p.toString());
        }
    }

    // Sorts all the contacts in ContactList
    public void sort(int sortBy) {
        // For everyone in ContactList
        for(int pass = 0; pass < contacts.size()-1; pass++) {
            for(int comp = 0; comp < contacts.size()-1-pass; comp++){
                // Focus on two people from the ContactList
                Person contact1 = contacts.get(comp);
                Person contact2 = contacts.get(comp+1);
                // If 0 is inputted, compare the two people by first name
                if (sortBy == 0) {
                    // If they are not in alphabetical order, switch them
                    if (contact1.getFirstName().compareTo(contact2.getFirstName()) > 0) {
                        contacts.set(comp, contact2);
                        contacts.set(comp+1, contact1);
                    }
                }
                // If 1 is inputted, compare the two people by last name
                else if (sortBy == 1) {
                    // If they are not in alphabetical order, switch them
                    if (contact1.getLastName().compareTo(contact2.getLastName()) > 0) {
                        contacts.set(comp, contact2);
                        contacts.set(comp+1, contact1);
                    }
                }
                // If 2 is inputted, compare the two people by phone number
                else if (sortBy == 2) {
                    // If they are not in order, switch them
                    if (contact1.getPhoneNumber().compareTo(contact2.getPhoneNumber()) > 0) {
                        contacts.set(comp, contact2);
                        contacts.set(comp+1, contact1);
                    }
                }
            }
        }
    }

    // If an inputted first name is in the ContactList, returns that person, otherwise returns null
    public Person searchByFirstName(String firstName) {
        // For every person in the ContactList, check if they match the given first name
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }

    // If an inputted last name is in the ContactList, returns that person, otherwise returns null
    public Person searchByLastName(String lastName) {
        // For every person in the ContactList, check if they match the given last name
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }

    // If an inputted phone number is in the ContactList, returns that person, otherwise returns null
    public Person searchByPhoneNumber(String phoneNumber) {
        // For every person in the ContactList, check if they match the given phone number
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    // Prints all the contacts of the students in ContactList
    public void listStudents() {
        // For each person in ContactList
        for (Person p : contacts) {
            // If it is a student, print their contact information
            if (p instanceof Student) {
                System.out.println(p.toString());
            }
        }
    }

    // Prints the menu
    public void printMenu() {
        System.out.println("Please pick from the following menu options" +
                            "\nMenu:" +
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

    // Runs the menu options!
    public void run() {
        // Prints introduction
        System.out.println("Welcome to your Contacts List");
        // Create a new scanner
        Scanner scan = new Scanner(System.in);
        // Set answer to 10 to instantiate without triggering menu options
        int answer = 10;
        // While the user does not exit
        while (answer != 0) {
            // Print the menu and prompt user to select task
            printMenu();
            answer = scan.nextInt();
            scan.nextLine();

            // If user selects 1 from menu, add a contact
            if (answer == 1) {
                // Prompt user for a type of contact
                System.out.println("Select a type of contact to add:" +
                                    "\n1. Student" +
                                    "\n2. Coach");
                int type = scan.nextInt();
                scan.nextLine();
                // Ask for information about the person
                System.out.println("Please fill in the following information.");
                System.out.println("First Name:");
                String firstName = scan.nextLine();
                System.out.println("Last Name:");
                String lastName = scan.nextLine();
                System.out.println("Phone Number:");
                String phoneNumber = scan.nextLine();
                // If it is a Student, prompt for a grade
                if (type == 1) {
                    System.out.println("Grade:");
                    int grade = scan.nextInt();
                    // Add new student to ContactList
                    Student s = new Student(firstName, lastName, phoneNumber, grade);
                    addContact(s);
                }
                // If it is a Coach, prompt for a team
                else {
                    System.out.println("Team:");
                    String team = scan.nextLine();
                    // Add new coach to ContactList
                    Coach c = new Coach(firstName, lastName, phoneNumber, team);
                    addContact(c);
                }
            }

            // If user selects 2 from menu, list all the contacts by first names in order
            else if (answer == 2) {
                sort(0);
                for (Person p : contacts) {
                    System.out.println(p.getFirstName());
                }
            }

            // If user selects 3 from menu, list all the contacts by last names in order
            else if (answer == 3) {
                sort(1);
                for (Person p : contacts) {
                    System.out.println(p.getLastName());
                }
            }

            // If user selects 4 from menu, list all the contacts by phone numbers in order
            else if (answer == 4) {
                sort(2);
                for (Person p : contacts) {
                    System.out.println(p.getPhoneNumber());
                }
            }

            // If user selects 5 from menu, list all the contacts of the students in ContactList
            else if (answer == 5) {
                listStudents();
            }

            // If user selects 6 from menu, search for an inputted first name in ContactList
            else if (answer == 6) {
                System.out.println("Enter a name: ");
                String firstName = scan.nextLine();
                if (searchByFirstName(firstName) != null) {
                    System.out.println(searchByFirstName(firstName));
                }
                else {
                    System.out.println(firstName + " is not in the list.");
                }
            }

            // If user selects 7 from menu, search for an inputted last name in ContactList
            else if (answer == 7) {
                System.out.println("Enter a last name: ");
                String lastName = scan.nextLine();
                if (searchByLastName(lastName) != null) {
                    System.out.println(searchByLastName(lastName));
                }
                else {
                    System.out.println(lastName + " is not in the list.");
                }
            }

            // If user selects 8 from menu, search for an inputted phone number in ContactList
            else if (answer == 8) {
                System.out.println("Enter a phone number: ");
                String phoneNumber = scan.nextLine();
                if (searchByPhoneNumber(phoneNumber) != null) {
                    System.out.println(searchByPhoneNumber(phoneNumber));
                }
                else {
                    System.out.println(phoneNumber + " is not in the list.");
                }
            }
            // If user selects 0 from menu, break, and code will exit
            else if (answer == 0) {
                break;
            }
            // If user does not choose a number from the menu, prompt them for a new number
            else {
                System.out.println("Invalid choice, please select a number from the menu.");
            }
        }
    }

    // Main
    public static void main(String[] args) {
        ContactList c = new ContactList();
        c.run();
    }
}
