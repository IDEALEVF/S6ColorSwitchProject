package main.model.forms;

import javafx.scene.Group;

public class Point extends Obstacles{

	public Point(int posX, int posY, int speed, int rotate) {
		super(posX, posY, speed, rotate);
		this.forme = new Group();
	}

	@Override
	public void deplacer() {
		if(rotation > 360 ) {//la rotation reste modulo 360
			rotation -= 360;
		}else if(rotation<-360){
			rotation += 360;
		}
		rotation += 15;
		forme.setRotate(rotation);
		
	}

}
