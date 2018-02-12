package main.controler;

import javafx.event.EventHandler;
import javafx.event.Event;

class EcouteurMenuFerme implements EventHandler<Event> {
	Moteur m;
	
	EcouteurMenuFerme(Moteur m){
		this.m = m;
	}

	@Override
	public void handle(Event evt) {
		m.restart();
	}
}
