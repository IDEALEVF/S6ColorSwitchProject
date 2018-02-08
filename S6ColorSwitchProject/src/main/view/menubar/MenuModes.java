package main.view.menubar;

import main.controler.Moteur;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;

public class MenuModes extends Menu{
	Moteur m;

	MenuModes(Moteur m){
		this.m = m;
		this.setText("Modes de jeu");
		for(int i=0;i<5;i++) {
			this.getItems().add(new MenuItemMode(m , i));
		}
		//this.setOnShowing(new entreeMenu());
		//this.setOnHiding(new sortieMenu());
	}
	
	/*private class entreeMenu implements EventHandler<Event>{

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
        
	}*/
}
