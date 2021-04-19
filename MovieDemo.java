import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MovieDemo {
    public static void main(String[] args) {
        Scanner inputStream = null;

        try{
            inputStream =
                    new Scanner(new FileInputStream("C:\\Users\\Acer\\Desktop\\OOP Death Project\\Actor.txt"));

        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

            Actor actor = new Actor(inputStream.next(), inputStream.next(), inputStream.nextInt(),
                    !(inputStream.nextLine().equals(" ")) ? "Birthplace is unknown" : inputStream.nextLine());
            System.out.println(actor.getFirstName());

            inputStream.close();

    }
}
