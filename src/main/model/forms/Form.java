package main.model.forms;

import javafx.scene.shape.*;

public abstract class Form {
	private int posX;
	private int posY;
	private int speed;
	//private Shape forme;
	
	Form(int posX, int posY, int speed){
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
	}
}
