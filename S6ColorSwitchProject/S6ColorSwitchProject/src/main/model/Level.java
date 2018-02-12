package main.model;

import java.util.Vector;

import main.model.forms.Ball;
import main.model.forms.Form;
import main.model.forms.FormsFactory;
import main.view.Fenetre;

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
	private Vector<Form> objects;//les obstacles du niveau
	private Ball ball;
	private String name;
	private int number;
	private Type type;
	private int points;
	private int gravityX, gravityY;//sens de gravite
	private Fenetre fenetre;//reference vers la vue
	private int coordinateX, coordinateY;//distance de la balle a l'origine
	
	/**
	 * Constructeur par defaut
	 * */
	public Level() {
		name = "niveau 1";
		score = new Score(6);
		ball = null;
		score.add("Bob", 23);//assuprimer
		score.add("Adrien", 230);
		score.add("Anne", 140);
		objects = new Vector<Form>();
		number = 0;
		points = 0;
		gravityX = 0;//pas de gravite
		gravityY = 0;//pas de gravite
		type = Type.NORMAL;
		setCoordinateX(setCoordinateY(0));
	}
	
	/**
	 * Charge un niveau sauvegarde sous forme de fichier texte de chemin
	 * absolu passe en parametres
	 * Le format d'enregistrement doit etre de la forme :
	 * forme x y width height vitesse rotate
	 * */
	public Level(Fenetre fenetre, String path){
		this();
		assert(fenetre != null);
		assert(path != null);
		
		this.fenetre = fenetre;
		nouvellePartie(path);
	}//Level

	/**
	 * Retourne le score
	 * @return score
	 * */
	public Score getScore() {
		return score;
	}
	
	/**
	 * Nouvelle Partie
	 * @param path le fichier a ouvrir
	 * */
	public void nouvellePartie(String path) {
		assert(path != null);
		
		String[] lignes = Loader.readInTab("src/ressources/niveaux/"+path+".txt");//lit les informations contenues dans le fichier
		objects.clear();//nettoyage des objets precedents
		gravityX = gravityY = 0;//suppression de la gravite
		
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
			if(parties.length < 7) {//si on a une ligne incorrecte, on l' ignore
				continue;
			}
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
	}
	
	/**
	 * Met la vue a jour
	 * */
	public void update() {
		fenetre.nouvellePartie();
	}
	
	/**
	 * Fait que la balle soit attiree en bas
	 * */
	public void gravityDown() {
		this.gravityY = 1;
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
		this.gravityY = -1;
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

	public int getCoordinateY() {
		return coordinateY;
	}

	public int setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
		return coordinateY;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
}
