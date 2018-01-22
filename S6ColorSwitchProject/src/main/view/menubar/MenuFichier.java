package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import main.controler.Moteur;
import main.model.ColorSelected;

public class MenuFichier extends Menu{
	VBox root;
	Moteur m;
	
	MenuFichier(VBox root, Moteur m){
		this.m = m;
		this.root = root;
		this.setText("Fichier");
		this.getItems().add(new MenuItemNouvellePartie(root));//new MenuItemNouvellePartie(root)
		this.getItems().add(new MenuNiveau(root));
		this.getItems().add(new MenuVitesse(root, m));
		this.getItems().add(new SeparatorMenuItem());
		this.getItems().add(new MenuItemQuitter());
		
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
