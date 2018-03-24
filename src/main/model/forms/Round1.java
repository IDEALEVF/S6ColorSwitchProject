package main.model.forms;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 * Classe pour modeliser un cercle quadricolore.
 * Le pattern est : tourne vers la droite
 * */
class Round1 extends Obstacles{

	Round1(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		int WIDTH = 15;
		Arc arc = new Arc();
        arc.setRadiusX(width/2);
        arc.setRadiusY(height/2);
        arc.setStartAngle(0);
        arc.setLength(82);
        arc.setFill(Color.TRANSPARENT);
        //arc.setFill(ROSE);
        arc.setStroke(ROSE);
        arc.setStrokeWidth(WIDTH);
        arc.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc2 = new Arc();
        arc2.setRadiusX(width/2);
        arc2.setRadiusY(height/2);
        arc2.setStartAngle(90);
        arc2.setLength(82);
        arc2.setFill(Color.TRANSPARENT);
        //arc2.setFill(BLUE);
        arc2.setStroke(BLUE);
        arc2.setStrokeWidth(WIDTH);
        arc2.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc3 = new Arc();
        arc3.setRadiusX(width/2);
        arc3.setRadiusY(height/2);
        arc3.setStartAngle(180);
        arc3.setLength(82);
        arc3.setFill(Color.TRANSPARENT);
        //arc3.setFill(PURPLE);
        arc3.setStroke(PURPLE);
        arc3.setStrokeWidth(WIDTH);
        arc3.setType(ArcType.OPEN);//round, open, chord
        
        Arc arc4 = new Arc();
        arc4.setRadiusX(width/2);
        arc4.setRadiusY(height/2);
        arc4.setStartAngle(270);
        arc4.setLength(82);
        arc4.setFill(Color.TRANSPARENT);
        //arc4.setFill(YELLOW);
        arc4.setStroke(YELLOW);
        arc4.setStrokeWidth(WIDTH);
        arc4.setType(ArcType.OPEN);//round, open, chord
        
        forme.getChildren().add(arc);
        forme.getChildren().add(arc2);
        forme.getChildren().add(arc3);
        forme.getChildren().add(arc4);
        
        //forme.setRotate(rotate);
        
        Color[] colorPossible = {BLUE,ROSE,YELLOW,PURPLE};//les couleurs possibles
		addColorPossible(colorPossible);
	}

	@Override
	public void deplacer() {
		tourner();
	}

	@Override
	public String toString() {
		return "Round1 [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed="
				+ speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}

}
