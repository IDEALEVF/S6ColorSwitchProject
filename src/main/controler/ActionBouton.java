package main.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.model.Level;
import main.view.menubar.Action;

/**
 * Modelise l'action sur un bouton de menu
 * @since 04/03/18
 * @version 1.0
 * @author Barrech Mehdi
 * */
class ActionBouton implements EventHandler<ActionEvent>{
	Moteur m;
	Level l;

	ActionBouton(Moteur m, Level l){
		this.m = m;
		this.l = l;
	}

    @Override
    public void handle(ActionEvent t) {
    	Action item = (Action) t.getTarget();
    	item.action(l);
    }
}
