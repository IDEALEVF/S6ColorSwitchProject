package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import main.controler.ControlerFactory;
import main.controler.Moteur;

public class MenuItemScore extends MenuItem{
	Moteur m;
	
	MenuItemScore(Moteur m){
		this.m = m;
		this.setText("Score");
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, m));
	}
}
