package main.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.model.Level;
import main.view.menubar.DialogHelp;
import main.view.menubar.DialogScores;
import main.view.menubar.MenuItemHelp;
import main.view.menubar.MenuItemMode;
import main.view.menubar.MenuItemNiveau;
import main.view.menubar.MenuItemNouvellePartie;
import main.view.menubar.MenuItemQuitter;
import main.view.menubar.MenuItemScore;
import main.view.menubar.MenuItemVitesse;

class ActionBouton implements EventHandler<ActionEvent>{
	Moteur m;
	Level l;
	
	ActionBouton(Moteur m, Level l){
		this.m = m;
		this.l = l;
	}
	
    @Override
    public void handle(ActionEvent t) {
    	if(t.getTarget().getClass().equals(MenuItemVitesse.class)) {//si l'appel vient de MenuItemVitesse
    		MenuItemVitesse obj = (MenuItemVitesse) t.getTarget();
    		System.out.println("Vitesse "+obj.getVitesse());
    	}else if(t.getTarget().getClass().equals(MenuItemHelp.class)) {//si l'appel vient de MenuItemHelp
	    	System.out.println("Bonjour");
	    	new DialogHelp();
    	}else if(t.getTarget().getClass().equals(MenuItemScore.class)) {//si l'appel vient de MenuItemScore
	    	new DialogScores(l);
    	}else if(t.getTarget().getClass().equals(MenuItemNouvellePartie.class)) {//si l'appel vient de MenuItemNouvellePartie
    		System.out.println("Nouvelle partie");
    		l.nouvellePartie("niveau"+l.getNumber());
    		l.update();
    	}else if(t.getTarget().getClass().equals(MenuItemNiveau.class)) {//si l'appel vient de MenuItemNiveau
    		MenuItemNiveau obj = (MenuItemNiveau) t.getTarget();
    		System.out.println("Changement de niveau : "+obj.getNum());
    		l.nouvellePartie("niveau"+obj.getNum());
    		l.update();
    	}else if(t.getTarget().getClass().equals(MenuItemMode.class)) {//si l'appel vient de MenuItemMode
    		MenuItemMode obj = (MenuItemMode) t.getTarget();
    		System.out.println("Mode "+obj.getType().name());
    	}else if(t.getTarget().getClass().equals(MenuItemQuitter.class)){//si l'appel vient de MenuItemQuitter
    		System.exit(0);
    	}else {//action par defaut
    		System.out.println("fait l'action par defaut");
    		m.stop();
    	}
    }
}
