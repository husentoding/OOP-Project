/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;
import game.properties.Image;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author user
 */
public class Dog extends Living{

    public Dog(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
    
    public void autoMove(){
        xmove=0;
        if(ujung){
            speed= speed*-1;
            ujung=false;
        }
            
        xmove+=speed;
        moveX();
    }
    
    public void refreshCollisionArea(){
        collisionArea.x=(int)x;
        collisionArea.y=(int)y;
    }
    

    @Override
    public void render(Graphics g) {
        g.drawImage(Image.anjing, (int)x,(int) y, width, height, null);
       // g.fillRect(collisionArea.x, collisionArea.y, collisionArea.width, collisionArea.height);
    }

    @Override
    public void update() {
        refreshCollisionArea();
        autoMove();
    }
    
}
