package main.controler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.model.Level;
import main.model.Type;
import javafx.application.Platform;
import javafx.event.Event;

class EcouteurSourisSortMenu implements EventHandler<Event> {
	Moteur m;
	Level l;

	EcouteurSourisSortMenu(Moteur m, Level l){
		this.m = m;
		this.l = l;
	}

	@Override
	public void handle(Event evt) {
		//if(!l.isPerdu()) {
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
