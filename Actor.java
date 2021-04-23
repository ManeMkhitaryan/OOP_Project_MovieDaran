import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**class actor, with its instance variables, constructor initializing each variable, copy constructor, accessors mutators*/
public class Actor extends Artist {
    private String birthPlace;
    ArrayList<Movie> actor; // [
    //[firstName,lastName,birthYear,about]
    //                      [first,last,birthYear,about,first,last,birthYear,about]
    // ]




    @Override
    public void name() {

    }

    public Actor(String firstName, String lastName, int birthYear, String birthPlace) {
        super(firstName, lastName, birthYear);
        this.birthPlace = birthPlace;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

/*    public Actor(Actor that){
        if(that != null){
            this.firstName = that.firstName;
            this.lastName = that.lastName;
            this.birthYear = that.birthYear;
            this.birthPlace = that.birthPlace;
        }
    }*/





    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }


    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + "\n" + "Born: " + getBirthYear()  +" (age " + getAge() +" years)" +
                " in " + birthPlace;
    }
}
