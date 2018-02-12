package main.controler;

import java.net.URL;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.model.Level;

public class EcouteurToucheClique implements EventHandler<KeyEvent>{
	private Level l;
	/*final URL musicURL = getClass().getResource("jump.wav");
	final  Media media = new Media(musicURL.toExternalForm());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);*/
	EcouteurToucheClique(Level l){
		this.l = l;
	}

    @Override
    public void handle(KeyEvent evt) {
        String touche = evt.getText();
        if(touche.equals("n")){
        	System.out.println("saut");
        	//l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
        	//l.gravityDown();
        	//mediaPlayer.play();
        }
    }
}
