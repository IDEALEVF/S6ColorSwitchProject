package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import main.controler.ControlerFactory;
import main.model.Level;

public class MenuItemNouvellePartie extends MenuItem implements Action{
	Level l;

	MenuItemNouvellePartie(Level l){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));

		this.setGraphic(new ImageView(new Image("save.png")));
		this.l = l;
		this.setText("Nouvelle Partie");

		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l, null, null));
	}

	@Override
	public void action(Level level) {
		l.nouvellePartie("niveau"+l.getNumber());
	}
}
