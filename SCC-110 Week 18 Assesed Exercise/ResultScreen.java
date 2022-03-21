import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultScreen
{

    private JPanel resultPanel = new JPanel();
    private int secretCodeLenght;
    private int width;
    private JLabel labels[];        //Array of icons

    public ResultScreen(int newSecretCodeLenght)
    {
        secretCodeLenght = newSecretCodeLenght;
        
        if(secretCodeLenght % 2 == 1)
        {
            width = secretCodeLenght+1;
        }
        else
        {
            width = secretCodeLenght;
        }

        resultPanel.setLayout(new GridLayout(2,width));

        for(int i=0; i<secretCodeLenght; i++)
        {
            labels[i] = new JLabel(new Picture("Empty.png"));
            resultPanel.add(labels[i]);
        }
    }

    public void updateResultScreen()
    {
        
    }



    public JPanel getResultScreen()
    {
        return(resultPanel);
    }
}