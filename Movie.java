import java.util.ArrayList;

/**
 * added -instance variables Actor actor, year,duration,country, added their accessors and mutators
 * initialized in constructors, changed Movie.Movie.Genre - Movie.Genre
 * */

public class Movie {

    public enum Genre {
        ACTION,ADVENTURE,THRILLER,MARTIAL_ARTS, HORROR,MELODRAMA,COMEDY,DRAMA,HISTORICAL,ROMANCE,DOCUMENTARY,SCIENCE_FICTION, CRIME_FILM, WESTERN;
        public static Genre fromString(String s){
            ArrayList<Genre> genres = new ArrayList<>();

            if (s.equals("comedy")) {
                return COMEDY;
            } else if (s.equals("horror")){
                return HORROR;
            }else if (s.equals("drama")) {
                return DRAMA;
            }else if (s.equals("action")){
                return ACTION;
            }else if (s.equals("adventure")){
                return ADVENTURE;
            }else if (s.equals("thriller")){
                return THRILLER;
            }else if (s.equals("martial_arts")){
                return MARTIAL_ARTS;
            }else if (s.equals("melodrama")){
                return MELODRAMA;
            }else if (s.equals("historical")){
                return HISTORICAL;
            }else if (s.equals("romance")){
                return ROMANCE;
            }else if (s.equals("crime film")) {
                return CRIME_FILM;
            }else if (s.equals("western")) {
                return WESTERN;
            }else if (s.equals("science_fiction")){
                return SCIENCE_FICTION;
            } else if (s.equals("documentary")){
                return DOCUMENTARY;
            } else {
                return null;
            }
        }

    }

    private String title;
    private int year;
    private Director director;
    private Genre genre;
    private String duration;
    private String country;
    private ArrayList<Actor> cast;
    private String about;
    private String img_path;
    //TODO Imageicon as an instance variable

    public Movie(){

    }

    /**
     *
     *
     * @param title first instance variable the title of the Movie
     * @param year second instance variable the year of the Movie
     * @param director third instance variable the director of the Movie
     * @param genre forth instance variable the genre of the Movie
     */
    public Movie(String title, int year, Director director, Genre genre, String duration, String country, ArrayList<Actor> cast, String about) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.genre = genre;
        this.duration = duration;
        this.country = country;
        this.cast = cast;
        this.about = about;

    }

    /**
     *
     * @param otherMovie is the copy of Movie class by copy constructor copy its content
     */
    public Movie(Movie otherMovie){
        if (otherMovie != null) {
            this.title = otherMovie.title;
            this.year = otherMovie.year;
            this.director = otherMovie.director;
            this.genre = otherMovie.genre;
            this.duration = otherMovie.duration;
            this.country = otherMovie.country;
            this.cast = otherMovie.cast;
            this.about = otherMovie.about;

        }else {
            System.out.println("Fatal error");
            System.exit(0);
        }
    }

    /**
     *
     * @return get and set (by the user) the title, year director and genre of the movie
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        if (year < 0 || year > 2021)
            return 2021;
        else
            return year;
    }

    public void setYear(int year) {
        if (year < 0 || year > 2021)
            this.year = 2021;
        else
            this.year = year;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Director getDirector() {

        return director;
    }

    /**
     *
     * @return Genre, return the genre of the movie
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     *
     * @param genre set genre by the user
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }



    public String getDuration() {

        return duration;
    }

    public void setDuration(String duration) {

        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public ArrayList<Actor> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Actor> cast) {
        this.cast = cast;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    //}
    //TODO second toString for lists <=> Image and name only
    /**
     *
     * @return String return String with this form (‘‘A Beautiful Mind’’, a drama from 2004 by Ron Howard)
     */
    @Override
    public String toString() {
        return  "Title: \t" + title + "\n" +
                "Year: \t" + year + "\n" +
                "Country: \t" + country + "\n" +
                "Director: \t" + director.toStringInMovie() + "\n" +
                "Genre: \t" + genre.toString().toLowerCase() + "\n" +
                "Duration: \t" + duration + "\n" +
                "Cast: \t" +  getCast().toString().substring(getCast().toString().indexOf("[")+1, getCast().toString().indexOf("]")) + "\n" +
                "About the film: "+ about;
                //TODO directors and actors have to be clickable
    }

    public String toStringinList(){
        /*img*/
        return "\n"+title+" ";
    }

/*    void addActor(Actor actor){
        if ()
        cast.add()
    }*/
}