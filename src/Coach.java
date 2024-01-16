public class Coach extends Person{
    private String team;

    // Constructor
    public Coach(String fName, String lName, String pNumber, String team) {
        super(fName, lName, pNumber);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return super.toString() + " Team: " + team;
    }
}
