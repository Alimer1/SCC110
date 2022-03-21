import javax.swing.*;
import java.awt.*;
import java.awt.event.*;





/**
* The GameController class is the both framework and
* the brains of the whole operation
**/
public class GameController implements ActionListener
{
    private int codeLenght = 4;
    private int codeDifficulty = 6;
    private int currentDifficulty = 0;
    private int currentProgress = 0;
    private int secretCode[];

    private JFrame mainFrame = new JFrame("Alimer's Game");
    private JPanel mainPanel = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel resultPanel = new JPanel();
    
    private JPanel colourPanel = new JPanel();  //Panel that will hold our colour buttons
    private JButton buttons[];                  //Array of buttons;

    private JLabel title = new JLabel("Hello There Buttons >.<");
    private GameScreen gameScreens[];
    private ResultScreen resultScreens[];

    private static int numberOfColours = 7;


    /**
    * Creats the game with default difficulty and default code lenght.
    */
    public GameController()
    {
        displaySetup();
    }

    /**
    * Creats the game with the given difficulty and default code lenght.
    * @param newCodeDifficulty Difficulty of the game (How many tries are allowed before a gameover).
    */
    public GameController(int newCodeDifficulty)
    {
        codeDifficulty = newCodeDifficulty;
        displaySetup();
    }

    /**
    * Creats the game with the given difficulty and default code lenght.
    * @param newCodeDifficulty Difficulty of the game (How many tries are allowed before a gameover).
    * @param newCodeLenght Lenght of the secret code.
    */
    public GameController(int newCodeDifficulty,int newCodeLenght)
    {
        codeDifficulty = newCodeDifficulty;
        codeLenght = newCodeLenght;
        displaySetup();
    }

    /**
    * Sets the frames and the panels of our game then populating the east and the west panels with their array of GameScreen and ResultScreen.
    */
    private void displaySetup()
    {
        mainPanel.setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(codeDifficulty,1));
        resultPanel.setLayout(new GridLayout(codeDifficulty,1));

        secretCode = new int[codeLenght];

        for(int i=0; i<codeLenght; i++)
        {
            double n = Math.random()*numberOfColours;
            secretCode[i] = (int) n;
            System.out.println(""+secretCode[i]);
        }

        System.out.println("End Of Secret Code");
        
        gameScreens = new GameScreen[codeDifficulty];
        resultScreens = new ResultScreen[codeDifficulty];

        for(int i=0; i<codeDifficulty; i++)
        {
            gameScreens[i] = new GameScreen(codeLenght,numberOfColours,secretCode); //PROBLEM HERE
            resultScreens[i] = new ResultScreen(codeLenght);
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

    /**
     * Gets run every time a button is clicked
     */
    public void actionPerformed(ActionEvent e) //Check which button was pressed
    {
        {
            for(int i=0; i<numberOfColours; i++)
            {
                if(e.getSource() == buttons[i])
                {
                    System.out.println(""+i);
                    gameScreens[currentDifficulty].updateScreen(i);
                    currentProgress++;
                    if(currentProgress == codeLenght)
                    {
                        resultScreens[currentDifficulty].setCorrect(gameScreens[currentDifficulty].getCorrect());           //Passing the correct from one to another
                        resultScreens[currentDifficulty].setHalfCorrect(gameScreens[currentDifficulty].getHalfCorrect());   //Passing the halfCorrect from one to another
                        resultScreens[currentDifficulty].updateScreen();
                        currentDifficulty++;
                        currentProgress = 0;
                        if(gameScreens[currentDifficulty-1].getCorrect()==codeLenght)
                        {
                            System.out.println("Victory");
                        }
                        if(currentDifficulty==codeDifficulty)
                        {
                            System.out.println("Defeat");
                        }
                    }
                }
            }
        }
    }
}