import javax.swing.*;
import java.awt.*;

public class GameScreen
{
    private int codeLenght;   //Lenght of the secret code
    private int position = 0;       //Position of the target from left to right 0-1-2-3-...
    private int correct = 0;        //How many correct guesses have been made in the correct location
    private int halfCorrect = 0;    //How many correct guesses have been made in the wrong location

    private int secretCode[];       //Answer of the game
    private int guess[];            //Guess for the answer

    private boolean guessClaim[];   

    private JPanel gamePanel = new JPanel();       //Panel that will be sent to the GameController

    private JLabel labels[];        //Array of icons

    

    public GameScreen(int newCodeLenght,int newNumberOfColours,int newSecretCode[])
    {
        codeLenght = newCodeLenght;
        gamePanel.setLayout(new GridLayout(1,codeLenght)); //PROBLEM HERE
        secretCode = newSecretCode;
        guess = new int[codeLenght];
        guessClaim = new boolean[codeLenght];
        labels = new JLabel[codeLenght];


        for(int i=0; i<codeLenght; i++)
        {
            labels[i] = new JLabel(new Picture("Empty.png"));
            gamePanel.add(labels[i]);
        }
    }

    private void correctCalculator()   //Calculates how many correct and halfCorrect guess there are
    {
        for(int i=0;i<codeLenght;i++)
        {
            if(secretCode[i]==guess[i])
            {
                guessClaim[i] = true;   //When we find a match we claim that spot in the guessClaim array
                correct++;
            }
        }
        System.out.println("Number of corrects:"+correct);
        for(int i=0;i<codeLenght;i++)
        {
            int j=0;
            boolean exit=false;
            while(j<codeLenght && exit == false)
            {
                if(guessClaim[j]==false && secretCode[j]==guess[i])
                {
                    guessClaim[j] = true;   //When we find a match we claim that spot in the guessClaim array
                    halfCorrect++;
                    exit = true;
                }
                j++;
            }
        }
        System.out.println("Number of halfCorrects:"+halfCorrect);
    }

    public void updateScreen(int colour)
    {
        labels[position].setIcon(new Picture("Colour_"+colour+".png"));
        guess[position] = colour;
        position++;
        if(position == codeLenght)
        {
            correctCalculator();
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