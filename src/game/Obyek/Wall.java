/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;
import game.properties.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author user
 */
public class Wall extends Obyek{
    
    private BufferedImage tileType;
    
    public Wall(Handler handler, float x, float y, int width, int height, int type) {
        super(handler, x, y, width, height);
        tileType= Image.tileSet[type];
        //0 dari kiri atas clockwise
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tileType, (int) x,(int) y, Obyek.def_width, Obyek.def_height, null);
    }

    @Override
    public void update() {
    
    }

    
}
