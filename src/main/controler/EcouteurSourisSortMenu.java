package main.controler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import main.model.Level;
import main.model.Type;
import main.model.forms.Ball;
import main.model.forms.BoutonJouer;
import main.view.Fenetre;

import java.io.File;

import javafx.application.Platform;
import javafx.event.Event;

/**
 * Ecouteur souris
 * @author CALVO FERNANDEZ Adélie
 * @version 1.0
 * */
class EcouteurSourisSortMenu implements EventHandler<Event> {
	Moteur m;
	Level l;
	final File file=new File("src/ressources/jump.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);

	final File file2=new File("src/ressources/inprogress.wav");
	final  Media media2 = new Media(file2.toURI().toString());
	final MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
	Object src;
	EcouteurSourisSortMenu(Moteur m, Level l, Object src){
		this.m = m;
		this.l = l;
		mediaPlayer.setOnRepeat(null);

		mediaPlayer2.setOnRepeat(null);
		this.src=src;
	}

	@Override
	public void handle(Event evt) {
		//if(!l.isPerdu()) {
		//pourquoi ça passe dans le si et le else
		if(evt.getSource().getClass().equals(javafx.stage.Stage.class)&& ((Fenetre)src).nv){
			if(!((Fenetre)src).btnv){
				//System.out.println("ICI\n"+src.getClass());
				//System.out.println(Fenetre.class);
				mediaPlayer2.seek(Duration.ZERO);
		    	mediaPlayer2.play();//joue un son
			}else{

				mediaPlayer2.seek(Duration.ZERO);
		    	mediaPlayer2.play();//joue un son
		        ((Fenetre)src).nv=false;
			}


		}
		else{
			//System.out.println(evt.getSource().getClass());
			//System.out.println("ICI2222\n"+(src!=null?src.getClass():"src")+((Fenetre)src).nv);
			mediaPlayer.seek(Duration.ZERO);
			mediaPlayer.play();//joue un son


		}
		if(l.getBall() != null) {
			if(((MouseEvent)evt).getButton().equals(MouseButton.PRIMARY)){
	        	if(l.getType() == Type.AUTOMATIQUE) {
	        		l.getBall().start();
	        		l.getBall().setCouleur(l.getNextColor());//change la couleur de la balle
	        		l.getChrome().rotateChromeLeft();
	        	}else {
	        		l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
	            	l.gravityDown();
	        	}
	        }

	        if(((MouseEvent)evt).getButton().equals(MouseButton.SECONDARY)) {
	        	if(l.getType() == Type.AUTOMATIQUE) {
	        		l.getBall().start();
	        		l.getBall().setCouleur(l.getPreviewsColor());//change la couleur de la balle
	        		l.getChrome().rotateChromeRight();
	        	}else {
	        		l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
	            	l.gravityDown();
	        	}
	        }
		}
		m.restart();
	}
}