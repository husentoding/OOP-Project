/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.properties;

import game.Obyek.Dog;
import game.Obyek.Obyek;
import game.Obyek.Rock;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class LoadSave {
    
    public static String loadFile(String path){
        StringBuilder builder= new StringBuilder();
        try {
            BufferedReader br= new BufferedReader(new FileReader(path));
            String line;
            while((line= br.readLine())!=null){
                builder.append(line+"\n");
            } 
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
    
    public static int parseInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static void saveFile(Obyek[][] objek) throws IOException{
        FileWriter fw= null;
        BufferedWriter bw= null;
        
        fw= new FileWriter("C:\\Users\\user\\Documents\\NetBeansProjects\\game\\properties\\save data\\savedata20.txt");
        bw= new BufferedWriter(fw);
        
        for(int i=0;i<16;i++){
            for(int j=0; j<objek[i].length; j++){
                if(objek[i][j] instanceof Dog )
                    bw.write("1");
                if(objek[i][j] instanceof Rock )
                    bw.write("2"); 
                bw.write(" ");
            }
            bw.newLine();
        }
        
        
        bw.close();
        fw.close();
        
        
    }
    
    public static boolean checkExistenceFile(String path){
        File f= new File(path);
        if(f.exists() && !f.isDirectory())
            return true;
        else
            return false;
    }
    
}
