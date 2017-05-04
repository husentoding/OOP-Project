/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;
import game.properties.Image;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Cherry extends Obyek {
    
    private long lifeTime;
    private long startTime;
    private long currentTime;
    private boolean hidup;
    
    public static int cherryCount=0;

    public Cherry(Handler handler, float x, float y, int width, int height,int lifeTime) {
        super(handler, x, y, width, height);
        this.lifeTime=lifeTime;
        hidup=true;
        cherryCount++;
        isSolid=false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Image.cherry, (int)x, (int)y, width, height, null);
    }

    @Override
    public void update() {
      
    }
    
    public boolean getHidup(){
        return hidup;
    }
    
    public void setHidup(boolean hidup){
        this.hidup=hidup;
    }
    
}
