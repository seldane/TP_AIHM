/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

/**
 *
 * @author Thibaut
 */
public class AnimationAbstract 
{
    private AnimationControl control;
    
    private int posX;
    private int posY;
    private int elevatorGate;
    
    private boolean up;
    private boolean down;
    private boolean opening;
    
    public AnimationAbstract(){}
    
    public void init(AnimationControl control)
    {
        this.control = control;
    }
}
