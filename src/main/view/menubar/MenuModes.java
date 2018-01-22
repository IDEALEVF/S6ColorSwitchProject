package main.view.menubar;

import javafx.scene.layout.VBox;
import main.controler.Moteur;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;

public class MenuModes extends Menu{
	VBox root;
	Moteur m;

	MenuModes(VBox root, Moteur m){
		this.m = m;
		this.root = root;
		this.setText("Modes de jeu");
		for(int i=0;i<5;i++) {
			this.getItems().add(new MenuItemMode(root, m , i));
		}
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
