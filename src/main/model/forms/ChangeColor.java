package main.model.forms;

import java.io.File;

import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;
import main.model.ColorSelected;
import main.model.Level;

/**
 * Le color switch qui modifie la couleur de la balle au contact
 * @author CALVO-FERNANDEZ Adelie
 * @since 22/02/18
 * @version 1.0
 * */
class ChangeColor extends Bonus{

	final File file=new File("src/ressources/colorswitch.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);

	public ChangeColor(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		mediaPlayer.setOnRepeat(null);
		this.forme = new Group();
		Arc arc = new Arc();
		arc.setFill(ColorSelected.ROSE);
        arc.setRadiusX(width);
        arc.setRadiusY(width);
        arc.setStartAngle(0);
        arc.setLength(89);
        arc.setStroke(ColorSelected.ROSE);
        //arc.setStrokeWidth(5);
        arc.setType(ArcType.ROUND);//round, open, chord

        Arc arc2 = new Arc();
		arc2.setFill(ColorSelected.BLUE);
        arc2.setRadiusX(width);
        arc2.setRadiusY(width);
        arc2.setStartAngle(90);
        arc2.setLength(89);
        arc2.setStroke(ColorSelected.BLUE);
       // arc2.setStrokeWidth(5);
        arc2.setType(ArcType.ROUND);//round, open, chord

        Arc arc3 = new Arc();
		arc3.setFill(ColorSelected.PURPLE);
        arc3.setRadiusX(width);
        arc3.setRadiusY(width);
        arc3.setStartAngle(180);
        arc3.setLength(89);
        arc3.setStroke(ColorSelected.PURPLE);
        //arc3.setStrokeWidth(5);
        arc3.setType(ArcType.ROUND);//round, open, chord

        Arc arc4 = new Arc();
		arc4.setFill(ColorSelected.YELLOW);
        arc4.setRadiusX(width);
        arc4.setRadiusY(width);
        arc4.setStartAngle(270);
        arc4.setLength(89);
        arc4.setStroke(ColorSelected.YELLOW);
        //arc4.setStrokeWidth(5);
        arc4.setType(ArcType.ROUND);//round, open, chord

        forme.getChildren().add(arc);
        forme.getChildren().add(arc2);
        forme.getChildren().add(arc3);
        forme.getChildren().add(arc4);
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
		System.out.println("change couleur");
		level.getBall().setCouleur(ColorSelected.couleuralea());
		level.retirerForme(this);
		mediaPlayer.seek(Duration.ZERO);
    	mediaPlayer.play();//joue un son
		return false;
	}

}
