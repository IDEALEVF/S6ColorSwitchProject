package main.model.forms;

import javafx.scene.Group;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import main.model.ColorSelected;

class ChangeColor extends Bonus{

	public ChangeColor(int posX, int posY, int speed, int rotate) {
		super(posX, posY, speed, rotate);
		this.forme = new Group();
		Arc arc = new Arc();
		arc.setFill(ColorSelected.ROSE);
        arc.setRadiusX(20);
        arc.setRadiusY(20);
        arc.setStartAngle(0);
        arc.setLength(89);
        arc.setStroke(ColorSelected.ROSE);
        //arc.setStrokeWidth(5);
        arc.setType(ArcType.ROUND);//round, open, chord

        Arc arc2 = new Arc();
		arc2.setFill(ColorSelected.BLUE);
        arc2.setRadiusX(20);
        arc2.setRadiusY(20);
        arc2.setStartAngle(90);
        arc2.setLength(89);
        arc2.setStroke(ColorSelected.BLUE);
       // arc2.setStrokeWidth(5);
        arc2.setType(ArcType.ROUND);//round, open, chord

        Arc arc3 = new Arc();
		arc3.setFill(ColorSelected.PURPLE);
        arc3.setRadiusX(20);
        arc3.setRadiusY(20);
        arc3.setStartAngle(180);
        arc3.setLength(89);
        arc3.setStroke(ColorSelected.PURPLE);
        //arc3.setStrokeWidth(5);
        arc3.setType(ArcType.ROUND);//round, open, chord

        Arc arc4 = new Arc();
		arc4.setFill(ColorSelected.YELLOW);
        arc4.setRadiusX(20);
        arc4.setRadiusY(20);
        arc4.setStartAngle(270);
        arc4.setLength(89);
        arc4.setStroke(ColorSelected.YELLOW);
        //arc4.setStrokeWidth(5);
        arc4.setType(ArcType.ROUND);//round, open, chord

        forme.getChildren().add(arc);
        forme.getChildren().add(arc2);
        forme.getChildren().add(arc3);
        forme.getChildren().add(arc4);
	}

	@Override
	public void deplacer() {
		//ne bouge pas
	}

}
