// Coach class is a subclass of Person class
public class Coach extends Person{

    // Instance Variables
    private String team;

    // Constructor
    public Coach(String fName, String lName, String pNumber, String team) {
        super(fName, lName, pNumber);
        this.team = team;
    }

    // Returns team
    public String getTeam() {
        return team;
    }

    // Sets team to a new given team
    public void setTeam(String team) {
        this.team = team;
    }

    // Returns contact information, overrides Person class' toString
    @Override
    public String toString() {
        return super.toString() + " Team: " + team;
    }
}
