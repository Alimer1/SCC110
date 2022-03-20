import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreen
{
    private int secretCodeLenght;   //Lenght of the secret code
    private int position = 0;       //Position of the target from left to right 0-1-2-3-...
    private int correct = 0;        //How many correct guesses have been made in the correct location
    private int halfCorrect = 0;    //How many correct guesses have been made in the wrong location
    private int secretCode;         //Answer of the game
    private JPanel gamePanel;       //Panel that will be sent to the GameController
    private JLabel labels[];        //Array of icons


    public GameScreen(int newSecretCodeLenght) //If you are using this constructor then the height must be 0 and you will later request the secretCode
    {
        secretCodeLenght = newSecretCodeLenght;
        gamePanel.setLayout(new GridLayout(1,secretCodeLenght));
        double n = Math.random()*(secretCodeLenght^10);
        secretCode = (int) n;

        for(int i=0; i<secretCodeLenght; i++)
        {
            labels[i] = new JLabel(new Picture("Empty.png"));
            gamePanel.add(labels[i]);
        }
    }
    

    public GameScreen(int newSecretCode,int newSecretCodeLenght)
    {
        secretCode = newSecretCode;
    }


    void inputColour()
    {

    }

    public int getCorrect()
    {
        return(correct);
    }
    int getHalfCorrect()
    {
        return(halfCorrect);
    }
    int getPosition()
    {
        return(position);
    }

}