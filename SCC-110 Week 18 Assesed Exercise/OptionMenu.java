import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionMenu
{
    private JFrame frame = new JFrame("Custom Game");
    private JPanel panel = new JPanel();
    private JButton startButton = new JButton();
    private JTextField input1 = new JTextField("difDSADAS");
    private JTextField input2 = new JTextField("lenASDASDAS");
    private int difficulty;
    private int lenght;


    public OptionMenu(JButton newStartButton)
    {
        startButton = newStartButton;

        frame.setContentPane(panel);

        panel.add(startButton);
        panel.add(input1);
        panel.add(input2);


        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    public void buttonPress()
    {
        difficulty = Integer.parseInt(0+input1.getText());
        lenght = Integer.parseInt(0+input2.getText());
        System.out.println(difficulty);
        System.out.println(lenght);
    }

    public int getDifficulty()
    {
        return(difficulty);
    }
    public int getLenght()
    {
        return(lenght);
    }
    public void closeYourself()
    {
        frame.dispose();
    }
}