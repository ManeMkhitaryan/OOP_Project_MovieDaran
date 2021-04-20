import java.util.Scanner;

public class Feedback {
    Scanner sc = new Scanner(System.in);
    private int numberOfLikes;
    private int numberOfDislikes;
    private String userName;
    public enum Like{Like,Dislike}

    public Feedback() {
        this.numberOfLikes = 0;
        this.numberOfDislikes = 0;
        this.userName = sc.nextLine();
    }


    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void Like(){

    }
}
