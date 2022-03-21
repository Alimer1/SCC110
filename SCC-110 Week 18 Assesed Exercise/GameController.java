import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameController
{
    private int secretCodeLenght;
    private int secretCode[];

    private JFrame mainFrame = new JFrame("Alimer's Special Game");
    private JPanel mainPanel = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel resultPanel = new JPanel();

    private JLabel title = new JLabel("Hello There Buttons >.<");
    private ColourScreen colourPanel = new ColourScreen(7);
    private GameScreen gameScreens[];
    private ResultScreen resultScreens[];

    private static int numberOfColours = 7;


    public GameController(int newSecretCodeLenght,int difficulty)
    {
        secretCodeLenght = newSecretCodeLenght;

        mainPanel.setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(difficulty,1));
        resultPanel.setLayout(new GridLayout(difficulty,1));

        secretCode = new int[secretCodeLenght];

        for(int i=0; i<secretCodeLenght; i++)
        {
            double n = Math.random()*secretCodeLenght;
            secretCode[i] = (int) n;
        }

        gameScreens = new GameScreen[difficulty];
        resultScreens = new ResultScreen[difficulty];

        for(int i=0; i<difficulty; i++)
        {
            gameScreens[i] = new GameScreen(secretCodeLenght,numberOfColours,secretCode);
            resultScreens[i] = new ResultScreen(secretCodeLenght);
            gamePanel.add(gameScreens[i].getGameScreen());
            resultPanel.add(resultScreens[i].getResultScreen());
        }

        mainPanel.add(gamePanel,BorderLayout.WEST);
        mainPanel.add(gamePanel,BorderLayout.EAST);
        mainPanel.add(title,BorderLayout.NORTH);
        mainPanel.add(colourPanel.getColourScreen(),BorderLayout.SOUTH);

        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public void receiveButtonPress()
    {

    }

}