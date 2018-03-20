package main.view.menubar;




import java.io.File;
import java.net.URL;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import main.controler.ControlerFactory;
import main.model.Level;

public class MenuItemHelp extends MenuItem implements Action{
	Stage stage = new Stage();
	final Alert alert = new Alert(Alert.AlertType.INFORMATION);
	MenuItemHelp(){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+h"));
		this.setGraphic(new ImageView(new Image("help.png")));
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Projet realise par PITROU Adrien, CALVO FERNANDEZ Adélie et BARRECH Mehdi");
		this.setText("Help");
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, null));
	}

	@Override
	public void action(Level level) {
		alert.show();
		/*result.ifPresent(button -> {
		    if (button == ButtonType.OK) {

		    }
		});*/
		//alert.initOwner(stage);
	}

	/*private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
        	System.out.println("Bonjour");

        }
	}*/
}
