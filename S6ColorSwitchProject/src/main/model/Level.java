package main.model;

import java.util.Vector;

import main.model.forms.Ball;
import main.model.forms.Form;
import main.model.forms.FormsFactory;

/**
 * Classe qui se prend en charge tout les objets et parametres d'un niveau :
 * balle, obstacles, nom, points, scores, gravite ...
 * @version 1.0
 * @author PITROU Adrien
 * @since 31/01/2018
 * */
public class Level {
	private final int TAILLE_ENTETE = 6;
	private Score score;
	private Vector<Form> objects;
	private Ball ball;
	private String name;
	private int number;
	private Type type;
	private int points;
	private int gravityX;
	private int gravityY;
	
	/**
	 * Constructeur par defaut
	 * */
	public Level() {
		name = "niveau 1";
		score = new Score(6);
		ball = null;
		score.add("Bob", 23);
		score.add("Adrien", 230);
		score.add("Anne", 140);
		objects = new Vector<Form>();
		number = 0;
		points = 0;
		gravityX = 0;//pas de gravite
		gravityY = 0;//pas de gravite
		type = Type.NORMAL;
	}
	
	/**
	 * Charge un niveau sauvegarde sous forme de fichier texte de chemin
	 * absolu passe en parametres
	 * Le format d'enregistrement doit etre de la forme :
	 * forme x y width height vitesse rotate
	 * */
	public Level(String path){
		this();
		String[] lignes = Loader.readInTab(path);//lit les informations contenues dans le fichier
		
		if(lignes.length < TAILLE_ENTETE) {//genere une erreur si l'entete est superieure a lignes
			throw new IllegalStateException("Erreur de taille.");
		}
		
		name = lignes[1];//recupere le nom du niveau
		number = Integer.parseInt(lignes[2]);//recupere le numero du niveau
		type = Type.get(lignes[3]);//recupere le type de niveau
		String[] infosBalle = lignes[4].split(" ");//recupere les infos de la balle
		
		ball = (Ball) FormsFactory.build("Ball", Integer.parseInt(infosBalle[0]), 
				Integer.parseInt(infosBalle[1]), Integer.parseInt(infosBalle[2]), 
				0, Integer.parseInt(infosBalle[3]), 0);//creation de la balle
		
		for(int i=TAILLE_ENTETE;i<lignes.length;i++) {//pour chaque objet du fichier texte, le cree
			String[] parties = lignes[i].split(" ");//coupe selon les espaces
			Form o = FormsFactory.build(parties[0],
					Integer.parseInt(parties[1]),
					Integer.parseInt(parties[2]),
					Integer.parseInt(parties[3]),
					Integer.parseInt(parties[4]),
					Integer.parseInt(parties[5]),
					Integer.parseInt(parties[6]));
			if(o != null){
				objects.add(o);//cree les objets
			}
		}//for
	}//Level

	/**
	 * Retourne le score
	 * @return score
	 * */
	public Score getScore() {
		return score;
	}

	/*public void setScore(int score) {
		this.score = score;
	}*/
	
	/**
	 * Fait que la balle soit attiree en bas
	 * */
	public void gravityDown() {
		this.gravityY = -1;
	}
	
	/**
	 * Fait que la balle arrete d'etre attiree en x
	 * */
	public void gravityXStop() {
		this.gravityX = 0;
	}
	
	/**
	 * Fait que la balle soit attiree a gauche
	 * */
	public void gravityYStop() {
		this.gravityY = 0;
	}
	
	/**
	 * Fait que la balle soit attiree en haut
	 * */
	public void gravityUp() {
		this.gravityY = 1;
	}
	
	/**
	 * Fait que la balle soit attiree a gauche
	 * */
	public void gravityLeft() {
		this.gravityX = -1;
	}
	
	/**
	 * Fait que la balle soit attiree a droite
	 * */
	public void gravityRight() {
		this.gravityX = 1;
	}
	
	/**
	 * Renvoie le sens de gravitation sur l'axe des X
	 * @return gravityX
	 * */
	public int gravityX() {
		return gravityX;
	}
	
	/**
	 * Renvoie le sens de gravitation sur l'axe des X
	 * @return gravityX
	 * */
	public int gravityY() {
		return gravityY;
	}

	/**
	 * Retourne les obstacles du niveau sous forme de Vector<Form>
	 * @return objects
	 * */
	public Vector<Form> getObjects() {
		return objects;
	}
	
	/**
	 * Retourne la balle
	 * @return ball
	 * */
	public Ball getBall() {
		return ball;
	}

	/**
	 * Retourne le nom du niveau
	 * @return name
	 * */
	public String getName() {
		return name;
	}

	/**
	 * Retourne le numero du niveau
	 * @return number
	 * */
	public int getNumber() {
		return number;
	}

	/**
	 * Retourne le nombre de points marques
	 * @return points
	 * */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Retourne le Type de partie jouee
	 * @return type
	 * */
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Level [points=" + points + ", score=" + score + ", objects=" + objects + ", name=" + name + ", number=" + number + ", type="
				+ type + "]";
	}
}
