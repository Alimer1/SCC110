import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultScreen
{

    private JPanel resultPanel = new JPanel();
    private int secretCodeLenght;
    private int width;

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
    }

    public JPanel getResultScreen(int correct,int halfCorrect)
    {
        return(resultPanel);
    }
}