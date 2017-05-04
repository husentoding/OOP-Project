/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Inputs.Keyboard;
import game.Inputs.Mouse;
import game.Obyek.Obyek;
import game.states.Play;

/**
 *
 * @author user
 */
public class Handler {
    
    private Main m;
    
    public Handler(Main m){
        this.m= m;
    }
    
    public void setMain(Main m){
        this.m= m;
    }
    public Main getMain(){
        return this.m;
    }
    
    public int getWidth(){
        return m.getWidth();
    }
    public int getHeight(){
        return m.getHeight();
    }
    public Keyboard getKeyboard(){
        return m.getKeyboard();
    }
    
    public Mouse getMouse(){
        return m.getMouse();
    }
    
    public Obyek getObyekField(int i, int j){
        Play p= (Play) getMain().getPlayState();
        return p.getField().getObyek(i, j);
    }
    
}
