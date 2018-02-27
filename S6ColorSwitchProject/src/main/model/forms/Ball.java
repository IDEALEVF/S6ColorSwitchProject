package main.model.forms;

import javafx.scene.shape.Circle;
import main.model.ColorSelected;

/**
 * Classe pour modeliser un cercle quadricolore.
 * Le pattern est : tourne vers la droite
 * */
public class Ball extends Obstacles{
	private int dirX;
	private int dirY;
	private final int MAXV;
	private final int AMORTISSEMENT = 2;
	private int latence = 0;//temps de latence avant que la balle ne soit attiree par la gravite
	//private final int LIMITE = 3;
	
	Ball(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		this.dirX = 0;
		this.dirY = 0;
		this.MAXV = speed;
		
		Circle circle = new Circle();
		
        circle.setRadius(width);
        circle.setFill(ColorSelected.YELLOW);
        circle.setStroke(ColorSelected.YELLOW);
        circle.setStrokeWidth(1);
        
        forme.getChildren().add(circle);
	}

	@Override
	public void deplacer() {
		this.setPosX(this.getPosX() + dirX);//change la position selon le vecteur directeur
		this.setPosY(this.getPosY() + dirY);
		this.getForme().setTranslateX(this.getPosX());//fait la translation
		this.getForme().setTranslateY(this.getPosY());
	}
	
	public void gravityY(int gravityY){
		if(latence > 0) {
			latence --;
		}else if(gravityY < 0) {//gravite vers le bas
			if(dirY > -MAXV){
				dirY -= AMORTISSEMENT;
			}
		}else if(gravityY > 0) {//gravite vers le haut
			if(dirY < MAXV){
				dirY += AMORTISSEMENT;
			}
		}else{
			if(dirY > 0){//arret de la gravite
				dirY -= AMORTISSEMENT;
			}else if(dirY < 0){
				dirY += AMORTISSEMENT;
			}
		}
	}
	
	public void maxY() {
		dirY = -(MAXV);
		latence = 3;
	}

	@Override
	public String toString() {
		return "Ball [dirX=" + dirX + ", dirY=" + dirY + ", MAXV=" + MAXV + ", AMORTISSEMENT=" + AMORTISSEMENT
				+ ", posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}
}
