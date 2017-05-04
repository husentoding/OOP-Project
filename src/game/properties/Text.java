/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.properties;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Text {
    public static void drawString(Graphics g, String text, int x, int y, boolean center, Color c, Font f){
        g.setColor(c);
        g.setFont(f);
        int posX= x;
        int posY= y;
        if (center){
            FontMetrics fm= g.getFontMetrics(f);
            x= posX- fm.stringWidth(text)/2;
            y= (posY- fm.getHeight()/2 )+ fm.getAscent();
        }
        g.drawString(text,x,y);
    }
}
