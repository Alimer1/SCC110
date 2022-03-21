import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameController
{
    private int secretCodeLenght;
    private int secretCode[];
    private JFrame mainFrame = new JFrame("Alimer's Special Game");
    private JPanel mainPanel = new JPanel();
    private JLabel title = new JLabel("Hello There Buttons >.<");
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private ColourScreen colourPanel = new ColourScreen(7);


    public GameController(int newSecretCodeLenght,int difficulty)
    {
        secretCodeLenght = newSecretCodeLenght;

        mainPanel.setLayout(new BorderLayout());

        int tempSecretCode[secretCodeLenght];
        
        secretCode = tempSecretCode;

        for(int i=0; i<secretCodeLenght; i++)
        {
            double n = Math.random()*(secretCodeLenght^10);
            secretCode[i] = (int) n;
        }


        private GameScreen gamePanel = new GameScreen(newSecretCodeLenght, newNumberOfColours)
        private ColourScreen resultPanel = new ColourScreen(7);

        mainPanel.add(title,BorderLayout.NORTH);
        mainPanel.add(colourPanel.getColourScreen(),BorderLayout.SOUTH);

        mainFrame.setContentPane(panel1);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }


}