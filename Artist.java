import java.util.ArrayList;

public abstract class Artist {
    private String firstName;
    private String lastName;
    protected ArrayList<Movie> movies;

    public Artist() {
        firstName = "";
        lastName = "";
        movies = new ArrayList<>();
    }

    public Artist(String firstName, String lastName, ArrayList<Movie> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = movies;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
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


    void addMovie(Movie movie){
        movies.add(movie);
    }
    //TODO with copy constructor? or just movie

    //clone if needed
}
