package main.view.menubar;

import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.Level;
import main.model.Type;

public class MenuNiveau extends Menu{
	
	MenuNiveau(Level l, Object src){
		this.setText("Niveau");
		this.setGraphic(new ImageView(new Image("lv.png")));

		this.getItems().add(new MenuChoixNiveau(l, Type.NORMAL, src));
		this.getItems().add(new MenuChoixNiveau(l, Type.AUTOMATIQUE, src));
		this.getItems().add(new MenuChoixNiveau(l, Type.INVERSE, src));
		this.getItems().add(new MenuChoixNiveau(l, Type.ENDLESS, src));
		
	}
}
