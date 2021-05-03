import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Cinema_MovieDaran {

    public static void main(String[] args) {

        Scanner  inputStream = null;

        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Director> directors = new ArrayList<>();

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


        System.out.println(searchMovieByTitle("The GodFather", movies));




        //System.out.println(actors.size());

/*        for (Actor actor: actors){
            if (actor.getBirthYear() == 0) {
                System.out.println(actor.toStringNewActor());
                for (Movie movie: actor.getMovies()){
                    System.out.println(movie.toStringinList());
                }
            }
            else{
                System.out.println(actor.toStringForActor());
                for (Movie movie: actor.getMovies()){
                    System.out.println(movie.toStringinList());
                }
                System.out.println(actor.getImg_path());
            }

        }*/

/*        for (Movie movie: movies){
            System.out.println(movie.toString()+"\n");
            System.out.println(movie.getImg_path());
        }*/

        //int year= Calendar.getInstance().get(Calendar.YEAR);


/*        for (Movie movie: movies){
            System.out.println(movie.toString()+"\n");
            System.out.println(movie.getImg_path());
        }*/

/*        for (Movie movie: newMovies){
            System.out.println(movie.toString()+"\n");
        }*/



/*        for (Director director: directors){
            System.out.println(director.toString());
            for (Movie movie: director.getMovies()){
                System.out.println(movie.toStringinList());
            }

        }*/


    }

    public static Movie searchMovieByTitle(String title, ArrayList<Movie> movies){
        for (Movie movie: movies){
            if (title.equals(movie.getTitle())){
                return movie;
            }else {
                System.out.println("Movie is not found");
            }
        }
        return null;
    }

}
