/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.properties;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author user
 */
public class Audio {
    
    private Clip clip;
    public static AudioClip ready;
    
    public static void loadAudio(){
        ready=loadSound("/readys.wav");
        
    }

    
    public static AudioClip loadSound(String path){
        try {
            return Applet.newAudioClip(Audio.class.getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//String bip = "bip.mp3";
//Media hit = new Media(new File(bip).toURI().toString());
//MediaPlayer mediaPlayer = new MediaPlayer(hit);
//mediaPlayer.play();
}
