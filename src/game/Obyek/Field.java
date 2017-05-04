/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;
import game.Timer;
import game.properties.LoadSave;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Field {
    private Obyek[][] objek;
    private Obyek[][] tiles;
    private Handler m;
    private Timer cherryTimer;
    private boolean initial;
    private boolean startSpawn;
    private int[] curTime;
    
    //size field currently is 672x672
    public static int boxsize;
    
    private int size;
    
    public Field(Handler m,int size){
        this.size= size;
        this.boxsize=42;
        objek= new Obyek[size][size];
        tiles= new Obyek[size][size];
        this.m=m;
        initial= true;
        startSpawn= true;
        cherryTimer= new Timer();
        curTime= new int[4];
        init();
    }
    
    public Field(Handler m, int size ,String path){
        this.m=m;
        this.size= size;
        this.boxsize=42;
        objek= new Obyek[size][size];
        tiles= new Obyek[size][size];
        initial= true;
        cherryTimer= new Timer();
        loadField(path);
    }
    public void loadField(String path){
        String file= LoadSave.loadFile(path);
        String[] content= file.split("\\s+");
        
        for(int i=0; i<16; i++){
            for(int j=0; j<16; j++){
                if(LoadSave.parseInt(content[i+j*16])==0) 
                    objek[i][j]=null;
                if(LoadSave.parseInt(content[i+j*16])==1) 
                    objek[i][j]= new Dog(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height);
                if(LoadSave.parseInt(content[i+j*16])==2) 
                    objek[i][j]= new Rock(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height);
                    
            }
        }
    }
    
    public Obyek[][] getObjek(){
        return objek;
    }
    
    public void setWall(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,8);
                if(i==0){
                    if(i==0 && j==0)
                        tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,0);
                    else
                        tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,7);
                }
                if(j==0 && i>0){
                    if(i==size-1)
                        tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,2);
                    else
                        tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,1);
                }
                if(i==size-1 && j>0){
                    tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,3);
                }
                if(j==size-1){
                    if(i==size-1)
                       tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,4); 
                    else if(i==0)
                        tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,6);
                    else
                       tiles[i][j]= new Wall(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height,5);
                }
                
            }
        }

    }
    
    public void generateObjects(){
        Random rand= new Random();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int value= (int) rand.nextInt(15);
                if (value==0){
                    if(objek[i][j]==null)
                        objek[i][j]= new Dog(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height);
                }else if(value==1 || value==2){
                    if(objek[i][j]==null)
                        objek[i][j]= new Rock(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height);
                }
                    
                        
            }
        }
    }
    
    public void spawnCherry(){
        Random rand= new Random();
        for(int i=0; i<size; i++){
            for(int j=0;j<size; j++){
                if(objek[i][j]!=null)
                    continue;
                else{
                    int value= rand.nextInt(50);
                    if(value==0)
                        if(Cherry.cherryCount<3)
                            objek[i][j]=new Cherry(m, i*boxsize, j*boxsize, Obyek.def_width,Obyek.def_height, 2*60*1000);
                }
                    
            }
        }
    }
    
    public void deleteCherry(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(objek[i][j] instanceof Cherry){
                    Cherry c=(Cherry) objek[i][j];
                    if(!c.getHidup())
                        objek[i][j]=null;
                }
                    
            }
        }
    }
    
    
    public void init(){
        generateObjects();
        try {
            LoadSave.saveFile(this.objek);
        } catch (IOException ex) {
            Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        if(initial){
            cherryTimer.startThread();
            initial=false;
        }
        if(startSpawn){ //mulai spawn seatelah game mulai, startspawn set to false apabila timer sudah 2 menit
            curTime= cherryTimer.getTime();
            if(curTime[2]==4){
//                deleteCherry();
                spawnCherry();
            }
            if(curTime[1]>=2)
                startSpawn=false;
        }
        for(int i=0; i<16; i++){
            for(int j=0; j<16; j++){
                if (objek[i][j]!=null)
                    objek[i][j].update();
            }
        }
        
    }
    
    public void render(Graphics g){
        setWall();
        for(int i=0; i<16; i++){
            for(int j=0; j<16; j++){
                if(tiles[i][j]!=null)
                    tiles[i][j].render(g);
                if(objek[i][j]!=null)
                    objek[i][j].render(g);
                }
        }
        
    }
    
    public Obyek getObyek(int i, int j){
        if(i>=size)
            i=15;
        if(j>=size)
            j=15;
        return objek[i][j];
    }
        
    
}
