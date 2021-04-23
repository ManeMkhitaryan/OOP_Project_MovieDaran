import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**class actor, with its instance variables, constructor initializing each variable, copy constructor, accessors mutators*/
public class Actor extends Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String aboutActor;
    ArrayList<Movie> actor; // [
    //[firstName,lastName,birthYear,about]
    //                      [first,last,birthYear,about,first,last,birthYear,about]
    // ]




    @Override
    public void name() {

    }

    public Actor(String firstName, String lastName, int birthYear) {
        super(firstName, lastName, birthYear);
    }

    @Override
    int birthYear() {
        return super.birthYear();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Actor(Artist firstName, String lastName, int birthYear, String aboutActor) {
        super();

    }
    public Actor(Actor that){
        if(that != null){
            this.firstName = that.firstName;
            this.lastName = that.lastName;
            this.birthYear = that.birthYear;
            this.aboutActor = that.aboutActor;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        if(birthYear < 0)
            return 0;
        else
            return birthYear;
    }

    public void setAge(int birthYear) {
        if(birthYear < 0)
            this.birthYear = 0;
        else
            this.birthYear = birthYear;

    }

    public String getAboutActor() {
        return aboutActor;
    }

    public void setAboutActor(String aboutActor) {
        this.aboutActor = aboutActor;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" + birthYear +
                "\n" + aboutActor;
    }
}
