package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import main.controler.Moteur;
import main.model.ColorSelected;
import javafx.scene.layout.VBox;

public class MenuItemNouvellePartie extends MenuItem{
	Moteur m;

	MenuItemNouvellePartie(Moteur m){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
		this.setGraphic(new ImageView(new Image("save.png")));
		this.m = m;
		this.setText("Nouvelle Partie");
		
		this.setOnAction(new actionBouton());
	}
	
	private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
            System.out.println("Nouvelle partie");
        }
	}
}
