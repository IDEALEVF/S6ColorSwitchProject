package main.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import main.model.ColorSelected;

public class MenuBar2 extends MenuBar{
	VBox root;
    
	MenuBar2(VBox root){
		this.root = root;
		
		Menu m = new Menu("Fichier");
		MenuItem i = new MenuItem("Changer couleur fond");
		
		i.setOnAction(new actionBouton());
		m.getItems().add(i);
		
		this.getMenus().add(m);
		Background b = new Background(new BackgroundFill(ColorSelected.MENU,null,null));
		this.setBackground(b);
		
	}
	
	private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
            StackPane v = (StackPane) root.getChildren().get(1);
            Rectangle r = (Rectangle) v.getChildren().get(0);
            r.setFill(ColorSelected.BLUE);
        }
	}
}
