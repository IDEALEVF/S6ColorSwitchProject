package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import main.controler.Moteur;

public class MenuItemVitesse extends MenuItem{
	Moteur m;
	int vitesse;
	
	MenuItemVitesse(Moteur m, int vitesse){
		this.m = m;
		this.vitesse = vitesse;
		this.setText("Mode "+vitesse);
		this.setOnAction(new actionBouton());
	}
	
	private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
            System.out.println("Vitesse "+vitesse);
        }
	}
}
