import javax.swing.*;
import java.awt.*;

/**
 * Class that shows the result on the left
 */
public class ResultScreen
{

    private JPanel resultPanel = new JPanel();
    private int codeLenght;
    private int width;

    private JLabel labels[];        //Array of icons
    private final Color bg = new Color(100,100,100);                   //Colour of the background, same as the symbols

    private int correct = 0;        //How many correct guesses have been made in the correct location
    private int halfCorrect = 0;    //How many correct guesses have been made in the wrong location

    /**
     * Constructor of the result screen class.
     * @param newCodeLenght Lenght of the secret code.
     */
    public ResultScreen(int newCodeLenght)
    {
        codeLenght = newCodeLenght;
        
        if(codeLenght % 2 == 1)
        {
            width = codeLenght+1;
        }
        else
        {
            width = codeLenght;
        }

        resultPanel.setLayout(new GridLayout(2,width));
        resultPanel.setBackground(bg);

        labels = new JLabel[codeLenght];

        for(int i=0; i<codeLenght; i++)
        {
            labels[i] = new JLabel(new Picture("HalfEmpty.png"));
            resultPanel.add(labels[i]);
        }
    }

    /**
     * Sets the correct variable in the result screen class.
     * @param newCorrect Number of correct guesses.
     */
    public void setCorrect(int newCorrect)
    {
        correct = newCorrect;
    }

    /**
     * Sets the half correct variable in the result screen class.
     * @param newHalfCorrect Number of half correct guesses.
     */
    public void setHalfCorrect(int newHalfCorrect)
    {
        halfCorrect = newHalfCorrect;
    }

    /**
     * Updates the labes on itself with the currently stored correct and half correct values. Don't forget to set these beforehand otherwise nothing will happen.
     */
    public void updateScreen()
    {
        int i=0;
        for(int j=0; j<correct; j++)
        {
            labels[i].setIcon(new Picture("Score_0.png"));
            i++;
        }
        for(int j=0; j<halfCorrect; j++)
        {
            labels[i].setIcon(new Picture("Score_1.png"));
            i++;
        }
    }

    /**
     * Gives you the constructed result screen JPanel.
     * @return The constructed result screen JPanel.
     */
    public JPanel getResultScreen()
    {
        return(resultPanel);
    }
}