/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ElevatorControl;
import form.ElevatorButton;

/**
 *
 * @author Thibaut
 */
public class ToolBarView extends javax.swing.JToolBar
{
    private ElevatorControl control;
    private javax.swing.JButton ZeroButton;
    private javax.swing.JButton FirstButton;
    private javax.swing.JButton SecondButton;
    private javax.swing.JButton ThirdButton;
    
    public ToolBarView()
    {
        super();
        this.initComponents();
    }
    
    public void init(ElevatorControl control)
    {
        this.control = control;
    }

    private void initComponents() 
    {
        this.ThirdButton = new ElevatorButton("3", "/images/Three.png", "/images/ThreeSelected.png", this.control);
        this.ThirdButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.ThirdButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.add(this.ThirdButton);
        
        this.SecondButton = new ElevatorButton("2", "/images/Two.png", "/images/TwoSelected.png", this.control);
        this.SecondButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.SecondButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.add(this.SecondButton);
        
        this.FirstButton = new ElevatorButton("1", "/images/One.png", "/images/OneSelected.png", this.control) ;
        this.FirstButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.FirstButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.add(this.FirstButton);
        
        this.ZeroButton = new ElevatorButton("0", "/images/Zero.png", "/images/ZeroSelected.png", this.control);
        this.ZeroButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.ZeroButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.add(this.ZeroButton);
    }
}
