/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.properties;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class Image {
    
    public static BufferedImage karakter;
    public static BufferedImage batu;
    public static BufferedImage cherry;
    public static BufferedImage anjing;
    public static BufferedImage[] tileSet;
    public static BufferedImage[] scoreTile;
    public static BufferedImage[] buttonStart;
    public static BufferedImage[] buttonQuit;
    public static BufferedImage[] buttonLoad;
    public static BufferedImage[] menuBG;
    public static BufferedImage[] fileLoad0;
    public static BufferedImage[] fileLoad1;
    public static BufferedImage[] fileLoad2;
    public static BufferedImage[] backButton;
    
    
    private static final int jumlahTile=9;
    
    public static void load(){
        karakter= loadImage("/farmer.png");
        batu= loadImage("/batu.png");
        cherry= loadImage("/cherry.png");
        anjing= loadImage("/anjing.jpg");
        tileSet= new BufferedImage[jumlahTile];
        scoreTile= new BufferedImage[2];
        buttonStart= new BufferedImage[2];
        buttonQuit= new BufferedImage[2];
        buttonLoad= new BufferedImage[2];
        menuBG= new BufferedImage[3];
        fileLoad0= new BufferedImage[2];
        fileLoad1= new BufferedImage[2];
        fileLoad2= new BufferedImage[2];
        backButton= new BufferedImage[2];
        
        for(int i=0;i<2; i++){
            backButton[i]=loadImage("/load/back"+i+".png");
        }        
        
        for(int i=0;i<2; i++){
            fileLoad0[i]=loadImage("/load/LoadWorld1-"+i+".png");
        }
        for(int i=0;i<2; i++){
            fileLoad1[i]=loadImage("/load/LoadWorld2-"+i+".png");
        }
        for(int i=0;i<2; i++){
            fileLoad2[i]=loadImage("/load/LoadWorld3-"+i+".png");
        }
        
        for(int i=0;i<jumlahTile; i++){
            tileSet[i]=loadImage("/tiles/tile"+i+".png");
        }
        for(int i=0;i<2;i++){
            scoreTile[i]= loadImage("/score area/score-field"+i+".png");
        }
        for(int i=0;i<2;i++){
            buttonStart[i]= loadImage("/menu/menu"+i+".png");
        }
        for(int i=0;i<2;i++){
            buttonQuit[i]= loadImage("/menu/quit"+i+".png");
        }
        for(int i=0;i<2;i++){
            buttonLoad[i]= loadImage("/menu/load"+i+".png");
        }      
        for(int i=0;i<3;i++){
            menuBG[i]= loadImage("/menu/bg"+i+".png");
        }     
    }
    
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(Image.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
