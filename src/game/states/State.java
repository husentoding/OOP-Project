/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.Handler;
import game.Main;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public abstract class State {
    
    public static State currState=null;
    protected Handler m;
    
    public State(Handler m){
        this.m= m;
    }
    
    public static void setState(State s){
        currState=s;
    }
    public static State getState(){
        return currState;
    }
    
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void init();
    
}
