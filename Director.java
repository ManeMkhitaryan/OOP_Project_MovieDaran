/**
 * no changes
 * */

public class Director {
    private String firstname;
    private String lastname;


    /**
     *
     * @param firstname this is first instance variable of Director class which is for Director's first name
     * @param lastname this is second instance variable of Director class which is for Director's last name
     */
    public Director(String firstname, String lastname) {

        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     *
     * @param that is the copy of Director class, it generates due to copy constructor
     */
    public Director(Director that) {
        if (that != null) {
            this.firstname = that.firstname;
            this.lastname = that.lastname;
        }
    }
    /**
     *
     * @return String firstname of director
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname set firstname by the user
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return String the lastname of the director
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname  set lastname by the user
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     *
     * @return String return String which contains first name and lastname overriding String method
     */
    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
