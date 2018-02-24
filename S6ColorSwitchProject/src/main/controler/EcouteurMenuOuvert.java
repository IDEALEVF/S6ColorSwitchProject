package main.controler;

import javafx.event.EventHandler;
import javafx.event.Event;

class EcouteurMenuOuvert implements EventHandler<Event> {
	Moteur m;
	
	EcouteurMenuOuvert(Moteur m){
		this.m = m;
	}

	@Override
	public void handle(Event evt) {
		m.stop();
	}
}
