package main.view.menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;
import main.controler.Moteur;
import main.model.Level;

public class MenuFichier extends Menu{
	Moteur m;

	MenuFichier(Moteur m, Level l){
		this.m = m;
		this.setText("Fichier");
		this.getItems().add(new MenuItemNouvellePartie(l));//new MenuItemNouvellePartie(root)
		this.getItems().add(new MenuFormesBalle(l));
		//this.getItems().add(new MenuItemSon(m));
		//this.getItems().add(new MenuItemCouleur(m));
		this.getItems().add(new SeparatorMenuItem());
		this.getItems().add(new MenuItemQuitter());

	}
}
