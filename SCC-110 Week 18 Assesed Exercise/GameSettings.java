import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Menu that appears before the game to make you choose your settings not much to say
 */
public class GameSettings implements ActionListener
{
    private JFrame mainFrame = new JFrame("Settings");
    private JPanel mainPanel = new JPanel();
    private JTextField input1 = new JTextField("6");
    private JTextField input2 = new JTextField("4");
    private JButton button1 = new JButton("Start Game With Default Settings");
    private JButton button2 = new JButton("Start Game With Custom Settings");
    private JLabel label1 = new JLabel("Difficulty");
    private JLabel label2 = new JLabel("Lenght");

    /**
     * Sets the whole settings ui
     */
    public GameSettings()
    {
        mainFrame.setContentPane(mainPanel);            //Alot of setup for the menu
        mainPanel.setLayout(new GridLayout(3,2));
        mainPanel.setBackground(new Color(100,100,100));
        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(input1);
        mainPanel.add(input2);
        mainPanel.add(button1);
        mainPanel.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);

        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(500,200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    /**
     * Makes the buttons push :)
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button1)
        {
            GameController gameItself = new GameController();
            mainFrame.dispose();
        } 
        if(e.getSource() == button2)
        {
            Integer.parseInt(input1.getText());


            GameController gameItself = new GameController(Integer.parseInt(input1.getText()),Integer.parseInt(input2.getText()));
            mainFrame.dispose();
        }
    }
}