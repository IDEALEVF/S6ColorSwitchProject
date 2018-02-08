package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.model.Type;

public class MenuItemMode extends MenuItem {
	Moteur m;
	Type modeType;
	
	MenuItemMode(Moteur m, int mode){
		this.m = m;
		switch(mode) {
		case 1:modeType = Type.INVERSE;break;
		case 2:modeType = Type.DEUX_AXES;break;
		case 3:modeType = Type.AUTOMATIQUE;break;
		case 4:modeType = Type.IA;break;
		default:modeType = Type.NORMAL;
		}
		this.setText("Mode "+modeType.name());
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, m));
	}
	
	public Type getType() {
		return modeType;
	}
}
