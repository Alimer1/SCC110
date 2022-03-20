import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColourScreen implements ActionListener
{

    private int numberOfColours;                //Number Of Colours
    private JPanel colourPanel = new JPanel();  //Panel that will hold our colour buttons
    private JButton buttons[];                  //Array of buttons

    public ColourScreen(int newNumberOfColours)
    {
        numberOfColours = newNumberOfColours;
        colourPanel.setLayout(new GridLayout(1,numberOfColours));
        buttons = new JButton[numberOfColours];
        String currentFileName;

        for(int i=0; i<numberOfColours; i++)
        {
            currentFileName = "Colour_"+i+".png";
            buttons[i] = new JButton(new Picture(currentFileName));
            colourPanel.add(buttons[i]);
            buttons[i].addActionListener(this);;
        }
    }
    
    public JPanel getColourScreen()
    {
        return(colourPanel);
    }


    public int getNumberOfColours()
    {
        return(numberOfColours);
    }

    public void actionPerformed(ActionEvent e) //Check which button was pressed
    {
        for(int i=0; i<numberOfColours; i++)
        {
            if(e.getSource() == buttons[i])
            {
                System.out.println(""+i);       //
            }

        }
    }
}