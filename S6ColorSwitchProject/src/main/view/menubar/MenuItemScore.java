package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import main.controler.Moteur;

public class MenuItemScore extends MenuItem{
	Moteur m;
	
	MenuItemScore(Moteur m){
		this.m = m;
		this.setText("Score");
		this.setOnAction(new actionBouton());
	}
	
	private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
            new DialogScores(m);
        }
	}
}
