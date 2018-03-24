package main.controler;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import main.model.Level;

/**
 * Ecoute le click sur une touche de clavier
 * @author CALVO FERNANDEZ Adélie
 * @since 20/03/18
 * @version 1.0
 * */
public class EcouteurToucheClique implements EventHandler<KeyEvent>{
	final File file=new File("src/ressources/jump.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);

	EcouteurToucheClique(Level l){
		mediaPlayer.setOnRepeat(null);
	}

    @Override
    public void handle(KeyEvent evt) {
        String touche = evt.getCharacter();

        if(touche.equalsIgnoreCase("N")||touche.equalsIgnoreCase("B")){
        	mediaPlayer.seek(Duration.ZERO);
        	mediaPlayer.play();//joue un son
        }
    }
}
