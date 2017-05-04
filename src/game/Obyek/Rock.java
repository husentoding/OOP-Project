/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;
import game.properties.Image;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Rock extends Obyek{
    
    

    public Rock(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Image.batu, (int) x, (int) y, width,height, null);
//        g.fillRect(collisionArea.x, collisionArea.y, collisionArea.width, collisionArea.height);
    }

    @Override
    public void update() {
    
    }
    
    @Override
    public String toString(){
        return "Batu";
    }
    
}
