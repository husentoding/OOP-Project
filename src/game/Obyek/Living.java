/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Obyek;

import game.Handler;

/**
 *
 * @author user
 */
public abstract class Living extends Obyek {
    
    protected int health;
    protected float speed;
    protected boolean ujung=false;
    
    private Handler handler;
    
    public static final int def_health=5;
    public static final float def_speed= 1;
    
    
    protected float xmove, ymove;
    
    public Living(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health=def_health;
        speed= def_speed;
        this.handler= handler;
    }
    
    public void move(){
        moveX();
        moveY();
    }
    
    public void moveX(){
        if(!fieldBound()){
            if(xmove>0){ //kanan
                int mx= (int) (x+xmove+collisionArea.width)/42;
                int myatas= (int) (y+ymove+collisionArea.height)/42;
                int mybawah= (int) (y+ymove+collisionArea.height+collisionArea.y-3)/42;
                if(!checkCollision(mx, myatas)&&!checkCollision(mx, mybawah))
                    x+=xmove;
                else
                    ujung=true;
            }else if(xmove<0){ //kiri
                int mx= (int) (x+xmove)/42;
                int myatas= (int) (y+ymove+collisionArea.height)/42;
                int mybawah= (int) (y+ymove+collisionArea.height+collisionArea.y-3)/42;
                if(!checkCollision(mx, myatas)&&!checkCollision(mx, mybawah))
                    x+=xmove;else
                    ujung=true;
            }
        }
    }
    
    public void moveY(){
        if(!fieldBound()){
            if(ymove<0){    //keatas
                int mxkiri= (int) (x+xmove)/42;
                int mxkanan= (int) (x+xmove+collisionArea.width)/42;
                int myatas= (int) (y+ymove+collisionArea.height)/42;
                if(!checkCollision(mxkiri, myatas)&&!checkCollision(mxkanan, myatas))
                    y+=ymove;
            }else if (ymove>0){ //kebawah
                int mxkiri= (int) (x+xmove)/42;
                int mxkanan= (int) (x+xmove+collisionArea.width)/42;
                int mybawah= (int) (y+ymove+collisionArea.height+collisionArea.y-3)/42;
                if(!checkCollision(mxkiri, mybawah)&&!checkCollision(mxkanan, mybawah))
                    y+=ymove;
                
            }
        }
        
    }
    
    public boolean fieldBound(){
        if (xmove>0){ //gerak kanan
            if( x>=630)return true;
        }if(xmove<0){ //gerak kiri
            if( x<0 ) return true;
        }if(ymove<0) { //gerak ke atas
            if(y<-22) return true;
        }if(ymove>0){ //gerak ke bwh
            if(y>=630) return true;
        }
        return false;
    }
    
    public boolean checkCollision(int x, int y){
        if(handler.getObyekField(x, y)==null) return false;
        else return handler.getObyekField(x,y).isSolid;
             
    }
    
    public float getPosX(){ 
        return x;
    }
    
    public float getPosY(){
        return y;
    }
    
    public int getPosTileX(){
        return (int) getPosX()/Obyek.def_width;
    }
    
    public int getPosTileY(){
        return (int) getPosY()/Obyek.def_height;
    }

}
