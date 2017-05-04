/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.Handler;
import game.UIObjects;
import game.buttonAction;
import game.properties.Image;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Menu extends State {
    

    private UIObjects buttonStart;
    private UIObjects buttonQuit;
    private UIObjects buttonLoad;

    public Menu(Handler m) {
        super(m);
        buttonStart= new UIObjects(440, 90, 125, 125, Image.buttonStart, m, new buttonAction() {
            @Override
            public void doOnClick() {
                State.setState(m.getMain().getPlayState());
                m.getMain().getPlayState().init();
            }
        });
        buttonLoad= new UIObjects(400, 275, 200, 105, Image.buttonLoad, m, new buttonAction() {
            @Override
            public void doOnClick() {
                State.setState(m.getMain().getLoadState());
            }
        });
        
        buttonQuit= new UIObjects(440, 390, 125, 125, Image.buttonQuit, m, new buttonAction() {
            @Override
            public void doOnClick() {
                System.exit(0);
            }
        });
        
        
    }

    @Override
    public void update() {
        buttonStart.update();
        buttonQuit.update();
        buttonLoad.update();
    }

    @Override
    public void render(Graphics g) {
        //bg render
        for (int i=0; i<3; i++){
            g.drawImage(Image.menuBG[i], 0, 0, 1024, 1024, null);
        }
            
        //button render
        buttonStart.render(g);
        buttonQuit.render(g);
        buttonLoad.render(g);
    }

    @Override
    public void init() {
    }
    
}
