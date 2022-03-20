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
    private int secretCode[];         //Answer of the game
    private JPanel gamePanel;       //Panel that will be sent to the GameController
    private JLabel labels[];        //Array of icons


    public GameScreen(int newSecretCodeLenght,int newNumberOfColours) //If you are using this constructor then this is the first game screen and you will later request the secretCode from this game screen
    {
        numberOfColours = newNumberOfColours;
        secretCodeLenght = newSecretCodeLenght;
        secretCode = new int[secretCodeLenght]; //I lost too much IQ while figuring this out
        gamePanel.setLayout(new GridLayout(1,secretCodeLenght));
        for(int i=0; i<secretCodeLenght;i++)
        {
            double n = Math.random()*(secretCodeLenght^10);
            secretCode[i] = (int) n;
            labels[i] = new JLabel(new Picture("Empty.png"));
            gamePanel.add(labels[i]);
        }
    }
    

    public GameScreen(int newSecretCodeLenght,int newNumberOfColours,int newSecretCode)
    {
        numberOfColours = newNumberOfColours;
        secretCodeLenght = newSecretCodeLenght;
        gamePanel.setLayout(new GridLayout(1,secretCodeLenght));
        secretCode = newSecretCode;

        for(int i=0; i<secretCodeLenght; i++)
        {
            labels[i] = new JLabel(new Picture("Empty.png"));
            gamePanel.add(labels[i]);
        }
    }

    private void correctionCalculator(int colour)   //YOU WERE HERE
    {
        int tempPos = position;
        if(colour == secretCode[tempPos])
        {
            correct++;
        }
        else
        {
            while() //There is a dillema here but I need to sleep or I am going to collapse
        }



    }

    public void receiveButtonPress(int colour)
    {
        if(position == secretCodeLenght-1)  //If this is true than we finish
        {









        }
        else
        {
            if()
            {
                labels[position] =
            }
 
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