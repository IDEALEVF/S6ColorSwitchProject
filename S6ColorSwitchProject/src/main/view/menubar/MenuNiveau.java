package main.view.menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import main.controler.Moteur;

public class MenuNiveau extends Menu{
	Moteur m;

	MenuNiveau(Moteur m){
		this.m = m;
		this.setText("Niveau");
		//this.setGraphic(new ImageView(new Image("lv.png")));
		for(int i = 1; i< 6; i++) {//ajout des niveaux
			this.getItems().add(new MenuItemNiveau(m, i));
		}
	}
}
