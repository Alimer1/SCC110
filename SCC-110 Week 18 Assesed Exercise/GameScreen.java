import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreen
{
    private int numberOfColours;    //Number Of Colours
    private int secretCodeLenght;   //Lenght of the secret code
    private int position = 0;       //Position of the target from left to right 0-1-2-3-...
    private int correct = 0;        //How many correct guesses have been made in the correct location
    private int halfCorrect = 0;    //How many correct guesses have been made in the wrong location
    private int secretCode[];       //Answer of the game
    private int guess[];            //Guess for the answer
    private boolean guessClaim[];
    private JPanel gamePanel;       //Panel that will be sent to the GameController
    private JLabel labels[];        //Array of icons


    public GameScreen(int newSecretCodeLenght,int newNumberOfColours) //If you are using this constructor then this is the first game screen and you will later request the secretCode from this game screen
    {
        numberOfColours = newNumberOfColours;
        secretCodeLenght = newSecretCodeLenght;
        secretCode = new int[secretCodeLenght]; //I lost too much IQ while figuring this out
        guess = new int[secretCodeLenght];
        guessClaim = new boolean[secretCodeLenght];

        gamePanel.setLayout(new GridLayout(1,secretCodeLenght));

        for(int i=0; i<secretCodeLenght;i++)
        {
            double n = Math.random()*(secretCodeLenght^10);
            secretCode[i] = (int) n;
            labels[i] = new JLabel(new Picture("Empty.png"));
            gamePanel.add(labels[i]);
        }
    }
    

    public GameScreen(int newSecretCodeLenght,int newNumberOfColours,int newSecretCode[])
    {
        numberOfColours = newNumberOfColours;
        secretCodeLenght = newSecretCodeLenght;
        gamePanel.setLayout(new GridLayout(1,secretCodeLenght));
        secretCode = newSecretCode;
        guess = new int[secretCodeLenght];
        guessClaim = new boolean[secretCodeLenght];


        for(int i=0; i<secretCodeLenght; i++)
        {
            labels[i] = new JLabel(new Picture("Empty.png"));
            gamePanel.add(labels[i]);
        }
    }

    private void correctCalculator()   //Calculates how many correct and halfCorrect guess there are
    {
        for(int i=0;i<secretCodeLenght;i++)
        {
            if(secretCode[i]==guess[i])
            {
                guessClaim[i] = true;   //When we find a match we claim that spot in the guessClaim array
                correct++;
            }
            else    //We need to check if our current guess is a halfCorrect
            {
                for(int j=0; j<secretCodeLenght; j++)
                {
                    if(guessClaim[j]==false && secretCode[j]==guess[i])
                    {
                        guessClaim[j] = true;   //When we find a match we claim that spot in the guessClaim array
                        halfCorrect++;
                    }
                }
            }
        }
    }

    public void receiveButtonPress(int colour)
    {
        guess[position] = colour;
        position++;
        if(position == secretCodeLenght)
        {
            correctCalculator();
        }
        
    }

    public int getCorrect()
    {
        return(correct);
    }
    public int getHalfCorrect()
    {
        return(halfCorrect);
    }
    public int getPosition()
    {
        return(position);
    }

}