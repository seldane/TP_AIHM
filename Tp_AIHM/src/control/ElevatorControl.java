/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.CabinView;
import view.ToolBarView;
import view.ElevatorView;
import abstraction.ElevatorAbstract;
import view.MainFrame;

/**
 *
 * @author Thibaut
 */
public class ElevatorControl 
{
    private MainFrame frame;
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
    }
    
    public void init(MainFrame frame)
    {
        this.frame = frame; 
        this.frame.init(this);
        this.cabinView.init(this);
        this.elevatorView.init(this);
        this.abstraction.init(this);
    }
    
    public void userPushedButton(String name)
    {
        
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
}
