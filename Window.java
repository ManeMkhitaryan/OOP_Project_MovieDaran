import javax.swing.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window{


    //    @Override
//    public void actionPerformed(ActionEvent e) {
//       new SecondFrame();
//    }
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private JFrame frame = new JFrame("Click to Start");
    private JButton button;
    private ImageIcon image;



    public Window(){
        button = new JButton();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("Click the Icon to continue");


        button.setIcon(new ImageIcon("C:\\Users\\Kamo\\Desktop\\AUA student\\Freshman Spring 2021\\OOP\\MovieDaran\\src\\MovieDaran photos\\logos\\cropped-logo-md.png"));
        button.setBounds(200,100,600,600);
        button.setBackground(new Color(100,123,15));
//        panel.add(button);
//        frame.add(panel);
        label.setVerticalTextPosition(JLabel.TOP);
        frame.getContentPane().setBackground(new Color(100,123,15));
        frame.validate();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button,BorderLayout.CENTER);
        frame.add(label);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MyFrame();
            }
        });
        frame.setResizable(false);
        frame.setSize(WIDTH,HEIGHT);

    }

    public static void main(String[] args){
        new Window();
    }



}
