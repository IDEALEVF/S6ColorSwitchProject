package main.view.menubar;

import main.model.Level;
import main.model.Type;

import java.io.File;

import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MenuChoixNiveau extends Menu{

	MenuChoixNiveau(Level l, Type type,Object src){
		this.setText(type.name());
		this.setGraphic(new ImageView(new Image("lv"+type.name()+".png")));
		
		File dir = new File("src/ressources/niveaux/"+type.name());
		File[] niveaux = dir.listFiles();
		for(int i=0;i<niveaux.length;i++) {
			this.getItems().add(new MenuItemNiveau(l, niveaux[i], type, src));
		}
	}

}
