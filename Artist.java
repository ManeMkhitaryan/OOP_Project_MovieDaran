import java.util.ArrayList;
import java.util.Calendar;


public abstract class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int age;
    private ArrayList<Movie> movies;

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


//    public Artist() {
//
//    }

    public abstract void name();


    public Artist(String firstName, String lastName, int birthYear, int age, ArrayList<Movie> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.age = age;
        this.movies = movies;
    }



    public Artist(String firstName, String lastName, ArrayList<Movie> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = movies;
    }

    private int Date(int birthYear) {
        int year=Calendar.getInstance().get(Calendar.YEAR);
        setAge(year - birthYear);
        return getAge();

    } // is it possible?

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

     public int getBirthYear() {
        if(birthYear < 0)
            return 0;
        else
            return birthYear;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) {
        if(birthYear < 0)
            this.birthYear = 0;
        else
            this.birthYear = birthYear;

    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
