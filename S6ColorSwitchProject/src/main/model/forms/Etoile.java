package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class Etoile extends Obstacles{

	public Etoile(int posX, int posY, int speed, int rotate) {
		super(posX, posY, speed, rotate);

		/*Polygon etoile = new Polygon();
		etoile.getPoints().addAll(100d,100d,200d,50d,400d,100d,200d,150d);
		etoile.setFill(BLUE);
		etoile.setStrokeWidth(3);
		etoile.setStroke(BLACK);*/
		//int posX=-50;
        //int posY=-50;
        double s1X =  25;

        double s1Y = 0;

        double s2X = 43;

        double s2Y = 50;

        Line l1=new Line(s1X, s1Y, s2X, s2Y);

        double s3X = 0;

        double s3Y = 17;

        Line l2=new Line(s2X, s2Y, s3X, s3Y);

        double s4X = 50;

        double s4Y = 17;

        Line l3=new Line(s3X, s3Y, s4X, s4Y);

        double s5X = 7;

        double s5Y = 50;

        Line l4=new Line(s4X, s4Y, s5X, s5Y);

        Line l5=new Line(s5X, s5Y, s1X, s1Y);
        Polygon etoile = new Polygon();
		etoile.getPoints().addAll(s1X,s1Y,s2X,s2Y,s3X,s3Y,s4X,s4Y,s5X,s5Y);
		etoile.setFill(Color.GREY);
		etoile.setStrokeWidth(3);
		etoile.setStrokeLineJoin(StrokeLineJoin.ROUND);
		etoile.setStroke(Color.GREY);
		//etoile.setStrokeLineCap(StrokeLineCap.ROUND);
      /*  Shape angle1=Shape.union(l1, l2);
		Shape angle2=Shape.union(l3, l4);
		Shape angle3=Shape.union(angle1, angle2);
		Shape etoile=Shape.union(angle3, l5);
		etoile.setFill(PURPLE);
		forme.getChildren().add(etoile);
        Group g =new Group();
		g.getChildren().add(l1);
		g.getChildren().add(l2);
		g.getChildren().add(l3);
		g.getChildren().add(l4);
		g.getChildren().add(l5);*/
		forme.getChildren().add(etoile);
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
