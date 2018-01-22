package main.view.menubar;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import main.controler.Moteur;

public class MenuHelp extends Menu{
	Moteur m;
	
	MenuHelp(Moteur m){
		this.m = m;
		this.setText("Help");
		this.getItems().add(new MenuItemHelp());
		
		this.setOnShowing(new entreeMenu());
		this.setOnHiding(new sortieMenu());
	}
	
	private class entreeMenu implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			m.stop();
		}
	    
	}
	
	private class sortieMenu implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			m.restart();
		}
	    
	}
}
