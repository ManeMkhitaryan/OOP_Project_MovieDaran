import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    MyFrame(){


        ImageIcon image = new ImageIcon("C:\\Users\\Acer\\Desktop\\Tets\\CH.jpg"); //create an image icon
        //this.setIconImage(image.getImage()); // change Icon of this
        this.getContentPane().setBackground(new Color(0x3F7770)); // change background color
        JLabel label = new JLabel(new ImageIcon(image.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        this.setTitle("JFrame title goes here"); // sets title of the this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of the application
        this.setResizable(false); // prevents this from being resized
        this.setSize(WIDTH,HEIGHT); // set the x-dimension and y-dimension of the this
        this.add(label,BorderLayout.WEST);

        this.setVisible(true); // make this visible

    }
}
