package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.controler.ControlerFactory;
import main.controler.Moteur;

public class MenuItemVitesse extends MenuItem{
	Moteur m;
	int vitesse;
	
	@SuppressWarnings("unchecked")
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
