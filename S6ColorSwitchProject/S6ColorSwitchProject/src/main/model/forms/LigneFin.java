package main.model.forms;

import javafx.scene.shape.Rectangle;
import main.model.ColorSelected;

/**
 * Classe pour modeliser un cercle quadricolore.
 * Le pattern est : tourne vers la droite
 * */
class LigneFin extends Bonus{

	LigneFin(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, speed, rotate);
		
		Rectangle ligne = new Rectangle();
		ligne.setFill(ColorSelected.PURPLE);
		ligne.setHeight(3);
		ligne.setWidth(width);
        
        forme.getChildren().add(ligne);
        
        forme.setRotate(rotate);
	}

	@Override
	public void deplacer() {
		//ne se deplace pas
	}

	@Override
	public String toString() {
		return "LigneFin [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
