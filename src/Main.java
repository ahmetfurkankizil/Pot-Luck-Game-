import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Pot Luck");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        GamePanel game = new GamePanel();
        game.setPreferredSize(new Dimension(500,300));
        frame.add(game);
        frame.setVisible(true);
    }
}