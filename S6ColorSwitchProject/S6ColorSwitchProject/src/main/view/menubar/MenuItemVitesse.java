package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import main.controler.ControlerFactory;
import main.controler.Moteur;

public class MenuItemVitesse extends MenuItem{
	Moteur m;
	int vitesse;
	
	MenuItemVitesse(Moteur m, int vitesse){
		this.m = m;
		this.vitesse = vitesse;
		this.setText("Mode "+vitesse);
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, null));
	}

	public int getVitesse() {
		return vitesse;
	}
}
