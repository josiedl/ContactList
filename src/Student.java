public class Student extends Person{
    private int grade;

    // Constructor
    public Student(String fName, String lName, String pNumber, int grade) {
        super(fName, lName, pNumber);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
