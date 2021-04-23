/**
 * no changes
 * */

public class Director extends Artist {




    @Override
    public void name() {

    }

    public Director(String firstName, String lastName, int birthYear, String birthPlace) {
        super(firstName, lastName, birthYear);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     *
     * @param that is the copy of Director class, it generates due to copy constructor
     */
//    public Director(Director that) {
//        if (that != null) {
//            this.firstname = that.firstname;
//            this.lastname = that.lastname;
//        }
//    }


    /**
     *
     *
     * @return String return String which contains first name and lastname overriding String method
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + "\n" + "Born: " + getBirthYear()  +" (age " + getAge() +" years)";
    }
}
