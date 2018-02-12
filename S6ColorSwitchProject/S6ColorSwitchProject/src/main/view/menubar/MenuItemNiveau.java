package main.view.menubar;

import javafx.event.ActionEvent;
import main.controler.ControlerFactory;
import main.model.Level;
import javafx.scene.control.MenuItem;

public class MenuItemNiveau extends MenuItem{
	int num;
	
	MenuItemNiveau(Level l, int num){
		this.num = num;
		this.setText("Niveau "+num);
		
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l));
	}
	
	public int getNum() {
		return num;
	}
}
