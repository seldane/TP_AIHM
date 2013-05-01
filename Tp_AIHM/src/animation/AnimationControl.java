package animation;

import elevator.ElevatorControl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thibaut
 */
public class AnimationControl 
{
    private ElevatorControl control;
    private AnimationView view;
    private AnimationAbstract abstraction;
    private List<Integer> listAskedFloor;
    
    public AnimationControl()
    {
        this.view = new AnimationView();
        this.abstraction = new AnimationAbstract();
        this.listAskedFloor = new ArrayList<>();
    }
    
    public void init(ElevatorControl control)
    {
        this.control = control;
        this.view.init(this);
        this.abstraction.init(this);
    }
    
    public void userPushedButton(int floor)
    {
        if(!this.listAskedFloor.contains(floor) && floor >= 0)
            this.listAskedFloor.add(floor);
    }

    public void floorEvent(int floor) 
    {
        this.view.setCurrentFloor(floor);
        if(this.view.getAskedFloor() == floor && !this.view.isOpening() && !this.view.isClosing())
        {
            this.view.setUp(false);
            this.view.setDown(false);
            this.view.setOpening(true);
            this.control.userPushedButton(String.valueOf(floor), true);
            this.listAskedFloor.remove(0);
        }
        else
        {
            if(!this.listAskedFloor.isEmpty())
                this.movementEvent(this.listAskedFloor.get(0));
        }      
    }
    
    public void movementEvent(int floor)
    {
        if(!this.view.isOpening() && !this.view.isClosing() && floor >= 0 ) 
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
        }
    }
    
    public AnimationView getView() {
        return view;
    }
}
