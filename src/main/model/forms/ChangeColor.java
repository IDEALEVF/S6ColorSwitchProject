package main.model.forms;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;
import main.model.Level;
import javafx.scene.paint.Color;

/**
 * Le color switch qui modifie la couleur de la balle au contact
 * @author CALVO-FERNANDEZ Adelie
 * @since 22/02/18
 * @version 1.0
 * */
public class ChangeColor extends Bonus{

	final File file=new File("src/ressources/colorswitch.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);

	public ChangeColor(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		mediaPlayer.setOnRepeat(null);
		this.forme = new Group();
		Arc arc = new Arc();
		arc.setFill(ROSE);
        arc.setRadiusX(width);
        arc.setRadiusY(width);
        arc.setStartAngle(0);
        arc.setLength(89);
        arc.setStroke(ROSE);
        //arc.setStrokeWidth(5);
        arc.setType(ArcType.ROUND);//round, open, chord

        Arc arc2 = new Arc();
		arc2.setFill(BLUE);
        arc2.setRadiusX(width);
        arc2.setRadiusY(width);
        arc2.setStartAngle(90);
        arc2.setLength(89);
        arc2.setStroke(BLUE);
       // arc2.setStrokeWidth(5);
        arc2.setType(ArcType.ROUND);//round, open, chord

        Arc arc3 = new Arc();
		arc3.setFill(PURPLE);
        arc3.setRadiusX(width);
        arc3.setRadiusY(width);
        arc3.setStartAngle(180);
        arc3.setLength(89);
        arc3.setStroke(PURPLE);
        //arc3.setStrokeWidth(5);
        arc3.setType(ArcType.ROUND);//round, open, chord

        Arc arc4 = new Arc();
		arc4.setFill(YELLOW);
        arc4.setRadiusX(width);
        arc4.setRadiusY(width);
        arc4.setStartAngle(270);
        arc4.setLength(89);
        arc4.setStroke(YELLOW);
        //arc4.setStrokeWidth(5);
        arc4.setType(ArcType.ROUND);//round, open, chord

        ajouterForme(arc);
        ajouterForme(arc2);
        ajouterForme(arc3);
        ajouterForme(arc4);
	}

	@Override
	public void deplacer() {
		//ne bouge pas
	}

	@Override
	public String toString() {
		return "ChangeColor [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed="
				+ speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}

	/**
	 * Fonction exécutée quand la balle prend le changecolor
	 * @param Level level
	 * @return false car le change color ne fait pas perdre
	 * */
	@Override
	public boolean doCollision(Level level) {
		System.out.println("change couleur -> couleurs : "+getColorPossible().size());
		ArrayList<Color> couleurPossible = getColorPossible();
		couleurPossible.remove(level.getBall().getCouleur());
		System.out.println("change couleur -> couleurs : "+getColorPossible().size());
		int rand = (int) Math.round(Math.random()*(couleurPossible.size()-1));
		System.out.println("1 : "+rand);
		Color color = getColorPossible().get(rand);
		System.out.println("1");
		//Color color = ColorSelected.couleuralea();
		level.getBall().setCouleur(color);
		level.retirerForme(this);
		mediaPlayer.seek(Duration.ZERO);
    	mediaPlayer.play();//joue un son
		return false;
	}

}
