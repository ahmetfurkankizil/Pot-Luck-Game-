import javax.swing.*;
import java.util.*;

public class ButtonCollection {

    private JButton[] buttons;
    private JLabel statusLabel;
    private ArrayList<Integer> listForRandom;
    Random random = new Random();
    ImageIcon missing = new ImageIcon(getClass().getResource("guess.png"));
    private int guess;
    private boolean gameStatus;
    private boolean bombPressed;


    public ButtonCollection(JLabel statusLabel){
        this.guess = 0;
        this.gameStatus = true;
        this.bombPressed = false;
        this.buttons = new JButton[16];
        this.listForRandom = new ArrayList<>();
        this.buttonFactory();
        this.statusLabel = statusLabel;
    }


    public void buttonFactory(){
        for (int i = 0; i<16; i++){
            listForRandom.add(i);
        }

        int randomNumber;
        int pick;
        for (int i= 0; i<16; i++){
            randomNumber = random.nextInt(16-i);
            pick = listForRandom.get(randomNumber);
            listForRandom.remove(randomNumber);
            if(pick == 0) {
                this.buttons[i] = makePrizeButton();
            }
            else if(pick<3 && pick>0){
                this.buttons[i] = makeBombButton();
            }
            else{
                this.buttons[i] = makeRegularButton();
            }
        }
    }

    public JButton getButton(int index){
        return buttons[index];
    }
    public JButton makeRegularButton(){
        JButton button = new JButton();
        button.setIcon(missing);
        button.setName("Regular");
        ButtonListener listener = new ButtonListener(this);
        button.addMouseListener(listener);
        return button;
    }
    public JButton makeBombButton(){
        JButton button = new JButton();
        button.setIcon(missing);
        button.setName("Bomb");
        ButtonListener listener = new ButtonListener(this);
        button.addMouseListener(listener);
        return button;
    }
    public JButton makePrizeButton(){
        JButton button = new JButton();
        button.setIcon(missing);
        button.setName("Prize");
        ButtonListener listener = new ButtonListener(this);
        button.addMouseListener(listener);
        return button;
    }

    public JLabel getStatusLabel(){
        return this.statusLabel;
    }

    public void regularButtonPressed(){
        guess++;
    }

    public String displayStatusBar(){
        if (this.gameStatus){
            return "Guesses: " + this.guess;
        }
        else if(bombPressed){
            return "Sorry! You are blown up at attempt " + guess + " !";
        }
        else {
            return "You got it in " + guess + " attempts!";
        }
    }

    public boolean gameStatus(){
        return gameStatus;
    }

    public void bombPressed(){
        finishTheGame();
        bombPressed = true;
    }

    public void prizePressed(){
        finishTheGame();
    }

    public void finishTheGame(){
        gameStatus = false;
    }
}
