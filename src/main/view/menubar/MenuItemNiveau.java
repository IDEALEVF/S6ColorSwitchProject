package main.view.menubar;

import java.io.File;

import javafx.event.ActionEvent;
import main.controler.ControlerFactory;
import main.model.Level;
import main.model.Type;
import main.view.Fenetre;
import javafx.scene.control.MenuItem;

public class MenuItemNiveau extends MenuItem implements Action{
	private File lv;
	private Type type;
	private Object src;

	MenuItemNiveau(Level l, File lv, Type type,Object src){
		this.lv = lv;;
		this.type = type;
		this.src = src;
		this.setText(""+getLvName());
//		if(num == 1) {//assuprimer
//			this.setAccelerator(KeyCombination.keyCombination("Ctrl+b"));
//		}

		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l));
	}

	private String getLvName() {
		return lv.getName().substring(0, lv.getName().length() - 4);
	}

	public File getLv() {
		return lv;
	}

	@Override
	public void action(Level level) {
		System.out.println("Changement de niveau : "+getLvName());
		level.nouvellePartie(this.type.name()+"/"+getLvName());

		((Fenetre)src).setNv(false);//pour remettre
		((Fenetre)src).setBtnv(true);//les bons sons
	}
}
