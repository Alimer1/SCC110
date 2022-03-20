import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreen
{
    private int position = 0;       //Position of the target from left to right 0-1-2-3-...
    private int correct = 0;        //How many correct guesses have been made in the correct location
    private int halfCorrect = 0;    //How many correct guesses have been made in the wrong location
    private String secretCode;      //Answer of the game
    private int height = 0;             //Height of this instance of the GameScreen
    public GameScreen() //If you are using this constructor then the height must be 0 and you will later request the secretCode
    {
       
    }
    
    public GameScreen(String newSecretCode,int newHeight)
    {
        secretCode = newSecretCode;
        height = newHeight;
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