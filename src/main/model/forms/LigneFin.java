package main.model.forms;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.model.Level;

/**
 * Classe pour modeliser un cercle quadricolore.
 * Le pattern est : tourne vers la droite
 * */
class LigneFin extends Bonus{

	final File file=new File("src/ressources/victory.wav");
	final  Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);
	LigneFin(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		mediaPlayer.setOnRepeat(null);

		int TAILLE = 4;

		for(int i=0; i<width/TAILLE; i++) {//fait i lignes de largeur TAILLE
			Rectangle r1 = new Rectangle();
			Rectangle r2 = new Rectangle();

			r1.setWidth(TAILLE);
			r1.setHeight(TAILLE);
			r2.setWidth(TAILLE);
			r2.setHeight(TAILLE);

			r1.setFill(WHITE);
			r2.setFill(WHITE);

			if(i%2 == 0){//fait des lignes decalees selon la parite de i
				r1.setTranslateX(i*TAILLE);

				r2.setTranslateX(i*TAILLE);
				r2.setTranslateY(2*TAILLE);
			}else {
				r1.setTranslateX(i*TAILLE);
				r1.setTranslateY(TAILLE);

				r2.setTranslateX(i*TAILLE);
				r2.setTranslateY(3*TAILLE);
			}
			forme.getChildren().addAll(r1, r2);
		}

        forme.setRotate(rotate);
	}

	@Override
	public void deplacer() {
		//ne se deplace pas
	}

	@Override
	public String toString() {
		return "LigneFin [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed="
				+ speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}

	@Override
	public boolean doCollision(Level level) {
		level.gagne();
		mediaPlayer.seek(Duration.ZERO);
    	mediaPlayer.play();//joue un son
		return false;
	}
}
