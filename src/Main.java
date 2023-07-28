import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        InformationClass newScreen = new InformationClass();
        newScreen.setTitle("Enter the Information");
        newScreen.setSize(500, 150);
        newScreen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        newScreen.setPreferredSize(new Dimension(500,300));
        newScreen.setVisible(true);
    }
}