   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;
import game.Timer;
import game.properties.Audio;
import game.properties.FontLoader;
import game.properties.Image;
import game.properties.Text;
import game.states.playUI.Score;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Farmer extends Living {
    
    private Handler m;
    private String name="";
    private Score score;
    private boolean hidup=true;
    private Timer timer;
    private boolean baruMulai;
    private boolean playing;
    private int[] curTime;
            
    
    public Farmer(Handler m, float x, float y) {
        super(m, x, y, Obyek.def_width, Obyek.def_height);
        this.m= m;
        this.score= new Score();
        score.setHealth(health);
        timer= new Timer();
        baruMulai=true;
        playing=true;
        collisionArea.x=8;
        collisionArea.y=32;
        collisionArea.width=32;
        collisionArea.height=32;
        this.curTime= new int[4];
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Image.karakter, (int) x, (int) y, width, height, null);
        g.fillRect((int)x+collisionArea.width, (int)y+collisionArea.height+collisionArea.y,20,1);
        g.setColor(Color.red);
        g.fillRect((int) x+collisionArea.x, (int)y+collisionArea.y, collisionArea.width, collisionArea.height);
        Text.drawString(g, curTime[1] + " : " + curTime[2] + " : " + curTime[3], 850, 200, true, Color.white, FontLoader.font);
        
        
        score.render(g);
    }

    @Override
    public void update() {
        if(baruMulai){
            timer.startThread();
            baruMulai=false;
        }
        if(playing){
            curTime= timer.getTime();
            if(curTime[1]>=1)
                playing=false;
            
        }
        
        if (this.name=="")
            inputFarmerinfo();
        checkHit();
        getInput();
        move();
        score.update();
//        System.out.println("posisi x: "+getPosTileX());
//        System.out.println("posisi y: "+getPosTileY());        
    }
    
    public void inputFarmerinfo(){
        this.name= JOptionPane.showInputDialog("Enter your name: ");   
        score.setplayerName(this.name);
        //Audio.ready.play();
    }
    
    public void getInput(){
        ymove=0;
        xmove=0;
        
        if(m.getKeyboard().up)
            ymove=-speed;
        if(m.getKeyboard().down)
            ymove= speed;
        if(m.getKeyboard().left)
            xmove=-speed;
        if(m.getKeyboard().right)
            xmove= speed;
    }
    
    public void checkHit(){
        if(m.getObyekField(getPosTileX(), getPosTileY()) instanceof Dog){
            if(health>0){
                health--;
                
            }
                
            else
            hidup=false;
            score.setHealth(health);
        }
        if(m.getObyekField(getPosTileX(), getPosTileY()) instanceof Cherry){
            score.setscoreValue(score.getscoreValue()+1);
            Cherry c= (Cherry) m.getObyekField(getPosTileX(), getPosTileY());
            c.setHidup(false);
        }
    }

    
    

    

   
    
}
