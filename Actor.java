import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**class actor, with its instance variables, constructor initializing each variable, copy constructor, accessors mutators*/
public class Actor extends Artist {

    private String birthPlace;
    private int birthYear;
    private String img_path;



    public Actor(String firstName, String lastName, ArrayList<Movie> movies, int birthYear, String birthPlace/* ,ImageIcon img*/) {
        super(firstName, lastName, movies);
        this.birthPlace = birthPlace;
        this.birthYear = birthYear;
    }

    public Actor(String firstName, String lastName, ArrayList<Movie> movies){
        super(firstName, lastName, movies);
    }

    public Actor() {
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public int getBirthYear() {
        if(birthYear < 0)
            return 0;
        else
            return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if(birthYear < 0)
            this.birthYear = 0;
        else
            this.birthYear = birthYear;

    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    private int Age(int birthYear) {
        int year= Calendar.getInstance().get(Calendar.YEAR);
        return (year - birthYear);
    }

    public String toStringNewActor(){
        return "Films with "+ getFirstName() + " " + getLastName()+"\n";
    }

    public String toStringForActor(){
        return getFirstName() + " " + getLastName() +
                "\n" + "Born: " + getBirthYear()  +
                " (age " + Age(getBirthYear()) +" years)" +
                " in " + birthPlace+"\nFilms with "+getFirstName() + " " + getLastName()+"\n";
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();

    }
}
