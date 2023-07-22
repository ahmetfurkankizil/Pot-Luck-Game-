import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel {
    private ButtonCollection buttons;
    private JLabel statusLabel;

    public GamePanel(){
        super();

        //Outer Panel
        BorderLayout gameLayout = new BorderLayout();
        this.setLayout(gameLayout);

        //Status Panel
        this.statusLabel = new JLabel("Status");
        this.statusLabel.setPreferredSize(new Dimension(500,100));

        //Core Class
        this.buttons = new ButtonCollection(statusLabel);

        //Button Panel
        JPanel buttonPanel = new JPanel();
        GridLayout buttonPanelLayout = new GridLayout(4,4);
        buttonPanel.setLayout(buttonPanelLayout);
        for (int i = 0; i <16; i++) {
            buttonPanel.add(buttons.getButton(i));
        }

        //Adding
        this.add(statusLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
    }

}
