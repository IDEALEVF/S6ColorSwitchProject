package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import main.controler.Moteur;
import main.model.ColorSelected;
import javafx.scene.layout.VBox;
import javafx.scene.control.MenuItem;

public class MenuItemNiveau extends MenuItem{
	Moteur m;
	int num;
	
	MenuItemNiveau(Moteur m, int num){
		this.m = m;
		this.num = num;
		this.setText("Niveau "+num);
		
		this.setOnAction(new actionBouton());
	}

	private class actionBouton implements EventHandler<ActionEvent>{
	    @Override
	    public void handle(ActionEvent t) {
	        System.out.println("Changement de niveau : "+num);
	    }
	}
}
