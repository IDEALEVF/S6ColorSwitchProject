package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.stage.WindowEvent;
import main.controler.Moteur;

public class ContextualMenu extends ContextMenu{
	Moteur m;
	
	public ContextualMenu(Moteur m){
		this.m = m;
		this.getItems().add(new MenuItemQuitter());
		this.setOnShowing(new entreeMenu());
		this.setOnHiding(new sortieMenu());
	}
	
	private class entreeMenu implements EventHandler<WindowEvent>{
		@Override
		public void handle(WindowEvent arg0) {
			m.stop();
			
		}
	}
	
	private class sortieMenu implements EventHandler<WindowEvent>{
		@Override
		public void handle(WindowEvent arg0) {
			m.restart();
		}
	}
}
