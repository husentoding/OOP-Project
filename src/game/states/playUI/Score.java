/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states.playUI;


import game.properties.FontLoader;
import game.properties.Image;
import game.properties.Text;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Score {
    
    private String playerName;
    private int health;
    private int scoreValue;
    
    
    public Score(){
        
    }
    public void update(){
        
    }
    public void render(Graphics g){
        g.drawImage(Image.scoreTile[1], 732, 0, 250, 250, null);
        Text.drawString(g, "Player "+ this.playerName, 750, 50, false, Color.white, FontLoader.font);
        g.setColor(Color.WHITE);
        g.drawString("Player "+this.playerName, 750, 50);
        g.drawString("Score "+scoreValue, 750, 75);
        g.drawString("Health "+health, 750, 100);
        
//        g.drawString("FPS "+Main.ticks, 750, 150);
    }
    public void setplayerName(String name){
        this.playerName= name;
    }
    
    public void setHealth(int h){
        health=h;
    }
    public void setscoreValue(int score){
        this.scoreValue= score;
    }
    
    public int getscoreValue(){
        return this.scoreValue;
    }
    
}
