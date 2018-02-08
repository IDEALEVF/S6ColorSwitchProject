package main.model.forms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ArcType;
import main.model.ColorSelected;

/**
 * Classe pour modeliser un cercle quadricolore.
 * Le pattern est : tourne vers la droite
 * */
public class Ball extends Obstacles{
	private int dirX;
	private int dirY;
	private final int LIMIT;
	private final int AMORTISSEMENT = 2;
	
	Ball(int posX, int posY, int width, int speed) {
		super(posX, posY, speed);
		this.forme = new Group();
		this.dirX = 0;
		this.dirY = 0;
		this.LIMIT = speed;
		
		Circle round = new Circle();
		
        round.setRadius(width);
        round.setFill(ColorSelected.BLUE);
        round.setStroke(ColorSelected.MENU);
        round.setStrokeWidth(2);
        
        forme.getChildren().add(round);
	}

	@Override
	public void deplacer() {
		this.setPosX(this.getPosX() + dirX);//change la position selon le vecteur directeur
		this.setPosY(this.getPosY() + dirY);
		this.getForme().setTranslateX(this.getPosX());//fait la translation
		this.getForme().setTranslateY(this.getPosY());
	}
	
	public void gravityY(boolean gravityY){
		if(gravityY) {
			if(dirY > -LIMIT){
				dirY -= AMORTISSEMENT;
			}
		}else {
			if(dirY < LIMIT){
				dirY += AMORTISSEMENT;
			}
		}
	}

	@Override
	public String toString() {
		return "Ball [dirX=" + dirX + ", dirY=" + dirY + "]";
	}
}
