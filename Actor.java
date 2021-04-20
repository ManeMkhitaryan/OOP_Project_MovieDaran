import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**class actor, with its instance variables, constructor initializing each variable, copy constructor, accessors mutators*/
public class Actor {
    private String firstName;
    private String lastName;
    private int age;
    private String aboutActor;

    public Actor(String firstName, String lastName, int age, String aboutActor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.aboutActor = aboutActor;
    }
    public Actor(Actor that){
        if(that != null){
            this.firstName = that.firstName;
            this.lastName = that.lastName;
            this.age = that.age;
            this.aboutActor = that.aboutActor;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        if(age < 0)
            return 0;
        else
            return age;
    }

    public void setAge(int age) {
        if(age < 0)
            this.age = 0;
        else
            this.age = age;

    }

    public String getAboutActor() {
        return aboutActor;
    }

    public void setAboutActor(String aboutActor) {
        this.aboutActor = aboutActor;
    }
//    public void add(){
//        Scanner inputStream = null;
//        Scanner sc = new Scanner(System.in);
//
//        try{
//            inputStream =
//                    new Scanner(new FileInputStream("C:\\Users\\Acer\\Desktop\\OOPproject\\Actor.txt"));
//
//        }catch(FileNotFoundException e){
//            System.out.println("File not found");
//            System.exit(0);
//        }
//
//
//        inputStream.close();
//    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" + age +
                "\n" + aboutActor;
    }
}
