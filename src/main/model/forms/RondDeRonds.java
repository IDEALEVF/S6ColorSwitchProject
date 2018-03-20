package main.model.forms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import main.model.ColorSelected;
import javafx.scene.paint.Paint;

class RondDeRonds extends Obstacles{

	private Set<Node> parties;
	private int width;
	private int height;
	private Paint[] colorUsed = {ColorSelected.BLUE, ColorSelected.ROSE, ColorSelected.YELLOW, ColorSelected.PURPLE};


	public RondDeRonds(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		this.width = width;
		this.height = height;

		final short NBRE_BOULES = 16;
		final int TAILLE = width / 12; //le rayon des cercles
		parties = new HashSet<Node>();

		for(double i=0;i<Math.PI/2;i+=Math.PI/(NBRE_BOULES/2)) {//place les boules bleues
			Node n = creerCercle(ColorSelected.BLUE,TAILLE);
			n.setTranslateX((width/2)*Math.cos(i));
			n.setTranslateY((height/2)*Math.sin(i));
		}
		for(double i=Math.PI/2;i<2*Math.PI;i+=Math.PI/(NBRE_BOULES/2)) {//place les boules roses
			Node n = creerCercle(ColorSelected.ROSE,TAILLE);
			n.setTranslateX((width/2)*Math.cos(i));
			n.setTranslateY((height/2)*Math.sin(i));
		}
		for(double i=Math.PI;i<Math.PI+Math.PI/2;i+=Math.PI/(NBRE_BOULES/2)) {//place les boules bleues
			Node n = creerCercle(ColorSelected.YELLOW,TAILLE);
			n.setTranslateX((width/2)*Math.cos(i));
			n.setTranslateY((height/2)*Math.sin(i));
		}
		for(double i=-Math.PI/2;i<0;i+=Math.PI/(NBRE_BOULES/2)) {//place les boules bleues
			Node n = creerCercle(ColorSelected.PURPLE,TAILLE);
			n.setTranslateX((width/2)*Math.cos(i));
			n.setTranslateY((height/2)*Math.sin(i));
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
		tourner();
	}

	@Override
	public String toString() {
		return "RondDeRonds [parties=" + parties + ", width=" + width + ", height=" + height + ", colorUsed="
				+ Arrays.toString(colorUsed) + ", posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme="
				+ forme + ", rotation=" + rotation + "]";
	}

}
