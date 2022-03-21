import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameController implements ActionListener
{
    private int secretCodeLenght;
    private int difficulty;
    private int currentDifficulty;
    private int secretCode[];

    private JFrame mainFrame = new JFrame("Alimer's Special Game");
    private JPanel mainPanel = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel resultPanel = new JPanel();
    
    private JPanel colourPanel = new JPanel();  //Panel that will hold our colour buttons
    private JButton buttons[];                  //Array of buttons;

    private JLabel title = new JLabel("Hello There Buttons >.<");
    private GameScreen gameScreens[];
    private ResultScreen resultScreens[];

    private static int numberOfColours = 7;


    public GameController(int newSecretCodeLenght,int newDifficulty)
    {
        secretCodeLenght = newSecretCodeLenght;

        difficulty = newDifficulty;

        mainPanel.setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(difficulty,1));
        resultPanel.setLayout(new GridLayout(difficulty,1));

        secretCode = new int[secretCodeLenght];

        for(int i=0; i<secretCodeLenght; i++)
        {
            double n = Math.random()*secretCodeLenght;
            secretCode[i] = (int) n;
            System.out.println(""+secretCode[i]);
        }

        System.out.println("End Of Secret Code");
        
        gameScreens = new GameScreen[difficulty];
        resultScreens = new ResultScreen[difficulty];

        for(int i=0; i<difficulty; i++)
        {
            gameScreens[i] = new GameScreen(secretCodeLenght,numberOfColours,secretCode); //PROBLEM HERE
            resultScreens[i] = new ResultScreen(secretCodeLenght);
            gamePanel.add(gameScreens[i].getGameScreen());
            resultPanel.add(resultScreens[i].getResultScreen());
        }

        colourPanel.setLayout(new GridLayout(1,numberOfColours));
        buttons = new JButton[numberOfColours];
        String currentFileName;

        for(int i=0; i<numberOfColours; i++)
        {
            currentFileName = "Colour_"+i+".png";
            buttons[i] = new JButton(new Picture(currentFileName));
            colourPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        mainPanel.add(resultPanel,BorderLayout.EAST);
        mainPanel.add(gamePanel,BorderLayout.WEST);
        mainPanel.add(title,BorderLayout.NORTH);
        mainPanel.add(colourPanel,BorderLayout.SOUTH);

        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) //Check which button was pressed
    {
        for(int i=0; i<numberOfColours; i++)
        {
            if(e.getSource() == buttons[i])
            {
                System.out.println(""+i);
                gameScreens[currentDifficulty].receiveButtonPress(i);
            }

        }
        
    }

}