import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDemo {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setTitle("MovieDaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setSize(1000,1000);
        frame.setVisible(true);

        //Restful API
        //we should change System.in it will read from txt file
        Scanner scanner = new Scanner(System.in); // Scanner.out
        Scanner  inputStream = null;


        //actor addActor
        ArrayList<Actor> actors = new ArrayList<Actor>();

        while (!inputStream.hasNextLine()){
            try{
                inputStream = new Scanner(new FileInputStream
                        ("C:\\Users\\Kamo\\Desktop\\AUA student\\Freshman Spring 2021\\OOP\\MovieDaran\\src\\Actor.txt"));
            }catch(FileNotFoundException e){
                System.out.println("Problem opening the file");
                System.exit(0);
            }




            String firstName = inputStream.next();
            String lastName = inputStream.next().replace("-"," ");
            int birthYear = inputStream.nextInt();
            String birthPlace = inputStream.nextLine();
            inputStream.nextLine();

           //TODO implementation
        }
        //director adddirector
        ArrayList<Director> directors = new ArrayList<Director>();

// Call("Actor.txt");  Call("Director.txt");


        Movie[] list = new Movie[0]; //here we create Movie empty list will change then ArrayList

        while(true) {
            //new code
            System.out.println("Enter 'a' for adding movie, 'l' to see the list, 'e' to exit");
            try{
                inputStream = new Scanner(new FileInputStream
                                ("C:\\Users\\Acer\\Desktop\\OOPproject\\movielist.txt"));
            }catch(FileNotFoundException e){
                System.out.println("Problem opening the file");
                System.exit(0);
            }
            Movie movie = new Movie();


            String title = inputStream.nextLine();
            movie.setYear(inputStream.nextInt());
            String firstName = inputStream.next();
            String lastName = inputStream.next().replace("-"," ");
            String genre = inputStream.next().trim().toLowerCase().replace("_", " ");
            String duration = inputStream.next();
            String country = inputStream.next();
            inputStream.nextLine();
            String about = inputStream.nextLine();

            list = addMovie(list, title, movie.getYear(), firstName, lastName, genre, duration, country, about);
            System.out.println();



            String str = scanner.nextLine();
            if (str.toLowerCase().equals("a")){

                System.out.println("Type the title of the movie in one line, its release year, " +
                        "director's first name and last name, and the genre on another;");



                //TODO with while loop read cast <=> actor's names
/*                while (true){
                    Actor
                }*/



            }else if (str.equals("l")){
                if (list.length == 0){
                    System.out.println("The list is empty");
                    System.out.println();
                }
                for (int i = 0; i < list.length; i++){
                    System.out.println(list[i]);
                }
                System.out.println();
            }else if (str.toLowerCase().equals("e")){
                System.exit(0);

            }
            break;

        }



        while(!inputStream.hasNextLine()){
            try{
                inputStream = new Scanner(new FileInputStream
                        ("C:\\Users\\Acer\\Desktop\\OOPproject\\Actor.txt"));
            }catch(FileNotFoundException e){
                System.out.println("Problem opening the file");
                System.exit(0);
            }

            while (inputStream.nextLine().equals("")) {
                String firstName = inputStream.next();
                String lastName = inputStream.next();
                int birthYear = inputStream.nextInt();
                inputStream.nextLine();
                String birthPlace = inputStream.nextLine();
                actors = addActor(actors,firstName,lastName,birthYear,birthPlace);
                System.out.println();
            }

        }
        while(!inputStream.hasNextLine()){
            try{
                inputStream = new Scanner(new FileInputStream
                        ("C:\\Users\\Acer\\Desktop\\OOPproject\\Director.txt"));
            }catch(FileNotFoundException e){
                System.out.println("Problem opening the file");
                System.exit(0);
            }


            while (inputStream.nextLine().equals("")) {
                String firstName = inputStream.next();
                String lastName = inputStream.next();
                int birthYear = inputStream.nextInt();
                String birthPlace = inputStream.nextLine();
                directors = addDirector(directors,firstName,lastName,birthYear,birthPlace);
                System.out.println();
            }
        }

    }

    public static Movie[] addMovie(Movie[] list, String title, int year, String firstName,
                                   String lastName, String genre, String duration, String country, /*cast*/ String about){

        Movie m = new Movie(title, year, new Director(firstName, lastName), Movie.Genre.fromString(genre), duration,  country, about);

        Movie[] newList = new Movie[list.length + 1];

        for (int i = 0; i < list.length; i++){
            newList[i] = list[i];
        }

        newList[list.length] = m;

        return  newList;
    }

    public static ArrayList<Actor> addActor(ArrayList<Actor> actors, String firstName, String lastName, int birthYear, String birthPlace/*Movies*/){
        Actor a = new Actor(firstName,lastName, birthYear, birthPlace);
        ArrayList<Actor> new_actors = new ArrayList<Actor>(actors.size()+1);
        for(int i = 0; i < actors.size(); i++){
            new_actors.add(actors.get(i)); // does it add to the array?
        }

        new_actors.set(actors.size(), a);

        return new_actors;
    }

    public static ArrayList<Director> addDirector(ArrayList<Director> directors, String firstName, String lastName, int birthYear, String birthPlace/*Movies*/){
        Director d = new Director(firstName,lastName, birthYear, birthPlace);
        ArrayList<Director> new_directors = new ArrayList<Director>(directors.size()+1);
        for(int i = 0; i < directors.size(); i++){
            new_directors.get(i) = directors.get(i); // new_director.add(directors.get(i));
        }

        new_directors.set(directors.size(), d);

        return new_directors;
    }

}


