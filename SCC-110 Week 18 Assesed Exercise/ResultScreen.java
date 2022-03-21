import javax.swing.*;
import java.awt.*;

public class ResultScreen
{

    private JPanel resultPanel = new JPanel();
    private int codeLenght;
    private int width;
    private JLabel labels[];        //Array of icons
    private int correct = 0;        //How many correct guesses have been made in the correct location
    private int halfCorrect = 0;    //How many correct guesses have been made in the wrong location

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

        labels = new JLabel[codeLenght];

        for(int i=0; i<codeLenght; i++)
        {
            labels[i] = new JLabel(new Picture("Empty.png"));
            resultPanel.add(labels[i]);
        }
    }

    public void setCorrect(int i)
    {
        correct = i;
    }

    public void setHalfCorrect(int i)
    {
        halfCorrect = i;
    }

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


    public JPanel getResultScreen()
    {
        return(resultPanel);
    }
}