// ContactList by Josie Lee

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

    public void printMenu() {
        System.out.println("Menu:" +
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
        System.out.println("Welcome to your Contacts List" +
                        "\nPlease pick from the following menu options");
        Scanner scan = new Scanner(System.in);
        int answer = 10;
        while (answer != 0) {
            printMenu();
            answer = scan.nextInt();
            scan.nextLine();
            // User selects 1 from menu
            if (answer == 1) {
                System.out.println("Select a type of contact to add:" +
                                    "\n1. Student" +
                                    "\n2. Coach");
                int type = scan.nextInt();
                scan.nextLine();
                System.out.println("Please fill in the following information.");
                System.out.println("First Name:");
                String firstName = scan.nextLine();
                System.out.println("Last Name:");
                String lastName = scan.nextLine();
                System.out.println("Phone Number:");
                String phoneNumber = scan.nextLine();
                if (type == 1) {
                    System.out.println("Grade:");
                    int grade = scan.nextInt();
                    Student s = new Student(firstName, lastName, phoneNumber, grade);
                    addContact(s);
                }
                else {
                    System.out.println("Team:");
                    String team = scan.nextLine();
                    Coach c = new Coach(firstName, lastName, phoneNumber, team);
                    addContact(c);
                }
            }

            // User selects 2 from menu
            else if (answer == 2) {
                sort(0);
                for (Person p : contacts) {
                    System.out.println(p.getFirstName());
                }
            }

            // User selects 3 from menu
            else if (answer == 3) {
                sort(1);
                for (Person p : contacts) {
                    System.out.println(p.getLastName());
                }
            }

            // User selects 4 from menu
            else if (answer == 4) {
                sort(2);
                for (Person p : contacts) {
                    System.out.println(p.getPhoneNumber());
                }
            }

            // User selects 5 from menu
            else if (answer == 5) {
                listStudents();
            }

            // User selects 6 from menu
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

            // User selects 7 from menu
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

            // User selects 8 from menu
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
            else if (answer == 0) {
                break;
            }
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
