package main.view.menubar;

import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.model.Level;
import javafx.scene.layout.BorderPane;

public class ZMenuBar extends MenuBar{
	BorderPane root;
	Moteur m;
    
	public ZMenuBar(BorderPane root, Moteur m, Level l){
		this.root = root;
		
		this.getMenus().add(new MenuFichier(m, l));
		this.getMenus().add(new MenuModes(l));
		this.getMenus().add(new MenuHelp(m, l));
		Background b = new Background(new BackgroundFill(ColorSelected.MENU,null,null));
		this.setBackground(b);
		//this.setOnMouseClicked(ControlerFactory.build(MouseEvent.MOUSE_CLICKED, null, null));
		this.setOnMouseEntered(ControlerFactory.build(MouseEvent.MOUSE_ENTERED, null, m));
		//this.setOnMouseExited(ControlerFactory.build(MouseEvent.MOUSE_EXITED, null, m));
		//this.setEventHandler(MouseEvent.MOUSE_PRESSED, ControlerFactory.build(MouseEvent.MOUSE_CLICKED, null, null));
	}
}
