import java.util.Calendar;
import java.util.Date;

public abstract class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Artist() {

    }

    public abstract void name();

    public Artist(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = Date(birthYear);
    }

    private int Date(int birthYear) {
        int year=Calendar.getInstance().get(Calendar.YEAR);;
        int currentYear= year - birthYear;
        return currentYear;

    }

    String getFirstName(){
        return firstName;
    }
    String getLastName(){
        return lastName;
    }
    int birthYear(){
        return birthYear;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int birthYear) {
        this.birthYear = birthYear;
    }
}
