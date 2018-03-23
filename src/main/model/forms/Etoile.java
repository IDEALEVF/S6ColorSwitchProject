package main.model.forms;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;
import javafx.util.Duration;
import main.model.Level;

/**
 * Les etoiles qui font des points.
 * @author CALVO FERNANDEZ Adélie
 * @version 1.0
 * */
class Etoile extends Bonus{

	final File file=new File("src/ressources/star.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);


	public Etoile(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		mediaPlayer.setOnRepeat(null);
		/*Polygon etoile = new Polygon();
		etoile.getPoints().addAll(100d,100d,200d,50d,400d,100d,200d,150d);
		etoile.setFill(BLUE);
		etoile.setStrokeWidth(3);
		etoile.setStroke(BLACK);*/
		//int posX=-50;
        //int posY=-50;
        double s1X =  0;

        double s1Y = -28;

        double s2X = 18;

        double s2Y = 25;

        //Line l1=new Line(s1X, s1Y, s2X, s2Y);

        double s3X = -25;

        double s3Y = -8;

        //Line l2=new Line(s2X, s2Y, s3X, s3Y);

        double s4X = 25;

        double s4Y = -8;

        //Line l3=new Line(s3X, s3Y, s4X, s4Y);

        double s5X = -18;

        double s5Y = 25;

        //Line l4=new Line(s4X, s4Y, s5X, s5Y);

        //Line l5=new Line(s5X, s5Y, s1X, s1Y);
        Polygon etoile = new Polygon();
		etoile.getPoints().addAll(s1X,s1Y,s2X,s2Y,s3X,s3Y,s4X,s4Y,s5X,s5Y);
		etoile.setFill(WHITE);
		etoile.setStrokeWidth(3);
		etoile.setStrokeLineJoin(StrokeLineJoin.ROUND);
		etoile.setStroke(WHITE);

//		etoile.setLayoutX(-25);
//		etoile.setLayoutY(-25);
		etoile.setScaleX((double)width/25);
		etoile.setScaleY((double)height/25);

		ajouterForme(etoile);
	}

	@Override
	public void deplacer() {
		if(rotation > 360 ) {//la rotation reste modulo 360
			rotation -= 360;
		}else if(rotation<-360){
			rotation += 360;
		}
		rotation += 8;
		forme.setRotate(rotation);
	}

	@Override
	public String toString() {
		return "Etoile [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed="
				+ speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}
	/**
	 * Fonction exécutée quand la balle prend l'étoile
	 * @param Level level
	 * @return false car l'étoile ne fait pas perdre
	 * */
	@Override
	public boolean doCollision(Level level) {
		System.out.println("score +1");
		level.addPoints(1);
		level.retirerForme(this);
		mediaPlayer.seek(Duration.ZERO);
    	mediaPlayer.play();//joue un son
		return false;
	}



}
