
import java.util.Scanner;

public class MovieDemo {
    public static void main(String[] args) {
        //we should change System.in it will read from txt file
        Scanner scanner = new Scanner(System.in);

        Movie[] list = new Movie[0];



        while(true) {
            //new code
            System.out.println("Enter 'a' for adding movie, 'l' to see the list, 'e' to exit");

            String str = scanner.nextLine();
            if (str.toLowerCase().equals("a")){

                System.out.println("Type the title of the movie in one line, its release year, " +
                        "director's first name and last name, and the genre on another;");

                String title = scanner.nextLine();
                int year = scanner.nextInt();
                String firstName = scanner.next();
                String lastName = scanner.next().replace("-"," ");
                String genre = scanner.next().trim().toLowerCase().replace("_", " ");
                int duration_hour = scanner.nextInt();
                int duration_min = scanner.nextInt();
                String duration = duration_hour + "h " + duration_min + "min";
                String country = scanner.next();
                //TODO with while loop read cast <=> actor's names
/*                while (true){
                    Actor
                }*/
                scanner.nextLine();
                String about = scanner.nextLine();
                list = addMovie(list, title, year, firstName, lastName, genre, duration, country, about);
                System.out.println();

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

        }

    }

    public static Movie[] addMovie(Movie[] list, String title, int year, String firstName, String lastName, String genre, String duration, String country, /*cast*/ String about){

        Movie m = new Movie(title, year, new Director(firstName, lastName), Movie.Genre.fromString(genre), duration, country, about);

        Movie[] newList = new Movie[list.length + 1];

        for (int i = 0; i < list.length; i++){
            newList[i] = list[i];
        }

        newList[list.length] = m;

        return  newList;
    }

}


