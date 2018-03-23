package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import main.controler.ControlerFactory;
import main.model.Level;
/**
 * @author CALVO FERNANDEZ Adélie
 * @version 1.0
 * */
public class MenuItemHelp extends MenuItem implements Action{
	Stage stage = new Stage();
	final Alert alert = new Alert(Alert.AlertType.INFORMATION);
	MenuItemHelp(){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+h"));
		this.setGraphic(new ImageView(new Image("help.png")));
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Projet réalisé par PITROU Adrien, CALVO FERNANDEZ Adélie et BARRECH Mehdi");
		this.setText("Help");
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, null,null));
	}

	@Override
	public void action(Level level) {
		alert.show();
	}
}
