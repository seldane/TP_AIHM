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
    private ElevatorButton ZeroButton;
    private ElevatorButton FirstButton;
    private ElevatorButton SecondButton;
    private ElevatorButton ThirdButton;
    
    public ToolBarView(){}
    
    public void init(ElevatorControl control)
    {
        this.control = control;
        this.initComponents();
    }

    private void initComponents() 
    {
        this.ThirdButton = new ElevatorButton("3", "/images/Three.png", "/images/ThreeSelected.png", this.control);
        this.ThirdButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.ThirdButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.ThirdButton.setSize(50, 50);
        add(this.ThirdButton);
        
        this.SecondButton = new ElevatorButton("2", "/images/Two.png", "/images/TwoSelected.png", this.control);
        this.SecondButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.SecondButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.SecondButton.setSize(50, 50);
        add(this.SecondButton);
        
        this.FirstButton = new ElevatorButton("1", "/images/One.png", "/images/OneSelected.png", this.control) ;
        this.FirstButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.FirstButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.FirstButton.setSize(50, 50);
        add(this.FirstButton);
        
        this.ZeroButton = new ElevatorButton("0", "/images/Zero.png", "/images/ZeroSelected.png", this.control);
        this.ZeroButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.ZeroButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.ZeroButton.setSize(50, 50);
        add(this.ZeroButton);
    }
    
    public ElevatorButton getButton(String name)
    {
        if(name.equals("3"))
            return this.ThirdButton;
        else if(name.equals("2"))
            return this.SecondButton;
        else if(name.equals("1"))
            return this.FirstButton;
        else if(name.equals("0"))
            return this.ZeroButton;
        else
            return null;
    }
}
