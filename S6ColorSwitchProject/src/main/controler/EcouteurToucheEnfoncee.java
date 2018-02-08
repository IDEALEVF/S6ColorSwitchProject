package main.controler;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import main.model.Level;

class EcouteurToucheEnfoncee implements EventHandler<KeyEvent>{
	private Level l;
	
	EcouteurToucheEnfoncee(Level l){
		this.l = l;
	}
	
    @Override
    public void handle(KeyEvent evt) {
        String touche = evt.getText();
        if(touche.equals("n")){
        	l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
        	//l.gravityDown();
        }
    }
}
