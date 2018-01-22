package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import main.model.ColorSelected;
import javafx.scene.layout.VBox;
import javafx.scene.control.MenuItem;

public class MenuItemNiveau extends MenuItem{
	VBox root;
	int num;
	
	MenuItemNiveau(VBox root, int num){
		this.root = root;
		this.num = num;
		this.setText("Niveau "+num);
		
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
