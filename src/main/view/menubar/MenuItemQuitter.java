package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;

public class MenuItemQuitter extends MenuItem{

	MenuItemQuitter(){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+q"));
		this.setGraphic(new ImageView(new Image("save.png")));
		this.setText("Quitter");
		
		this.setOnAction(new actionBouton());
	}
	
	private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
            System.exit(0);
        }
	}
}
