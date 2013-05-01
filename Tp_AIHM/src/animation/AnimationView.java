/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Thibaut
 */
public class AnimationView extends javax.swing.JPanel implements ActionListener
{
    private AnimationControl control;
    
    private int posX;
    private int posY;
    private int elevatorGate;
    
    private boolean up;
    private boolean down;
    private boolean opening;
    private boolean closing;
    
    private Timer timer;
    
    private int currentFloor;
    private int askedFloor;
    
    public AnimationView() 
    {
        super();
        this.posX = 400;
        this.posY = 680;
        this.up = false;
        this.down = false;
        this.opening = false;
        this.closing = false;
        this.elevatorGate = 100;
        this.currentFloor = 0;
        this.askedFloor = -1;
        this.setLayout(null);
        this.setBackground(Color.white);
        this.timer = new Timer(20, this);
        this.timer.start();
    }
    
    public void init(AnimationControl control)
    {
        this.control = control;
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        //ElevatorLine
        g.drawLine(this.posX, getHeight()-800, this.posX, getHeight());
        g.drawLine(this.posX+200, getHeight()-800, this.posX+200, getHeight());
        
        //StepZero
        g.drawLine(this.posX, getHeight()-1, this.posX+200, getHeight()-1);
        
        //StepOne
        g.drawLine(this.posX, getHeight()-201, this.posX+5, getHeight()-201);
        g.drawLine(this.posX+195, getHeight()-201, this.posX+200, getHeight()-201);
        
        //StepTwo
        g.drawLine(this.posX, getHeight()-401, this.posX+5, getHeight()-401);
        g.drawLine(this.posX+195, getHeight()-401, this.posX+200, getHeight()-401);
        
        //StepThree
        g.drawLine(this.posX, getHeight()-601, this.posX+5, getHeight()-601);
        g.drawLine(this.posX+195, getHeight()-601, this.posX+200, getHeight()-601);
        
        //StepFour
        g.drawLine(this.posX, getHeight()-801, this.posX+200, getHeight()-801);
        
        //Elevator
        g.setColor(Color.GRAY);
        g.fillRect(this.posX, this.posY,this.elevatorGate,200);
        g.fillRect(this.posX+200-this.elevatorGate, this.posY, this.elevatorGate, 200);
        
        g.setColor(Color.BLACK);
        g.drawRect(this.posX, this.posY,this.elevatorGate,200);
        g.drawRect(this.posX+200-this.elevatorGate, this.posY, this.elevatorGate, 200);
        this.repaint();
    }

    public boolean isClosing() {
        return closing;
    }

    public void setClosing(boolean closing) {
        this.closing = closing;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        //Elevator Movement
        if(this.up)
            this.posY--;
        else if(this.down)
            this.posY++;
        
        //FloorEvent
        if(this.posY == 680)
        {
            this.control.floorEvent(0);
        }
        else if(this.posY == 480)
        {
            this.control.floorEvent(1);
        }
        else if(this.posY == 280)
        {
            this.control.floorEvent(2);
        }
        else if(this.posY == 80)
        {
            this.control.floorEvent(3);
        }
        else
        {
            //this.control.userPushedButton(-1);
        }
           
        //Gate Movement
        if(this.opening)
        {
            this.elevatorGate--;
        }
        else if(this.closing)
        {
            this.elevatorGate++;
        }
        
        //GateEvent
        if(this.elevatorGate == 0)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimationView.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.askedFloor = -1;
            this.opening = false;
            this.closing = true;
        }
        if(this.elevatorGate == 101)
        {
            this.elevatorGate--;
            this.closing = false;
        }
    }
    
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getElevatorGate() {
        return elevatorGate;
    }

    public void setElevatorGate(int elevatorGate) {
        this.elevatorGate = elevatorGate;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isOpening() {
        return opening;
    }

    public void setOpening(boolean opening) {
        this.opening = opening;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getAskedFloor() {
        return askedFloor;
    }

    public void setAskedFloor(int askedFloor) {
        this.askedFloor = askedFloor;
    }
    
    
}
