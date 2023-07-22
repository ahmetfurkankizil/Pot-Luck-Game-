import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {
    private ButtonCollection buttons;
    ImageIcon regularIcon = new ImageIcon(getClass().getResource("regular.png"));
    ImageIcon bombIcon = new ImageIcon(getClass().getResource("bomb.png"));
    ImageIcon prizeIcon = new ImageIcon(getClass().getResource("prize.png"));

    public ButtonListener(ButtonCollection buttons){
        this.buttons = buttons;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(!buttons.gameStatus()){

        }
        else{
            JButton button;
            if (e.getSource() instanceof JButton) {
                button = (JButton) e.getSource();
                if (button.getName().equals("Prize")){
                    button.setIcon(prizeIcon);
                    buttons.prizePressed();
                    buttons.getStatusLabel().setText(buttons.displayStatusBar());
                }
                else if(button.getName().equals("Bomb")) {
                    button.setIcon(bombIcon);
                    buttons.bombPressed();
                    buttons.getStatusLabel().setText(buttons.displayStatusBar());
                }
                else {
                    if(!(button.getIcon() == regularIcon)){
                        button.setIcon(regularIcon);
                        buttons.regularButtonPressed();
                        buttons.getStatusLabel().setText(buttons.displayStatusBar());
                    }
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
