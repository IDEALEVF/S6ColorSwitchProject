package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import main.model.ColorSelected;
import javafx.scene.layout.VBox;

public class MenuItemNouvellePartie extends MenuItem{
	VBox root;

	MenuItemNouvellePartie(VBox root){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
		this.setGraphic(new ImageView(new Image("save.png")));
		this.root = root;
		this.setText("Nouvelle Partie");
		
		this.setOnAction(new actionBouton());
	}
	
	private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
            StackPane v = (StackPane) root.getChildren().get(1);
            Rectangle r = (Rectangle) v.getChildren().get(0);
            r.setFill(ColorSelected.BLUE);
        	//Background b = new Background(new BackgroundFill(ColorSelected.MENU,null,null));
    		//StackPane sp = (StackPane) root.getChildren().get(1);//recuperation des composants
    		//sp.setBackground(b);//fond
        }
	}
}
