package main.model.forms;

import javafx.scene.Group;

public class ObstacleCarre1 extends Carre{

	ObstacleCarre1(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		
		Form etoile = FormsFactory.build("Etoile", posX, posY, 20, 20, 1, 0);
		ajouterForme(etoile.getForme());
	}

	@Override
	public void deplacer() {
		super.deplacer();
	}

	
}
