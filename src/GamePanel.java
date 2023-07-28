import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel {
    private ButtonCollection buttons;
    private JLabel statusLabel;

    public GamePanel(int row, int columns, int prizeCount, int bombCount){
        super();

        //Outer Panel
        BorderLayout gameLayout = new BorderLayout();
        this.setLayout(gameLayout);

        //Status Panel
        this.statusLabel = new JLabel("Status");
        this.statusLabel.setPreferredSize(new Dimension(500,100));

        //Core Class
        this.buttons = new ButtonCollection(statusLabel, row, columns, prizeCount, bombCount);
        int numberOfButtonsToBeAdded = row*columns;

        //Button Panel
        JPanel buttonPanel = new JPanel();
        GridLayout buttonPanelLayout = new GridLayout(row,columns);
        buttonPanel.setLayout(buttonPanelLayout);
        for (int i = 0; i <numberOfButtonsToBeAdded; i++) {
            buttonPanel.add(buttons.getButton(i));
        }

        //Adding
        this.add(statusLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
    }

}
