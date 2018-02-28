package main.model.forms;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
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
	private Circle circle;
	private Color couleur;
	
	Ball(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		this.dirX = 0;
		this.dirY = 0;
		this.MAXV = speed;
		
		circle = new Circle();
		
        circle.setRadius(width);
        circle.setFill(ColorSelected.YELLOW);
        circle.setStroke(ColorSelected.YELLOW);
        circle.setStrokeWidth(1);
        this.setCouleur(ColorSelected.YELLOW);
        forme.getChildren().add(circle);
	}

	@Override
	public void deplacer() {
		this.setPosX(this.getPosX() + dirX);//change la position selon le vecteur directeur
		this.setPosY(this.getPosY() + dirY);
		this.getForme().setTranslateX(this.getPosX());//fait la translation
		this.getForme().setTranslateY(this.getPosY());
	}
	
	public void exploser(Explosion e){
		//final Rectangle rectangle2 = new Rectangle(this.getTranslateX(), this.getTranslateY(), 150, 100);
        //root.getChildren().add(rectangle2);
		//this.circle.setVisible(false);
		//e.seDeplacer(this);
		//for(Node n:e.getRec()){
		final KeyFrame kf2 = new KeyFrame(Duration.ZERO, new KeyValue(this.circle.translateXProperty(), 0));
        final KeyFrame kf12 = new KeyFrame(Duration.seconds(2), new KeyValue(this.circle.translateXProperty(), 50));
        final Timeline timeline2 = new Timeline(kf2, kf12);
        timeline2.playFromStart();
		//}
        //timeline2.setCycleCount(Timeline.INDEFINITE);
        System.out.println("exploser");
        //timeline2.setAutoReverse(true);
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
	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
		circle.setFill(couleur);
	}

	@Override
	public String toString() {
		return "Ball [dirX=" + dirX + ", dirY=" + dirY + ", MAXV=" + MAXV + ", AMORTISSEMENT=" + AMORTISSEMENT
				+ ", posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}
}
