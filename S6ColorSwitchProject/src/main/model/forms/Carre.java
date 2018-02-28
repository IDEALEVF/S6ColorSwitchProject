package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import main.model.ColorSelected;

class Carre extends Obstacles{

	Carre(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		
		int size1 = 10;
		int size2 = 200;
		
		//this.forme = new Group();

		Line ligneHaut=new Line(size1,size1,size2,size1);
		ligneHaut.setFill(ColorSelected.BLUE);
		ligneHaut.setStroke(ColorSelected.BLUE);
		ligneHaut.setStrokeWidth(5);

		Line ligneBas=new Line(size1,size2,size2,size2);
		ligneBas.setFill(ColorSelected.PURPLE);
		ligneBas.setStroke(ColorSelected.PURPLE);
		ligneBas.setStrokeWidth(5);

		Line ligneGauche=new Line(size1,size1,size1,size2);
		ligneGauche.setFill(ColorSelected.ROSE);
		ligneGauche.setStroke(ColorSelected.ROSE);
		ligneGauche.setStrokeWidth(5);

		Line ligneDroite=new Line(size2,size1,size2,size2);
		ligneDroite.setFill(ColorSelected.YELLOW);
		ligneDroite.setStroke(ColorSelected.YELLOW);
		ligneDroite.setStrokeWidth(5);

		Shape angle1=Shape.union(ligneGauche, ligneHaut);
		Shape angle2=Shape.union(ligneDroite, ligneBas);
		Shape carre=Shape.union(angle1, angle2);
		//forme.getChildren().add(carre);
		

		forme.getChildren().add(ligneHaut);
		forme.getChildren().add(ligneBas);
		forme.getChildren().add(ligneGauche);
		forme.getChildren().add(ligneDroite);
	}

	@Override
	public void deplacer() {
		if(rotation > 360) {//la rotation reste modulo 360
			rotation -= 360;
		}
		rotation += 2;
		forme.setRotate(rotation);
	}

	@Override
	public String toString() {
		return "Carre [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}

}
