import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**class actor, with its instance variables, constructor initializing each variable, copy constructor, accessors mutators*/
public class Actor extends Artist implements SavableInFile {

    private String birthPlace;
    private int birthYear;
    protected ArrayList<Actor> actors;
    Actor actor;
    //TODO private img type? getter setter, when we create an object it will get its image by path,
                        // so we need also method which will initialze img in that path to our Actor

    public Actor(String firstName, String lastName, ArrayList<Movie> movies, int birthYear, String birthPlace) {
        super(firstName, lastName, movies);
        this.birthPlace = birthPlace;
        this.birthYear = birthYear;
    }

    public Actor(String firstName, String lastName, ArrayList<Movie> movies){
        super(firstName, lastName, movies);
        //birthPlace = "", birthyear = 0
    }

/*    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

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

    protected void readActorsFromScanner(Scanner scanner){
/*        String FN = "";
        String LN = "";
        int year;
        String bP = "";*/
        ArrayList<Movie> actorSmovies = new ArrayList<>(); // TODO we should not create new Movie here
        while (scanner.hasNextLine()){
            while (scanner.nextLine().equals(""))
/*            FN = scanner.next();
            LN = scanner.next();
            year = scanner.nextInt();
            scanner.nextLine();
            bP = scanner.nextLine();
            Actor actor = new Actor(FN, LN, actorSmovies, year, bP);  */

            setFirstName(scanner.next());
            setLastName(scanner.next());
            setBirthYear(scanner.nextInt());
            scanner.nextLine();
            setBirthPlace(scanner.nextLine());

            Actor actor = new Actor(getFirstName(), getLastName(), getMovies(), getBirthYear(),getBirthPlace());
            actors.add(actor);
        }

    }

    private int Age(int birthYear) {
        int year= Calendar.getInstance().get(Calendar.YEAR);
        return (year - birthYear);
    }

    public String toStringNewActor(){
        return "Film with "+ getFirstName() + " " + getLastName()+"\n";
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + "\n" + "Born: " + getBirthYear()  +" (age " + Age(getBirthYear()) +" years)" +
                " in " + birthPlace+"\n";
    }


    @Override
    public boolean readFromFile(String read) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(read));
            readActorsFromScanner(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
