package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import main.controler.ControlerFactory;

public class MenuItemHelp extends MenuItem {

	MenuItemHelp(){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+h"));
		this.setGraphic(new ImageView(new Image("help.png")));
		this.setText("Help");
		this.addEventHandler(DialogEvent.DIALOG_SHOWING,
        		ControlerFactory.build(DialogEvent.DIALOG_SHOWING, null, null));
	}
	
	/*private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
        	System.out.println("Bonjour");
        	new DialogHelp();//j' en suis la
        }
	}*/
}
