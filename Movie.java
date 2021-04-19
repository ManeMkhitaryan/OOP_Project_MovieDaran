/***
 * added -instance variables Actor actor, year,duration,country, added their accessors and mutators
 * initialized in constructors, changed Movie.Genre - Genre
 * */

public class Movie {
    private Actor actor;
    private Director director;
    private Genre genre;
    private int year;
    private int duration;
    private String country;
    private String title;

    public Movie(Actor actor, Director director, Genre genre, int year,
                 int duration, String country, String title) {
        this.actor = actor;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.country = country;
        this.title = title;
    }

    /**
     * Copy constructor which copies the values of the instance variables of given <code> Movie </code> object
     * @param otherMovie new <code> Movie </code> object
     */
    public Movie(Movie otherMovie) {
        if (otherMovie == null) {
            System.out.println("Fatal error");
            System.exit(0);
        }
        actor = new Actor(otherMovie.actor);
        genre = otherMovie.genre;
        director = new Director(otherMovie.director);
        year = otherMovie.year;
        duration = otherMovie.duration;
        country = otherMovie.country;
        title = otherMovie.title;

    }

    public int getYear() {
        if(year < 0 || year > 2021)
            return 0;
        else
            return year;

    }

    public void setYear(int year) {
        if(year < 0 || year > 2021)
            this.year = 2021;
        else
            this.year = year;

    }

    public int getDuration() {
        if(duration < 0)
            return 0;
        else
            return duration;

    }

    public void setDuration(int duration) {
       if(duration < 0)
           this.duration = 0;
       else
           this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Actor getActor() {
        return new Actor(actor);
    }

    public void setActor(Actor actor) {
        this.actor = new Actor(actor);
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public Director getDirector() {
        return new Director(director);
    }


    public void setDirector(Director director) {
        this.director = new Director(director);
    }

    public void setGenre(String genre) {
        for(Genre element: Genre.values()) {
            if (genre.trim().replace(' ','_').equalsIgnoreCase(element.toString())) {
                this.genre = element;
            }
        }
    }


    public String toString() {
        String directorString;
        String genreString;

        if (director == null) {
            directorString = "null";
        } else {
            directorString = director.toString();
        }
        if (genre == null) {
            genreString = "null";
        } else {
            genreString = genre.name().toLowerCase().replace('_',' ');
        }

        if(genreString.equalsIgnoreCase("action")) {
            return "\"" +  "\"," + " an " + genreString + " from "  + " by " + directorString;
        } else {
            return "\"" + "\"," + " a " + genreString + " from " +  " by " + directorString;
        }
    }






}
