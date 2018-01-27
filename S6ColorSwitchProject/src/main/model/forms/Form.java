package main.model.forms;

import javafx.scene.Group;

public abstract class Form extends Thread {
	protected int posX;
	protected int posY;
	protected int speed;
	protected Group forme;

	protected Form(int posX, int posY, int speed){
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
	}

	public abstract void deplacer();

	public Group getForme() {
		return forme;
	}
}
