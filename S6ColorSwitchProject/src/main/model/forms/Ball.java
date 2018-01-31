package main.model.forms;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class Ball extends Form {
	private double gravite = 0.5;
	private double V;
	private double maxV=8;
	private boolean tomber=true;
	private boolean saut;

	Ball(int posX, int posY, int speed) {
		super(posX, posY, speed);
		this.forme = new Group();
		Circle c1 = new Circle(20,20,10);
		//c1.setStroke();
		c1.setFill(YELLOW);
		c1.setStrokeWidth(1);
		forme.getChildren().add(c1);
	}

	@Override
	public void deplacer() {
		// TODO Auto-generated method stub
		
	}
	public void tombe(){
		if(tomber){
			V+=gravite;
			if (V>maxV) V=maxV;
		}
	}
	public void sauter(double Hsaut){
	if(saut){
		V-=Hsaut;
	}
	}
}
