/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.Handler;
import game.Obyek.Field;
import game.UIObjects;
import game.buttonAction;
import game.properties.Image;
import game.properties.LoadSave;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Load extends State {
    
    private boolean sudahCek;
    private boolean file0;
    private boolean file1;
    private boolean file2;
    
    private UIObjects buttonfile0;
    private UIObjects buttonfile1;
    private UIObjects buttonfile2;
    private UIObjects backButton;
    
    public Load(Handler m) {
        super(m);
        sudahCek=false;
        buttonfile0= new UIObjects(350, 200, 330, 90, Image.fileLoad0, m, new buttonAction() {
            @Override
            public void doOnClick() {
                if(State.getState() instanceof Load){
                    Play p= (Play) m.getMain().getPlayState();
                    p.setField(new Field(m, 16, "C:\\\\Users\\\\user\\\\Documents\\\\NetBeansProjects\\\\game\\\\properties\\\\save data\\\\save0.txt"));
                    State.setState(m.getMain().getPlayState());
                }
            
            }
        });
        buttonfile1= new UIObjects(350, 300, 330, 90, Image.fileLoad1, m, new buttonAction() {
            @Override
            public void doOnClick() {
                if(State.getState() instanceof Load){
                    Play p= (Play) m.getMain().getPlayState();
                    p.setField(new Field(m, 16, "C:\\\\Users\\\\user\\\\Documents\\\\NetBeansProjects\\\\game\\\\properties\\\\save data\\\\save0.txt"));
                    State.setState(m.getMain().getPlayState());
                }
            }
        });
        buttonfile2= new UIObjects(350, 400, 330, 90, Image.fileLoad2, m, new buttonAction() {
            @Override
            public void doOnClick() {
                if(State.getState() instanceof Load){
                    Play p= (Play) m.getMain().getPlayState();
                    p.setField(new Field(m, 16, "C:\\\\Users\\\\user\\\\Documents\\\\NetBeansProjects\\\\game\\\\properties\\\\save data\\\\save0.txt"));
                    State.setState(m.getMain().getPlayState());
                }         
            }
        });        
        
        backButton= new UIObjects(385, 500, 260, 63, Image.backButton, m, new buttonAction() {
            @Override
            public void doOnClick() {
                State.setState(m.getMain().getMenuState());
            }
        });                
    }

    @Override
    public void update() {
        if(!sudahCek){
            file0=LoadSave.checkExistenceFile("C:\\\\Users\\\\user\\\\Documents\\\\NetBeansProjects\\\\game\\\\properties\\\\save data\\\\save0.txt");
            file1=LoadSave.checkExistenceFile("C:\\\\Users\\\\user\\\\Documents\\\\NetBeansProjects\\\\game\\\\properties\\\\save data\\\\save1.txt");
            file2=LoadSave.checkExistenceFile("C:\\\\Users\\\\user\\\\Documents\\\\NetBeansProjects\\\\game\\\\properties\\\\save data\\\\save0.txt");
            sudahCek=true;
        }
        buttonfile0.update();
        buttonfile1.update();
        buttonfile2.update();
        backButton.update();
    
    }

    @Override
    public void render(Graphics g) {
        //bg render
        for (int i=0; i<3; i++){
            g.drawImage(Image.menuBG[i], 0, 0, 1024, 1024, null);
        }
        
        //button render
        buttonfile0.render(g);
        buttonfile1.render(g);
        buttonfile2.render(g);
        backButton.render(g);
        
    }

    @Override
    public void init() {
    
    }
    
    public boolean checkFileExistence(String path){
        if (LoadSave.loadFile(path)!=null){
            return true;
        }else{
            return false;
        }
    }
    
}
