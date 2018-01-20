package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Carre  extends Obstacles{

	Carre(int posX, int posY, int speed) {
		super(posX, posY, speed);
		this.forme = new Group();

		Line ligneHaut=new Line(10.0,10.0,210.0,10.0);
		ligneHaut.setFill(Color.BLUE);
		ligneHaut.setStroke(Color.BLUE);
		ligneHaut.setStrokeWidth(5);

		Line ligneBas=new Line(10.0,210.0,210.0,210.0);
		ligneBas.setFill(Color.YELLOW);
		ligneBas.setStroke(Color.YELLOW);
		ligneBas.setStrokeWidth(5);

		Line ligneGauche=new Line(10.0,10.0,10.0,210.0);
		ligneGauche.setFill(Color.GREEN);
		ligneGauche.setStroke(Color.GREEN);
		ligneGauche.setStrokeWidth(5);

		Line ligneDroite=new Line(210.0,10.0,210.0,210.0);
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
		int val = 0;
		while(true) {
			forme.setRotate(val);
			val += 20;

		}

	}



}
