package main.view.menubar;

import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.Level;

public class MenuFormesBalle extends Menu{

	public MenuFormesBalle(Level l){
		this.setText("Balles");
		this.setGraphic(new ImageView(new Image("lv.png")));

		for(int i = 1; i<= 3; i++) {//ajout des balles
			this.getItems().add(new MenuItemFormeBalle(i, l));
		}
	}
}