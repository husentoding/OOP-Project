/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Inputs.Keyboard;
import game.Inputs.Mouse;
import game.properties.Audio;
import game.properties.FontLoader;
import game.properties.Image;
import game.states.Load;
import game.states.Menu;
import game.states.Play;
import game.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Main implements Runnable{
    //window size
    private int width=1024,height=1024;
    
    //state variables
    private State playState;
    private State menuState;
    private State loadState;
    
    //graphics and game running
    private Thread thread;
    private Window w;
    private BufferStrategy bs;  //bufferstrategy tells how to draw into the screen //buffer is a hidden screen
    private Graphics g;
    private boolean running=false;
    public static int ticks;
    
    // inputs
    private Keyboard kb;
    private Mouse ms;
    
    //handler
    private Handler handler;

    public Main(){
        kb= new Keyboard();
        ms= new Mouse();
    }

    private void init(){
        w= new Window(width,height);
        w.getJFrame().addKeyListener(kb);
        w.getJFrame().addMouseListener(ms);
        w.getJFrame().addMouseMotionListener(ms);
        w.getCanvas().addMouseListener(ms);
        w.getCanvas().addMouseMotionListener(ms);
        Image.load();
        Audio.loadAudio();
        FontLoader.loadFont();
        
        handler= new Handler(this);
        playState= new Play(handler);
        menuState= new Menu(handler);
        loadState= new Load(handler);
        playState.init();
        State.setState(menuState);
        
    }
    private void update(){
        kb.update();
        if(State.getState()!=null)
            State.getState().update();
    }
    private void render(){
        bs= w.getCanvas().getBufferStrategy(); 
        if(bs==null){
            w.getCanvas().createBufferStrategy(3);
            return;
        }
        g= bs.getDrawGraphics();
        //bersihkan layar
        g.fillRect(0, 0, width, height);
        
        //draw here
        if(State.getState()!=null)
            State.getState().render(g);
        
        //end
        bs.show();
        g.dispose();
    }
    
    
    
    
    @Override
    public void run() {
        init();
        int fps=120;
        double timeTick=1000000000/fps;
        double d= 0;                        //fps configuration
        long current;
        long before= System.nanoTime();
        long timer=0;
        ticks=0;
        
        
        while(running){
            current= System.nanoTime();
            d+= (current-before)/timeTick;      //fps configuration
            timer += current-before;            //buat show fps
            before= current;
            
            if (d>=1){
                update();
                render();
                ticks++;
                d--;
            }
            if(timer>=1000000000){          //show fps tiap detik
                System.out.println("fps: "+ticks);
                ticks=0;
                timer=0;
            }

        }
        stop();
        
    }
    
    
    
    public synchronized void start(){  //if we are using thread we have to use this
        if (running)
            return;
        running= true;
        thread = new Thread(this);
        thread.start();                 //this method will call our run method
    }
    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try {
            thread.join();          //this will stop the thread/close
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Keyboard getKeyboard(){
        return kb;
    }
    
    public Mouse getMouse(){
        return ms;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public State getMenuState(){
        return menuState;
    }
    public State getPlayState(){
        return playState;
    }
    public State getLoadState(){
        return loadState;
    }
    
    
   
    
}
