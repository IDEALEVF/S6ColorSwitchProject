package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import main.controler.Moteur;
import javafx.scene.layout.BorderPane;

public class MenuFichier extends Menu{
	Moteur m;
	
	MenuFichier(Moteur m){
		this.m = m;
		this.setText("Fichier");
		this.getItems().add(new MenuItemNouvellePartie(m));//new MenuItemNouvellePartie(root)
		this.getItems().add(new MenuNiveau(m));
		this.getItems().add(new MenuVitesse(m));
		this.getItems().add(new SeparatorMenuItem());
		this.getItems().add(new MenuItemQuitter());
		this.getItems().add(new MenuItemScore(m));
		
		this.setOnAction(new actionMenu());
		this.setOnShowing(new entreeMenu());
		this.setOnHiding(new sortieMenu());
	}
	
	private class actionMenu implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
        	System.out.println("coucouMenu");
        }
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
