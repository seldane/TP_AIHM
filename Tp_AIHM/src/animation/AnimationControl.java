/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import elevator.ElevatorControl;

/**
 *
 * @author Thibaut
 */
public class AnimationControl 
{
    private ElevatorControl control;
    private AnimationView view;
    private AnimationAbstract abstraction;
    
    public AnimationControl()
    {
        this.view = new AnimationView();
        this.abstraction = new AnimationAbstract();
    }
    
    public void init(ElevatorControl control)
    {
        this.control = control;
        this.view.init(this);
        this.abstraction.init(this);
    }
    
    public void userPushedButton(int floor)
    {
        this.view.setAskedFloor(floor);
        if(floor > this.view.getCurrentFloor())
        {
            this.view.setUp(true);
            this.view.setDown(false);
            this.view.setOpening(false);
        }
        else if(floor < this.view.getCurrentFloor())
        {
            this.view.setDown(true);
            this.view.setUp(false);
            this.view.setOpening(false);
        }
        else
        {
            this.view.setUp(false);
            this.view.setDown(false);
            this.view.setOpening(true);
        }
    }

    public AnimationView getView() {
        return view;
    }

    public void floorEvent(int floor) 
    {
        this.view.setCurrentFloor(floor);
        if(this.view.getAskedFloor() == floor)
        {
            this.view.setUp(false);
            this.view.setDown(false);
            //this.view.setOpening(true);
            this.control.userPushedButton(String.valueOf(floor), true);
        }
    }
    
    
}
