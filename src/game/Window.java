/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class Window {
    
    private JFrame window;
    private int width,height;
    
    private Canvas canvas;
    
    
    public Window(int width,int height){
        this.width = width;
        this.height= height;
        createWindow("Game");
    }
    public void createWindow(String title){
        window= new JFrame(title);
        window.setSize(width,height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        canvas= new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setFocusable(false);
        
        window.add(canvas);
        window.pack();
        
        
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getJFrame(){
        return window;
    }
    
}
