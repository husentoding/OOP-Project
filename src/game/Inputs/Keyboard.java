package game.Inputs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author user
 */
public class Keyboard implements KeyListener {
    
    private boolean[] keys;
    public boolean up,down,left,right;

    public Keyboard(){
        keys= new boolean[500];
    }
    
    public void update(){
        up= keys[KeyEvent.VK_UP];
        down= keys[KeyEvent.VK_DOWN];
        right= keys[KeyEvent.VK_RIGHT];
        left= keys[KeyEvent.VK_LEFT];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]= true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]= false;
    }
    
}
