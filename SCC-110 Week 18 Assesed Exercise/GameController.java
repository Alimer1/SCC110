import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* The GameController class is the both framework and
* the brains of the whole operation
**/
public class GameController implements ActionListener
{
    private int winState = 0;           //Winstate 0=Still Playing 1=Defeat 2=Victory

    private int codeLenght = 4;         //Lenght of our secret code
    private int codeDifficulty = 6;     //How many tries after we fail also the number of rows for both gamescreen and resultscreen
    private int currentDifficulty = 0;  //How many attemps we did
    private int currentProgress = 0;    //How far are we while entering our answer
    private int secretCode[];           //The secret code hold as an array of integers

    private JFrame mainFrame = new JFrame("Alimer's Game");     //Title of our game that will be at the top
    private JPanel mainPanel = new JPanel();                    //The panel that will hold everthing in a borderlayout
    private JPanel gamePanel = new JPanel();                    //Panel on the left side of the screen showing our current and past inputs
    private JPanel resultPanel = new JPanel();                  //Panel on the right side of the screen showing the correctness of our guess
    private final Color bg = new Color(100,100,100);                   //Colour of the background, same as the symbols
    
    private JPanel colourPanel = new JPanel();  //Panel that will hold our colour buttons
    private JButton buttons[];                  //Array of buttons;

    private JLabel title = new JLabel("Welcome to the very hard puzzle game",JLabel.CENTER);  //The title of the game while you are playing the game
    private GameScreen gameScreens[];       //The array of gamescreen that we will plop on to our gamepanel after we initialize them
    private ResultScreen resultScreens[];   //The array of gamescreen that we will plop on to our resultpanel after we initialize them

    private final int numberOfColours = 7;  //number of colours/buttons we have (the other classes can accept many values but we only have 7 png's and variable buttons wasn't a task)

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
        mainPanel.setLayout(new BorderLayout());                    //Seting the panels to the their correct layout
        gamePanel.setLayout(new GridLayout(codeDifficulty,1));      
        resultPanel.setLayout(new GridLayout(codeDifficulty,1));    

        mainPanel.setBackground(bg);    //Makes everything look brown
        gamePanel.setBackground(bg);
        resultPanel.setBackground(bg);



        secretCode = new int[codeLenght];                   //This initialises our secretcode array with the correct size
        gameScreens = new GameScreen[codeDifficulty];       //This initialises our gamescreen array with the correct size
        resultScreens = new ResultScreen[codeDifficulty];   //This initialises our resultscreen array with the correct size

        for(int i=0; i<codeLenght; i++)
        {
            double n = Math.random()*numberOfColours;   //Returns a number that is (0 <= x < 7)
            secretCode[i] = (int) n;                    //We roll that number down to a integer and 1 by 1 we add them to the array
        }

        for(int i=0; i<codeDifficulty; i++)
        {
            gameScreens[i] = new GameScreen(codeLenght,numberOfColours,secretCode); //We construct every class in the array
            resultScreens[i] = new ResultScreen(codeLenght);                        //We construct every class in the array
            gamePanel.add(gameScreens[i].getGameScreen());                          //We get the JPanel of every gamescreen to put them in to gamepanel
            resultPanel.add(resultScreens[i].getResultScreen());                    //We get the JPanel of every resultscreen to put them in to resultpanel
        }

        colourPanel.setLayout(new GridLayout(1,numberOfColours));
        colourPanel.setBackground(bg);
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
     * Small function to convert the secret answer from array to string.(there might be a better way)
     * @param array The array of integers to convert.
     * @param arraySize The lenght of that array.
     * @return String of the contents of array.
     */
    private String intArrayToString(int[] array,int arraySize)
    {
        String str = new String();
        for(int i=0;i<arraySize;i++)
        {
            int temp = array[i]+1; //adding 1 here so cross referencing will be better the game uses 0-6 in code but on ui it is 1-7 so yeah
            str = str+temp;
        }
        return(str);
    }


    /**
     * Gets run every time a button is clicked.
     */
    public void actionPerformed(ActionEvent e)
    {
        if(winState == 0)
        {
            for(int i=0; i<numberOfColours; i++)    //With this for loop we can check every button at the same time
            {
                if(e.getSource() == buttons[i])     //Was the button pressed by the button in this positon in the array
                {
                    gameScreens[currentDifficulty].updateScreen(i);
                    currentProgress++;
                    if(currentProgress == codeLenght)
                    {
                        currentProgress = 0;
                        resultScreens[currentDifficulty].setCorrect(gameScreens[currentDifficulty].getCorrect());           //Passing the correct from one to another
                        resultScreens[currentDifficulty].setHalfCorrect(gameScreens[currentDifficulty].getHalfCorrect());   //Passing the halfCorrect from one to another
                        resultScreens[currentDifficulty].updateScreen();
                        if(gameScreens[currentDifficulty].getCorrect()==codeLenght)                                         //if corrects answers match the code lenght you win
                        {
                            winState = 2;
                        }
                        if(currentDifficulty==codeDifficulty-1 && !(gameScreens[currentDifficulty].getCorrect()==codeLenght)) //if corrects answers don't match the code lenght and this is the last check then you lose
                        {
                            winState = 1;
                        }
                        currentDifficulty++;
                    }
                }

            }
        }
        if(winState == 1) //these if statements lock you when you win or loose so that you don't go out of limits
        {
            System.out.println("You Lost");
            System.out.println("Actual Answer Was:"+intArrayToString(secretCode,codeLenght));
            title.setText("You Lost Actual Answer Was:"+intArrayToString(secretCode,codeLenght));
        }
        if(winState == 2)
        {
            System.out.println("You Win");
            System.out.println("Answer Was:"+intArrayToString(secretCode,codeLenght));
            title.setText("You Win!! Answer Was:"+intArrayToString(secretCode,codeLenght));
        }
    }
}