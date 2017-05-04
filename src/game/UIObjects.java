/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.states.State;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author user
 */

public class UIObjects {
    
    private BufferedImage[] images;
    private int x,y,width,height;
    private Handler handler;
    private boolean hover;
    private buttonAction action;
    
    public UIObjects(int x, int y, int width, int height, BufferedImage[] images, Handler handler, buttonAction action){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.images=images;
        this.handler= handler;
        this.action=action;
    }
    
    public void update(){
        if(handler.getMouse().getposX()>x && handler.getMouse().getposX()<x+width && handler.getMouse().getposY()>y && handler.getMouse().getposY()<y+height){
            hover=true;
            if(handler.getMouse().getleftPressed())
                action.doOnClick();
        }
            
        else{
            hover=false;
        }
            
        
        
        
    }
    public void render(Graphics g){
        if(hover==false)
            g.drawImage(images[0], x, y, width, height, null);
        else
            g.drawImage(images[1], x, y, width, height, null);
    }

    
}
