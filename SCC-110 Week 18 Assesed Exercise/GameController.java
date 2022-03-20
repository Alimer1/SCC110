import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameController
{
    private int secretCodeLenght;
    private JFrame mainFrame = new JFrame("Alimer's Special Game");
    private JPanel mainPanel = new JPanel();
    private JLabel title = new JLabel("Hello There Buttons >.<");
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private ColourScreen colourPanel = new ColourScreen(7);


    public GameController(int newSecretCodeLenght,int difficulty)
    {
        secretCodeLenght = newSecretCodeLenght;



        

        panel1.setLayout(new BorderLayout());

        panel1.add(title,BorderLayout.NORTH);
        panel1.add(colourPanel.getColourScreen(),BorderLayout.SOUTH);

        mainFrame.setContentPane(panel1);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }


}