package main.view.menubar;

import javafx.scene.layout.VBox;
import main.controler.Moteur;
import javafx.scene.control.Menu;

public class MenuVitesse extends Menu{
	VBox root;
	Moteur m;
	
	MenuVitesse(VBox root, Moteur m){
		this.m = m;
		this.root = root;
		this.setText("Vitesse de jeu");
		for(int i=0;i<3;i++) {
			this.getItems().add(new MenuItemVitesse(root, m , i));
		}
	}
}
