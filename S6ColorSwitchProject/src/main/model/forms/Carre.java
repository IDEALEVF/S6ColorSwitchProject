package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Carre extends Obstacles{

	Carre(int posX, int posY, int speed, int rotate) {
		super(posX, posY, speed, rotate);
		
		int size1 = 10;
		int size2 = 100;
		
		this.forme = new Group();

		Line ligneHaut=new Line(size1,size1,size2,10.0);
		ligneHaut.setFill(Color.BLUE);
		ligneHaut.setStroke(Color.BLUE);
		ligneHaut.setStrokeWidth(5);

		Line ligneBas=new Line(size1,size2,size2,size2);
		ligneBas.setFill(Color.YELLOW);
		ligneBas.setStroke(Color.YELLOW);
		ligneBas.setStrokeWidth(5);

		Line ligneGauche=new Line(size1,size1,size1,size2);
		ligneGauche.setFill(Color.GREEN);
		ligneGauche.setStroke(Color.GREEN);
		ligneGauche.setStrokeWidth(5);

		Line ligneDroite=new Line(size2,size1,size2,size2);
		ligneDroite.setFill(Color.RED);
		ligneDroite.setStroke(Color.RED);
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

}
