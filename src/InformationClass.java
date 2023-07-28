import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationClass extends JFrame{

    private JLabel rowLabel, columnLabel, prizeCountLabel, bombCountLabel, rowMessageLabel, columnMessageLabel, prizeCountMessageLabel, bombCountMessageLabel, messageLabel;
    private JTextField rowTextField, columnTextField, prizeCountTextField, bombTextField;
    private JButton submitButton;

    public InformationClass() {
        JPanel infoPanel = new JPanel();
        this.rowLabel = new JLabel("Rows:");
        this.rowTextField = new JTextField(3);
        this.columnLabel = new JLabel("Columns: ");
        this.columnTextField = new JTextField(3);
        this.prizeCountLabel = new JLabel("Prize Count: ");
        this.prizeCountTextField = new JTextField(3);
        this.bombCountLabel = new JLabel("Bomb Count: ");
        this.bombTextField = new JTextField(3);
        this.messageLabel = new JLabel("");
        this.submitButton = new JButton("Submit");
        ButtonListener submitListener = new ButtonListener();
        submitButton.addActionListener(submitListener);
        infoPanel.add(rowLabel);
        infoPanel.add(rowTextField);
        infoPanel.add(columnLabel);
        infoPanel.add(columnTextField);
        infoPanel.add(prizeCountLabel);
        infoPanel.add(prizeCountTextField);
        infoPanel.add(bombCountLabel);
        infoPanel.add(bombTextField);
        infoPanel.add(messageLabel);
        infoPanel.add(submitButton);
        add(infoPanel);
    }

    public boolean checkValidity() {
        if (Integer.valueOf(rowTextField.getText()) * Integer.valueOf(columnTextField.getText()) >= Integer.valueOf(prizeCountTextField.getText()) + Integer.valueOf(bombTextField.getText())) {
            return true;
        }
        else {
            this.messageLabel.setText("The number of (prizes + buttons) can't exceed the number of cells!");
            return false;
        }
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkValidity()) {
                setVisible(false);
                JFrame frame = new JFrame ("Pot Luck");
                GamePanel newGamePanel = new GamePanel(Integer.valueOf(rowTextField.getText()), Integer.valueOf(columnTextField.getText()), Integer.valueOf(prizeCountTextField.getText()), Integer.valueOf(bombTextField.getText()));
                frame.add(newGamePanel);
                frame.setSize(1500,1000);
                frame.setVisible(true);
            }
        }
    }

}
