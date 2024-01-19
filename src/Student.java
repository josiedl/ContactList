// Student class is a subclass of Person class
public class Student extends Person{

    // Instance Variables
    private int grade;

    // Constructor
    public Student(String fName, String lName, String pNumber, int grade) {
        super(fName, lName, pNumber);
        this.grade = grade;
    }

    // Returns grade
    public int getGrade() {
        return grade;
    }

    // Sets grade to a new given grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Returns contact information, overrides Person class' toString
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
