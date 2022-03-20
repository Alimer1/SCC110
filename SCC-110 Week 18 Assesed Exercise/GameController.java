import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameController
{
    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame("Alimer's Special Game");
        JPanel panel1 = new JPanel();
        JLabel title = new JLabel("Hello There Buttons >.<");
        ColourScreen colourPanel = new ColourScreen(7);


        panel1.setLayout(new BorderLayout());

        panel1.add(title,BorderLayout.NORTH);
        panel1.add(colourPanel.getColourScreen(),BorderLayout.SOUTH);

        mainFrame.setContentPane(panel1);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}