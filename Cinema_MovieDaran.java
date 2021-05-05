import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Cinema_MovieDaran extends JFrame {
        public static ArrayList<Actor> actors = new ArrayList<>();
        public static ArrayList<Movie> movies = new ArrayList<>();
        public static ArrayList<Director> directors = new ArrayList<>();
/*    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(Actor actor) {
        this.actors.add(actor);
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }*/
    public static void main(String[] args) {
        Scanner  inputStream = null;


        try{
            inputStream = new Scanner(new FileInputStream
                    ("C:\\Users\\Kamo\\Desktop\\AUA student\\Freshman Spring 2021\\OOP\\MovieDaran\\src\\Actor.txt"));
        }catch(FileNotFoundException e){
            System.out.println("Problem opening the file");
            System.exit(0);
        }

        while (inputStream.hasNextLine()) {
            String string = "";
            while (!string.equals("End")) {
                String firstName = inputStream.next();
                String lastName = inputStream.next().replace("-"," ");
                int year = inputStream.nextInt();
                String birthPlace = inputStream.nextLine();
                String img_path = inputStream.nextLine();
                string = inputStream.nextLine();

                ArrayList<Movie> actorSmovies = new ArrayList<>();

                Actor actor = new Actor(firstName, lastName, actorSmovies, year, birthPlace);
                actor.setImg_path(img_path);

                actors.add(actor);
            }
        }

        try{
            inputStream = new Scanner(new FileInputStream
                    ("C:\\Users\\Kamo\\Desktop\\AUA student\\Freshman Spring 2021\\OOP\\MovieDaran\\src\\movielist.txt"));
        }catch(FileNotFoundException e){
            System.out.println("Problem opening the file");
            System.exit(0);
        }

        while (inputStream.hasNextLine()){
            String string = "";
            while (!string.equals("End")) {
                String title = inputStream.nextLine();
                int year = inputStream.nextInt();
                String director_FN = inputStream.next();
                String director_LN = inputStream.next().replace("-"," ");

                ArrayList<Movie> directorSmovies = new ArrayList<>();
                Director director = new Director(director_FN, director_LN, directorSmovies);

                String genre = inputStream.next().trim().toLowerCase().replace("_", " ");
                String duration = inputStream.next();
                String country = inputStream.nextLine();
                String line = inputStream.nextLine();

                ArrayList<Actor> cast = new ArrayList<>();
                while (!line.equals("")){
                    String[] NameSurname = line.split("\\s+");
                    String actor_FN = NameSurname[0];
                    String actor_LN = NameSurname[1];
                    actor_LN = actor_LN.replace("-"," ");

                    while (true) {
                        String prompt = "";
                        for (int i = 0; i < actors.size(); i++) {
                            if (actor_FN.equals(actors.get(i).getFirstName()) && actor_LN.equals(actors.get(i).getLastName())) {
                                cast.add(actors.get(i));
                                prompt = "actor_added";
                                break;
                            }
                        }
                        if (!prompt.equals("actor_added")) {
                            ArrayList<Movie> actorSmoives = new ArrayList<>();
                            Actor actor = new Actor(actor_FN, actor_LN, actorSmoives);
                            cast.add(actor);
                            actors.add(actor);
                            break;
                        }
                        break;
                    }

                    line = inputStream.nextLine();
                }

                String about = inputStream.nextLine();
                String img_path = inputStream.nextLine();
                string = inputStream.nextLine();


                Movie movie = new Movie(title, year, director, Movie.Genre.fromString(genre), duration, country, cast, about);
                movie.setImg_path(img_path);
                movies.add(movie);

                director.addMovie(movie);
                directors.add(director);

                for (Actor actor: cast){
                    actor.addMovie(movie);
                }
            }
        }

        // Here we created newMovie array which has same movies as movies array, the only difference is that newmovies shows recent movies first
        Movie temp;
        ArrayList<Movie> newMovies = movies;

        for (int i = 0; i < movies.size(); i++){
            for (int j = i + 1; j < movies.size(); j++){
                if (newMovies.get(i).getYear() < newMovies.get(j).getYear()){
                    temp = newMovies.get(i);
                    newMovies.set(i,  newMovies.get(j));
                    newMovies.set(j, temp);
                }
            }
        }


        System.out.println(searchMovieByTitle("Maleficent", movies)); //Search check



//1. Checking actor's data. Note there are two kinds of actors, which are in txt file and which were added from movies

/*        for (Actor actor: actors){
            if (actor.getBirthYear() == 0) {
                System.out.println(actor.toStringNewActor());
                for (Movie movie: actor.getMovies()){
                    System.out.println(movie.toStringinList()+"\n");
                }
            }

            else{
                System.out.println(actor.getImg_path()+"\n");
                System.out.println(actor.toStringForActor());
                for (Movie movie: actor.getMovies()){
                    System.out.println(movie.toStringinList()+"\n");
                }

            }

        }*/


//2. Checking data of movies. Movies will be displayed in 2 ways only with their image and title. Or with their whole information

        //2.1 Movie with full desctiption
/*        for (Movie movie: movies){
            System.out.println(movie.getImg_path());
            System.out.println(movie.toString()+"\n");
        }*/

        //2.2 Movie in the list
/*        for (Movie movie: movies){
            System.out.println("C:\\Users\\Kamo\\Desktop\\AUA student\\Freshman Spring 2021\\OOP\\MovieDaran\\src\\"+movie.getImg_path());
            System.out.println(movie.getTitle()+"\n");
        }*/

        //2.3 Checking NewMovies
/*        for (Movie movie: newMovies){
            System.out.println(movie.toString()+"\n");
        }*/


//3 Checking data of Directors, again there are 2 ways of displaying directors one inside the Movie then the other which will display director's name and his movies

        //3.1 Displaying directors with their movies
/*        for (Director director: directors){
            System.out.println(director.toString());
            for (Movie movie: director.getMovies()){
                System.out.println(movie.toStringinList());
            }

        }*/
        //3.2 Directors in the movies.. you already saw in movies

/*
    new Cinema_MovieDaran(); //Dismiss this comments
*/
    }

/*    public Cinema_MovieDaran(){ //Dismiss this comments
        //initComponents();
        GridBagConstraints gbc = new GridBagConstraints(); //The GridBagConstraints class specifies constraints
                                                            // for components that are laid out using the GridBagLayout class.
        gbc.insets = new Insets(20, 20,20,20); //This field specifies the external padding of
                                                    // the component, the minimum amount of space between the component and the edges of its display area.

        int x = 0; //columns
        int y = 0;
        for (int i = 0; i < movies.size(); i++){
            gbc.gridx = x;
            gbc.gridy = y;
            Cinema_MovieDaran.add(movies.get(i), gbc);
            x++;
            if (x == 3){
                x=0;
                y++;
            }
        }


    }*/


/*    Cinema_MovieDaran(){ //Dismiss this comments
        JList<Movie> displayMovies = new JList<>(movies.toArray(new Movie[0]));
        JScrollPane scrollPane = new JScrollPane(displayMovies);

        getContentPane().add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }*/

// Search Option available in console
    public static Movie searchMovieByTitle(String title, ArrayList<Movie> movies) {
        while (true) {
            String prompt = "";
            for (Movie movie : movies) {
                if (title.equalsIgnoreCase(movie.getTitle())) {
                    prompt = "movie_found";
                    return movie;
                }

            }
            if (!prompt.equals("movie_found")) {
                System.out.println("Movie is not found");
                break;
            }
        break;
        }
        return null;
    }

}
