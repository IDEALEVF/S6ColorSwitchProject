package main.model.forms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Paint;

class CarreDeRonds extends Obstacles{
	private Set<Node> parties;

	public CarreDeRonds(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		this.width = width;
		this.height = height;
		
		final short NBRE_BOULES = 16;
		final int TAILLE = width / 12; //le rayon des cercles
		parties = new HashSet<Node>();
		
		for(int i=0;i<NBRE_BOULES/4;i++) {//place les boules du haut
			Node n = creerCercle(BLUE,TAILLE);
			n.setTranslateX(i*(width/4));
		}
		for(int i=0;i<NBRE_BOULES/4;i++) {//place les boules de droite
			Node n = creerCercle(YELLOW,TAILLE);
			n.setTranslateX(width);
			n.setTranslateY(i*(width/4));
		}
		for(int i=0;i<NBRE_BOULES/4;i++) {//place les boules du bas
			Node n = creerCercle(PURPLE,TAILLE);
			n.setTranslateX(width-i*(width/4));
			n.setTranslateY(height);
		}
		for(int i=0;i<NBRE_BOULES/4;i++) {//place les boules de gauche
			Node n = creerCercle(ROSE,TAILLE);
			n.setTranslateY(height-i*(height/4));
		}
	}
	
	private Circle creerCercle(Paint couleur, int radius) {
		Circle cercle = new Circle();
		cercle.setRadius(radius);
		cercle.setFill(couleur);
		
		parties.add(cercle);
		ajouterForme(cercle);
		return cercle;
	}

	@Override
	public void deplacer() {
		Iterator<Node> it = parties.iterator();
		
		while(it.hasNext()) {
			bougerForme(it.next());
		}
	}
	
	private void bougerForme(Node node) {
		double posX = node.getTranslateX();
		double posY = node.getTranslateY();
		
		if(posY <= 0 && posX < width) {//balle en haut mais pas a droite
			node.setTranslateX(node.getTranslateX()+speed);//deplacement a droite
		}else if(posX >= width && posY < height) {//balle a droite mais pas en bas
			node.setTranslateY(node.getTranslateY()+speed);//deplacement a droite
		}else if(posY >= height && posX > 0) {//balle en bas mais pas a gauche
			node.setTranslateX(node.getTranslateX()-speed);//deplacement a gauche
		}else if(posX <= 0 && posY > 0) {//balle a gauche mais pas en haut
			node.setTranslateY(node.getTranslateY()-speed);//deplacement en haut
		}
	}

	@Override
	public String toString() {
		return "CarreDeRonds [parties=" + parties + ", width=" + width + ", height=" + height + ", posX=" + posX
				+ ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}
}
