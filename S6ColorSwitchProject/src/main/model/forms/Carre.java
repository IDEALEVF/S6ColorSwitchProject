package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import main.model.ColorSelected;

public class Carre extends Obstacles{

	Carre(int posX, int posY, int speed) {
		super(posX, posY, speed);

		int size1 = 10;
		int size2 = 150;
		int border=10;

		this.forme = new Group();

		Line ligneHaut=new Line(size1,size1,size2,size1);
		ligneHaut.setFill(ColorSelected.BLUE);
		ligneHaut.setStroke(ColorSelected.BLUE);
		ligneHaut.setStrokeWidth(border);

		Line ligneBas=new Line(size1,size2,size2,size2);
		ligneBas.setFill(Color.YELLOW);
		ligneBas.setStroke(Color.YELLOW);
		ligneBas.setStrokeWidth(border);

		Line ligneGauche=new Line(size1,size1,size1,size2);
		ligneGauche.setFill(ColorSelected.PURPLE);
		ligneGauche.setStroke(ColorSelected.PURPLE);
		ligneGauche.setStrokeWidth(border);

		Line ligneDroite=new Line(size2,size1,size2,size2);
		ligneDroite.setFill(ColorSelected.ROSE);
		ligneDroite.setStroke(ColorSelected.ROSE);
		ligneDroite.setStrokeWidth(border);

		//Shape angle1=Shape.union(ligneGauche, ligneHaut);
		//Shape angle2=Shape.union(ligneDroite, ligneBas);
		//Shape carre=Shape.union(angle1, angle2);
		//forme.getChildren().add(carre);

		forme.getChildren().add(ligneHaut);
		forme.getChildren().add(ligneBas);
		forme.getChildren().add(ligneGauche);
		forme.getChildren().add(ligneDroite);
	}

	@Override
	public void deplacer() {
		if(rotation > 360 ) {//la rotation reste modulo 360
			rotation -= 360;
		}else if(rotation<-360){
			rotation += 360;
		}
		rotation -= 8;
		forme.setRotate(rotation);
	}

}
