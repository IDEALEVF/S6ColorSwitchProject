package main.view.menubar;

import javax.swing.event.MenuEvent;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import main.controler.ControlerFactory;
import main.controler.Moteur;

public class MenuHelp extends Menu{
	Moteur m;
	
	MenuHelp(Moteur m){
		this.m = m;
		this.setText("Help");
		this.getItems().add(new MenuItemHelp());
		
		//this.addEventHandler(WindowEvent.WINDOW_HIDING, 
        		//ControlerFactory.build(WindowEvent.WINDOW_HIDING,null, m));
		//this.setOnShowing((EventHandler<Event>) ControlerFactory.build(WindowEvent.WINDOW_SHOWING,null, m));
		//this.setOnShown((EventHandler<Event>) ControlerFactory.build(MouseEvent.MOUSE_CLICKED,null, m));
		//this.addEventHandler(ActionEvent.ACTION, 
        //		ControlerFactory.build(ActionEvent.ACTION,null, m));
		//this.setOnAction((EventHandler<ActionEvent>) ControlerFactory.build(ActionEvent.ACTION,null, m));
		//this.addEventHandler(MouseEvent.MOUSE_RELEASED, 
		//        		ControlerFactory.build(MouseEvent.MOUSE_RELEASED,null, m));
		//this.setOnHiding((EventHandler<Event>) ControlerFactory.build(WindowEvent.WINDOW_HIDING,null, m));
	}
	
	/*private class entreeMenu implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			m.stop();
		}
	}
	
	private class sortieMenu implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			m.restart();
		}
	    
	}*/
}
