package main.controler;

import javafx.event.EventHandler;
import main.model.Level;
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
		if(m.isUnused()) {
			m.restart();
		}
		l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
		l.gravityDown();
	}
}
