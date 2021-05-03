import java.util.ArrayList;

public class Director extends Artist {

    public Director(String firstName, String lastName, ArrayList<Movie> movies) {
        super(firstName, lastName, movies);
    }

    public Director() {
    super();
    }

/*    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/


//    public Director(Director that) {
//        if (that != null) {
//            this.firstname = that.firstname;
//            this.lastname = that.lastname;
//        }
//    }

    public String toStringInMovie(){
        return getFirstName()+" "+getLastName();
    }

    /**
     *
     *
     * @return String return String which contains first name and lastname overriding String method
     */
    @Override
    public String toString() {
        return  "Films directed by "+getFirstName() + " " + getLastName();
    }
}
