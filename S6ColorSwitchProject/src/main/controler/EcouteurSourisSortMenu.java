package main.controler;

import javafx.event.EventHandler;
import javafx.event.Event;

class EcouteurSourisSortMenu implements EventHandler<Event> {
	Moteur m;
	
	EcouteurSourisSortMenu(Moteur m){
		this.m = m;
	}

	@Override
	public void handle(Event evt) {
		m.restart();
	}
}
