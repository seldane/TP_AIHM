/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import animation.AnimationControl;
import main.MainFrame;
import elevator.ElevatorButton;

/**
 *
 * @author Thibaut
 */
public class ElevatorControl 
{
    private MainFrame frame;
    private AnimationControl animationControl;
    private CabinView cabinView;
    private ElevatorView elevatorView;
    private ToolBarView toolView;
    private ElevatorAbstract abstraction;

    public ElevatorControl() 
    {
        this.frame = null;
        this.cabinView = new CabinView();
        this.elevatorView = new ElevatorView();
        this.toolView = new ToolBarView();
        this.abstraction = new ElevatorAbstract();
        this.animationControl = new AnimationControl();
    }
    
    public void init(MainFrame frame)
    {
        this.frame = frame; 
        this.frame.init(this);
        this.cabinView.init(this);
        this.elevatorView.init(this);
        this.toolView.init(this);
        this.abstraction.init(this);
        this.animationControl.init(this);
    }
    
    public void userPushedButton(String name, boolean selection)
    {
        if(selection)
        {
            ((ElevatorButton)this.cabinView.getButton(name)).unSelected();
            ((ElevatorButton)this.elevatorView.getButton(name)).unSelected();
            ((ElevatorButton)this.toolView.getButton(name)).unSelected();
        }
        else
        {
            this.animationControl.userPushedButton(Integer.parseInt(name));
            this.abstraction.setFloor(Integer.parseInt(name));
            this.cabinView.getStairsDisplay().setText(name);
            ((ElevatorButton)this.cabinView.getButton(name)).selected();
            ((ElevatorButton)this.elevatorView.getButton(name)).selected();
            ((ElevatorButton)this.toolView.getButton(name)).selected();
        }
    }

    public CabinView getCabinView() {
        return cabinView;
    }

    public ElevatorView getElevatorView() {
        return elevatorView;
    }

    public ToolBarView getToolView() {
        return toolView;
    }  

    public AnimationControl getAnimationControl() {
        return animationControl;
    }
    
    
}
