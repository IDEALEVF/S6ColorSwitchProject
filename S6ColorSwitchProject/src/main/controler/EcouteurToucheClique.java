package main.controler;

import java.io.File;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import main.model.Collision;
import main.model.Level;

public class EcouteurToucheClique implements EventHandler<KeyEvent>{
	private Level l;
	final File file=new File("src/ressources/jump.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);
	EcouteurToucheClique(Level l){
		this.l = l;
	}

    @Override
    public void handle(KeyEvent evt) {
    	Collision col=new Collision(l.getBall(),l.getObjects());
		col.isCol();
        String touche = evt.getCharacter();
        if(touche.equals("n") || touche.equals("N")){
        	System.out.println("saut");
        	l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
        	//l.gravityDown();
            mediaPlayer.setOnRepeat(null);
        	mediaPlayer.play();
        	System.out.print(mediaPlayer.getStatus());
        }
        mediaPlayer.seek(Duration.ZERO);
        System.out.print(mediaPlayer.getStatus());
    }
}
