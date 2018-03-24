package main.controler;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import main.model.Level;
import main.view.Fenetre;

class ActionNouvellePartie implements EventHandler<MouseEvent>{
    Level level;

    final File file=new File("src/ressources/inprogress.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);
	Object src;
    ActionNouvellePartie(Level level,Object src){
		mediaPlayer.setOnRepeat(null);
    	this.level = level;
		this.src=src;
    }

    @Override
    public void handle(MouseEvent t) {
    	mediaPlayer.seek(Duration.ZERO);
        level.nouvellePartie("ENDLESS/niveau1");
        ((Fenetre)src).setBtnv(true);
        //level.update();
    }
}