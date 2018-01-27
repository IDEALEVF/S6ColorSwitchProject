package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import main.model.ColorSelected;

public class CroixG extends Obstacles{

	CroixG(int posX, int posY, int speed) {
		super(posX, posY, speed);

		int size1 = 10;
		int size2 = 150;
		int border=10;
		int size3=2*size2-size1;

		this.forme = new Group();

		Line ligneDroite=new Line(size2,size2,size3,size2);
		ligneDroite.setFill(ColorSelected.BLUE);
		ligneDroite.setStroke(ColorSelected.BLUE);
		ligneDroite.setStrokeWidth(border);

		Line ligneGauche=new Line(size1,size2,size2,size2);
		ligneGauche.setFill(Color.YELLOW);
		ligneGauche.setStroke(Color.YELLOW);
		ligneGauche.setStrokeWidth(border);

		Line ligneBas=new Line(size2,size2,size2,size3);
		ligneBas.setFill(ColorSelected.PURPLE);
		ligneBas.setStroke(ColorSelected.PURPLE);
		ligneBas.setStrokeWidth(border);

		Line ligneHaut=new Line(size2,size1,size2,size2);
		ligneHaut.setFill(ColorSelected.ROSE);
		ligneHaut.setStroke(ColorSelected.ROSE);
		ligneHaut.setStrokeWidth(border);

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
		rotation += 8;
		forme.setRotate(rotation);
	}

}
