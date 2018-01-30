package main.view.menubar;

import javafx.scene.layout.VBox;
import main.controler.Moteur;
import javafx.scene.control.Menu;

public class MenuVitesse extends Menu{
	Moteur m;
	
	MenuVitesse(Moteur m){
		this.m = m;
		this.setText("Vitesse de jeu");
		for(int i=0;i<3;i++) {
			this.getItems().add(new MenuItemVitesse(m , i));
		}
	}
}
