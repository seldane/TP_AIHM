package elevator;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Thibaut
 */
public class ElevatorButton extends JButton
{
    private String name;
    private String iconPath;
    private String iconPathSelected;
    private JLabel outputDisplay;
    private ElevatorControl control;
    
    public ElevatorButton(String name, String iconPath, String iconSelectedPath, ElevatorControl control)
    {
        this.name = name;
        this.iconPath = iconPath;
        this.iconPathSelected = iconSelectedPath;
        this.control = control;
        this.addActionListener(getIAction());
        this.setIcon(this.createImageIcon(this.iconPath));
        this.setSize(50, 50);
    }

    private ActionListener getIAction()
    {
        ActionListener al = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                control.userPushedButton(name,((JButton)e.getSource()).isSelected());
            }
        };
        return al;
    }

    public void selected()
    {
        this.setSelected(true);
        this.setIcon(this.createImageIcon(this.iconPathSelected));
    }
    
    public void unSelected()
    {
        this.setSelected(false);
        this.setIcon(this.createImageIcon(this.iconPath));
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    private ImageIcon createImageIcon(String path) 
    {
        java.net.URL imgURL = ElevatorButton.class.getResource(path);
        if (imgURL != null)
            return new ImageIcon(imgURL);
        else 
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
   
}
