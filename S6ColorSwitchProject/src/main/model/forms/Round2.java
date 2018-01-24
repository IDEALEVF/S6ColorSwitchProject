package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import main.model.ColorSelected;

public class Round2 extends Round1{

	Round2(int posX, int posY, int speed) {
		super(posX, posY, speed);
	}

	@Override
	public void deplacer() {
		if(rotation < 0) {//la rotation reste modulo 360
			rotation += 360;
		}
		rotation -= 8;
		forme.setRotate(rotation);
	}

	@Override
	public String toString() {
		return "Round2 [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
