package main.model;

import java.util.ArrayList;
import java.util.Vector;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import main.model.forms.Ball;
import main.model.forms.Form;
import main.model.forms.Road;
/**
 * Collision
 * @author CALVO FERNANDEZ Adélie
 * @version 1.0
 * */
public class Collision {
	//;
	//private ;
	private Level l;

	public Level getL() {
		return l;
	}

	public Collision( Level l) {
		//balle=b;
		//formes=f;
		this.l= l;
	}

	/**
	 * Fonction pour tester l'intersection et les couleurs entre la balle et les formes
	 * @param ArrayList<Shape> listeShape
	 * @param Shape bal1
	 * @return boolean
	 * */
	public boolean inter(ArrayList<Shape> listeShape, Shape bal1){
		//pour chaque parties de la forme
		for(Shape sh:listeShape){
			//si collision on vérifie la couleur
			if(Shape.intersect(bal1, sh).getBoundsInLocal().getHeight()!=-1 && Shape.intersect(bal1, sh).getBoundsInLocal().getWidth()!=-1){
				if(sh.getFill() == Color.TRANSPARENT) {//test sur les bordures
					//pas la meme couleur
					if(bal1.getFill()!=sh.getStroke()){
						//System.out.println("collision couleur bordure : "+bal1.getFill()+" "+sh+" "+sh.getFill());
						return true;
					}
				}else {
					//pas la meme couleur
					if(bal1.getFill()!=sh.getFill()){
						//System.out.println("collision couleur : "+bal1.getFill()+" "+sh+" "+sh.getFill());
						return true;
					}
				}

			}
			//pas collision
			else{

			}
		}
		return false;
	}


	/**
	 * Fonction pour tester les collisions
	 * @return boolean
	 * */
	public boolean isCol(){
		Ball balle = l.getBall();
		//Doigt doi=l.getDoi();
		Vector<Form> formes = l.getObjects();
		ArrayList<Shape> listeShape;
		Shape bal1;

		for (Form it : formes){
			if(it.getClass().equals(Road.class)) {//ignore le road pour le mode AUTOMATIQUE
				continue;
			}
			if(balle.isBoundsIntersect(it)) {//general -> test sur les bounds
				//on récupère les shapes de it
				listeShape=it.getShape();
				bal1=balle.getShape().get(0);
				if(inter(listeShape,bal1)){//teste la shape
					return it.doCollision(l);
				}
			}
		}

		return false;

	}

}
