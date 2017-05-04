/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;
import game.states.Play;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author user
 */
public abstract class Obyek {
    
    
    public static final int def_width=42, def_height=42;
    protected float x,y;
    protected int width,height;
    protected Rectangle collisionArea;
    protected boolean isSolid=true;
    protected Handler handler;
    
    public Obyek(Handler handler, float x, float y, int width, int height){
        this.x =x;
        this.y =y;
        this.handler= handler;
        this.width= width;
        this.height= height;
        collisionArea= new Rectangle((int) x,(int) y,width,height);
    } 
    
    
    public abstract void render(Graphics g);
    public abstract void update();
}
