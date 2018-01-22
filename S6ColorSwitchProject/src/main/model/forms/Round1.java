package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import main.model.ColorSelected;

public class Round1 extends Obstacles{

	Round1(int posX, int posY, int speed) {
		super(posX, posY, speed);
		this.forme = new Group();
		Arc arc = new Arc();
        arc.setRadiusX(20);
        arc.setRadiusY(20);
        arc.setStartAngle(0);
        arc.setLength(89);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(ColorSelected.ROSE);
        arc.setStrokeWidth(5);
        arc.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc2 = new Arc();
        arc2.setRadiusX(20);
        arc2.setRadiusY(20);
        arc2.setStartAngle(90);
        arc2.setLength(89);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(ColorSelected.BLUE);
        arc2.setStrokeWidth(5);
        arc2.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc3 = new Arc();
        arc3.setRadiusX(20);
        arc3.setRadiusY(20);
        arc3.setStartAngle(180);
        arc3.setLength(89);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(ColorSelected.PURPLE);
        arc3.setStrokeWidth(5);
        arc3.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc4 = new Arc();
        arc4.setRadiusX(20);
        arc4.setRadiusY(20);
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
        
        //forme.setLayoutX(posX);
        //forme.setLayoutY(posY);
        //forme.setLayoutX(150);
        //forme.setLayoutY(100);
        
        System.out.println(this);
	}

	@Override
	public void deplacer() {
		if(rotation > 360) {//la rotation reste modulo 360
			rotation -= 360;
		}
		rotation += 8;
		forme.setRotate(rotation);
	}

	@Override
	public String toString() {
		return "Round1 [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
