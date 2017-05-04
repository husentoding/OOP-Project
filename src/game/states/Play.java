/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.Handler;
import game.Obyek.Farmer;
import game.Obyek.Field;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Play extends State {
   
 
    private Farmer farmer;
    private Field field;
    public Play(Handler m){
        super(m);
        farmer= new Farmer(m, 100, 20);
       // field= new Field(m, 16,"C:\\Users\\user\\Documents\\NetBeansProjects\\game\\properties\\save data\\save0.txt");
        field= new Field(m,16);
    }

    
    @Override
    public void init(){

    }

    @Override
    public void update() {
        farmer.update();
        field.update();
    }

    @Override
    public void render(Graphics g) {
        field.render(g);
        farmer.render(g);
        
    }
    public Field getField(){
        return field;
    }
    
    
    public void setField(Field field){
        this.field= field;
    }
    
}
