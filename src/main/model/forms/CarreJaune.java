package main.model.forms;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CarreJaune extends Obstacles{

	CarreJaune(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		
		Rectangle carre = new Rectangle();
		carre.setWidth(width);
		carre.setHeight(height);
		carre.setFill(YELLOW);
		
		ajouterForme(carre);
		
		Color[] colorPossible = {YELLOW};//les couleurs possibles
		addColorPossible(colorPossible);
	}

	@Override
	public void deplacer() {
		//ne se deplace pas
	}
}
