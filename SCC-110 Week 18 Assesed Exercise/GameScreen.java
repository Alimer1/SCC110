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
    private JPanel gamePanel = new JPanel();       //Panel that will be sent to the GameController
    private JLabel labels[];        //Array of icons

    

    public GameScreen(int newSecretCodeLenght,int newNumberOfColours,int newSecretCode[])
    {
        numberOfColours = newNumberOfColours;
        secretCodeLenght = newSecretCodeLenght;
        gamePanel.setLayout(new GridLayout(1,secretCodeLenght)); //PROBLEM HERE
        secretCode = newSecretCode;
        guess = new int[secretCodeLenght];
        guessClaim = new boolean[secretCodeLenght];
        labels = new JLabel[secretCodeLenght];


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
        labels[position].setIcon(new Picture("Colour_"+colour+".png"));
        guess[position] = colour;
        position++;
        if(position == secretCodeLenght)
        {
            correctCalculator();
            System.out.println("We are here");
        }
        
    }
    
    public JPanel getGameScreen()
    {
        return(gamePanel);
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