package main.model.forms;

import javafx.scene.Group;
import main.model.ColorSelected;

/**
 * Classe abstraite qui represente un des objets manipule par le jeu
 * Color Switch. La classe encapsule un champ forme qui correspond a l'apparence
 * de la forme sur une scene java FX et les proprietes de l'objet.
 * Elle definit aussi des services generiques aux formes.
 * @author PITROU Adrien
 * @since 20/01/2018
 * @version 1.0
 * */
public abstract class Form implements ColorSelected{
	protected int posX;
	protected int posY;
	protected int speed;
	protected Group forme;
	protected int rotation;
	
	Form(int posX, int posY, int speed){
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.rotation = 0;
	}
	
	public abstract void deplacer();
	
	public Group getForme() {
		return forme;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Form [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
