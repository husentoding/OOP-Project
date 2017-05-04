/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author user
 */
public class Mouse implements MouseListener, MouseMotionListener{
    
    private boolean leftPressed;
    private boolean rightPressed;
    private int posX;
    private int posY;
    
    public boolean getleftPressed(){
        return leftPressed;
    }
    public boolean getrightPressed(){
        return rightPressed;
    }
    public int getposX(){
        return posX;
    }
    public int getposY(){
        return posY;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()== MouseEvent.BUTTON1)
            leftPressed= true;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPressed=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()== MouseEvent.BUTTON1)
            leftPressed= false;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPressed=false;        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        posX= e.getX();
        posY= e.getY();
    }
    
}
