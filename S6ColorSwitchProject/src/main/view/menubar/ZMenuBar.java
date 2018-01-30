package main.view.menubar;

import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import main.controler.Moteur;
import main.model.ColorSelected;
import javafx.scene.layout.BorderPane;

public class ZMenuBar extends MenuBar{
	BorderPane root;
	Moteur m;
    
	public ZMenuBar(BorderPane root, Moteur m){
		this.root = root;
		
		this.getMenus().add(new MenuFichier(m));
		this.getMenus().add(new MenuModes(m));
		this.getMenus().add(new MenuHelp(m));
		Background b = new Background(new BackgroundFill(ColorSelected.MENU,null,null));
		this.setBackground(b);
		this.setOnMouseClicked(new actionEntree());
	}
	
	private class actionEntree implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent t) {
            System.out.println("action Menubar");
        }
	}
}
