/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.properties;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FontLoader {
    
    public static Font font;
    
    public static void loadFont(){
        font= load("C:\\Users\\user\\Documents\\NetBeansProjects\\game\\properties\\fonts\\manaspc.ttf", 24f);
        if (font==null)
            System.out.println("kosong");
    }
    
    public static Font load(String path, float size){
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException ex) {
            Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (IOException ex) {
            Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
}
