package main.model.forms;

import java.util.Vector;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import main.model.ColorSelected;
import main.model.Level;
import main.model.Pair;
import main.model.Path;

/**
 * La balle du jeu
 * @author BARRECH Mehdi & PITROU Adrien
 * @version 1.0
 * @since 03/03/18
 * */
public class Ball extends Form{
	private double dirX;
	private double dirY;
	private final int MAXV;
	private final int AMORTISSEMENT = 2;
	private int latence = 0;//temps de latence avant que la balle ne soit attiree par la gravite
	//private final int LIMITE = 3;
	//private Circle circle;
	private Color couleur;
	private boolean isAuto = false;
	private Path chemin;
	
	Ball(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		this.dirX = 0;
		this.dirY = 0;
		this.MAXV = speed;
		
		Circle circle = new Circle();
        circle.setRadius(width);
        circle.setFill(ColorSelected.YELLOW);
        //circle.setStroke(ColorSelected.YELLOW);
        //circle.setStrokeWidth(1);
        ajouterForme(circle);
        this.setCouleur(ColorSelected.YELLOW);
        
        Vector<Pair<Integer, Integer>> points = new Vector<Pair<Integer, Integer>>();
        
        chemin = new Path(points);
	}

	@Override
	public void deplacer() {
		if(isAuto) {
			chdir();
		}
		this.setPosX((int) (this.getPosX() + dirX));//change la position selon le vecteur directeur
		this.setPosY((int) (this.getPosY() + dirY));
		this.getForme().setLayoutX(this.getPosX());//fait la translation
		this.getForme().setLayoutY(this.getPosY());
	}

	/**
	 * Fait exploser la balle
	 * @param Explosion e
	 * */
	public void exploser(Explosion e){
		//final Rectangle rectangle2 = new Rectangle(this.getTranslateX(), this.getTranslateY(), 150, 100);
        //root.getChildren().add(rectangle2);
		//this.circle.setVisible(false);
		e.seDeplacer(this);
		//for(Node n:e.getRec()){
		/*final KeyFrame kf2 = new KeyFrame(Duration.ZERO, new KeyValue(this.circle.translateXProperty(), 0));
        final KeyFrame kf12 = new KeyFrame(Duration.seconds(2), new KeyValue(this.circle.translateXProperty(), 50));
        final Timeline timeline2 = new Timeline(kf2, kf12);
        timeline2.playFromStart();*/
		//}
        //timeline2.setCycleCount(Timeline.INDEFINITE);
        System.out.println("exploser");
        //timeline2.setAutoReverse(true);
	}
	
	/**
	 * Fait l'effet de la gravite sur les Y
	 * @param int gravite
	 * */
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
	
	/**
	 * Maximise la valeur en Y
	 * */
	public void maxY() {
		dirY = -(MAXV);
		latence = 3;
	}
	
	/**
	 * Renvoie la couleur actuelle de la balle
	 * */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Met une nouvelle couleur a la balle
	 * @param Color couleur
	 * */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
		//Group n = (Group) forme.getChildren().get(0);
		//forme.getChildren().remove(0);
		Shape s = (Shape) forme.getChildren().get(0);
		s.setFill(couleur);
	}

	@Override
	public String toString() {
		return "Ball [dirX=" + dirX + ", dirY=" + dirY + ", MAXV=" + MAXV + ", AMORTISSEMENT=" + AMORTISSEMENT
				+ ", posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}

	/**
	 * Lance la balle en mode AUTOMATIQUE
	 * */
	public void start() {
		isAuto = true;
	}
	
	private void chdir() {
		Pair<Double, Double> coordonnees = chemin.getNextDir(posX, posY, speed);
		dirX = coordonnees.first();
		dirY = coordonnees.second();
	}

	public void addPoint(int posX, int posY) {
		chemin.addPoint(posX, posY);
	}

	public Vector<Pair<Integer, Integer>> getPoints() {
		return chemin.getPoints();
	}
	
	/**
	 * Repercute le defilement de l'axe des X
	 * @param int defilement
	 * */
	public void repercuterDefilementX(int defilement) {
		Vector<Pair<Integer, Integer>> points = chemin.getPoints();
		for(Pair<Integer, Integer> point : points) {
			point.setFirst(point.first()+defilement);
		}
	}
	
	/**
	 * Repercute le defilement de l'axe des Y
	 * @param int defilement
	 * */
	public void repercuterDefilementY(int defilement) {
		Vector<Pair<Integer, Integer>> points = chemin.getPoints();
		for(Pair<Integer, Integer> point : points) {
			point.setSecond(point.second()+defilement);
		}
	}
	
	/**
	 * Change l'apparence de la balle
	 * @param Node nouvelleForme la nouvelle forme
	 * */
	public void changerApparenceBalle(Shape nouvelleForme) {
//		Group g = (Group)forme.getChildren().get(0);
		forme.getChildren().clear();//supprime l'ancienne apperence
		mettreFormeAJour(nouvelleForme);
	}

	private void mettreFormeAJour(Shape nouvelleForme) {
		nouvelleForme.setFill(couleur);
		//nouvelleForme.setStroke(ColorSelected.couleuralea());
		//nouvelleForme.setStrokeWidth(1);
        ajouterForme(nouvelleForme);
	}

	@Override
	public boolean doCollision(Level level) {
		//ne fait rien
		return false;
	}
}
