/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.ElevatorControl;

/**
 *
 * @author Thibaut
 */
public class ElevatorAbstract 
{
    private ElevatorControl control;
    private int floor;

    public ElevatorAbstract() {
        this.control = null;
        this.floor = 0;
    }
    
    public void init(ElevatorControl control){ this.control = control; }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
