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

    private int rows,columns,prize,bombcount;


    public ButtonCollection(JLabel statusLabel, int rows, int columns, int prize, int bombCount){
        this.guess = 0;
        this.gameStatus = true;
        this.bombPressed = false;
        this.rows = rows;
        this.columns = columns;
        this.prize = prize;
        this.bombcount = bombCount;
        this.buttons = new JButton[(rows*columns)+1];
        this.listForRandom = new ArrayList<>();
        this.buttonFactory(rows, columns, prize, bombCount);
        this.statusLabel = statusLabel;
    }

    public int getColumn() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int getPrize() {
        return prize;
    }

    public int getBombcount() {
        return bombcount;
    }


    public void buttonFactory(int rows, int columns, int prize, int bombCount){
        ArrayList<Integer> arrayListForShuffle = new ArrayList<>();
        int noOfButtonsToBeAdded = rows*columns;
        for (int i = 0; i<noOfButtonsToBeAdded; i++){
            listForRandom.add(i);
        }

        int randomNumber;
        int pick;

        int holdingIndex = 0;
        int secondHoldingIndex = 0;
        for (int i = 0; i < this.prize; i++) {
            this.buttons[i] = makePrizeButton();
            holdingIndex = i;
        }
        for (int j = (holdingIndex+1); j <= (this.bombcount+holdingIndex); j++) {
            this.buttons[j] = makeBombButton();
            secondHoldingIndex = j;
        }
        for (int k = secondHoldingIndex+1; k <= (noOfButtonsToBeAdded); k++) {
            this.buttons[k] = makeRegularButton();
        }

        shuffleArray(buttons, rows, columns);
    }

    public JButton[] shuffleArray(JButton[] buttons, int rows, int columns) {
        int noOfButtonsToBeAdded = rows*columns;
        for (int i = 0; i < noOfButtonsToBeAdded; i++) {
            JButton temp = buttons[i];
            int randomForSwap = random.nextInt(0, noOfButtonsToBeAdded-1);
            buttons[i] = buttons[randomForSwap];
            buttons[randomForSwap] = temp;
        }
        return buttons;
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
