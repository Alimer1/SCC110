import javax.swing.*;
import java.awt.*;

/**
 * Class that contains the main code entering screen
 */
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
    private final Color bg = new Color(100,100,100);                   //Colour of the background, same as the symbols

    private JLabel labels[];        //Array of icons

    
    /**
     * Constructor of GameScreen class.
     * @param newCodeLenght Lenght of the secret code.
     * @param newNumberOfColours How many unique colours there are in the game.
     * @param newSecretCode The secret code of the game.
     */
    public GameScreen(int newCodeLenght,int newNumberOfColours,int newSecretCode[])
    {
        codeLenght = newCodeLenght;
        gamePanel.setLayout(new GridLayout(1,codeLenght));
        gamePanel.setBackground(bg);
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

    /**
     * Calculates how many correct and halfcorrect answers are in the guess of this class it will modify the private values of the class rather than returning something.
     */
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
        //System.out.println("Number of corrects:"+correct); //Debugging Stuff
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
        //System.out.println("Number of halfCorrects:"+halfCorrect); //Debugging Stuff
    }

    /**
     * Called upon when a new info arrives about what colour next will be placed ont he screen.
     * @param colour Colour code of the new input (0-1-2-3-4-5-...).
     */
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

    /**
     * Gives you the constructed game screen JPanel.
     * @return The constructed game screen JPanel.
     */
    public JPanel getGameScreen()
    {
        return(gamePanel);
    }

    /**
     * Gives you the number of correct answers found by the Class compared to the correct answer.
     * @return Number of correct guesses(If the answer is equal to the lenght of the code than we got every thing correct and it is a victory condition).
     */
    public int getCorrect()
    {
        return(correct);
    }

    /**
     * Gives you the number of half correct answers found by the Class compared to the correct answer.
     * @return Number of half correct guesses.
     */
    public int getHalfCorrect()
    {
        return(halfCorrect);
    }

    /**
     * Gives you how far right the last got answer is from the start.
     * @return Where the next thing will be drawn on the screen(0 meaning left).
     */
    public int getPosition()
    {
        return(position);
    }

}