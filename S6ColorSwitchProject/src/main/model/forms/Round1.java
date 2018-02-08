package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import main.model.ColorSelected;

/**
 * Classe pour modeliser un cercle quadricolore.
 * Le pattern est : tourne vers la droite
 * */
public class Round1 extends Obstacles{

	Round1(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, speed);
		this.forme = new Group();
		System.out.println("rotate"+rotate);
		this.rotation = rotate;
		Arc arc = new Arc();
        arc.setRadiusX(width);
        arc.setRadiusY(height);
        arc.setStartAngle(0);
        arc.setLength(89);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(ColorSelected.ROSE);
        arc.setStrokeWidth(5);
        arc.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc2 = new Arc();
        arc2.setRadiusX(width);
        arc2.setRadiusY(height);
        arc2.setStartAngle(90);
        arc2.setLength(89);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(ColorSelected.BLUE);
        arc2.setStrokeWidth(5);
        arc2.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc3 = new Arc();
        arc3.setRadiusX(width);
        arc3.setRadiusY(height);
        arc3.setStartAngle(180);
        arc3.setLength(89);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(ColorSelected.PURPLE);
        arc3.setStrokeWidth(5);
        arc3.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc4 = new Arc();
        arc4.setRadiusX(width);
        arc4.setRadiusY(height);
        arc4.setStartAngle(270);
        arc4.setLength(89);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(ColorSelected.YELLOW);
        arc4.setStrokeWidth(5);
        arc4.setType(ArcType.OPEN);//round, open, chord
        
        forme.getChildren().add(arc);
        forme.getChildren().add(arc2);
        forme.getChildren().add(arc3);
        forme.getChildren().add(arc4);
        
        forme.setRotate(rotate);
	}

	@Override
	public void deplacer() {
		if(rotation > 360) {//la rotation reste modulo 360
			rotation -= 360;
		}
		rotation += speed;
		forme.setRotate(rotation);
	}

	@Override
	public String toString() {
		return "Round1 [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
