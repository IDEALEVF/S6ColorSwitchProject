package main.view.menubar;

import javafx.event.ActionEvent;
import main.controler.ControlerFactory;
import main.model.Level;
import main.view.Fenetre;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class MenuItemNiveau extends MenuItem implements Action{
	int num;
	Object src;
	MenuItemNiveau(Level l, int num,Object src){
		this.num = num;
		this.setText("Niveau "+num);
		this.src=src;
//		if(num == 1) {//assuprimer
//			this.setAccelerator(KeyCombination.keyCombination("Ctrl+b"));
//		}
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+"+(char)('a' + num)));

		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l));
	}

	public int getNum() {
		return num;
	}

	@Override
	public void action(Level level) {
		System.out.println("Changement de niveau : "+this.getNum());
		level.nouvellePartie("niveau"+this.getNum());

		((Fenetre)src).nv=false;//pour remettre
		((Fenetre)src).btnv=true;//les bons sons
		//level.update();
	}
}
