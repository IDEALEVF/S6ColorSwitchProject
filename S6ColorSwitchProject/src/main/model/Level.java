package main.model;

import java.util.Observable;
import java.util.Vector;

import javafx.application.Platform;
import main.model.forms.Ball;
import main.model.forms.Explosion;
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
public class Level{
	private final int TAILLE_ENTETE = 6;
	private Score score;
	private Vector<Form> objects;//les obstacles du niveau
	private Vector<Form> objectsPossible;//les obstacles possibles du niveau
	private Ball ball;
	private String name;
	private int number;
	private Type type;
	private int points;
	private int gravityX, gravityY;//sens de gravite
	private Fenetre fenetre;//reference vers la vue
	private int coordinateX, coordinateY;//distance de la balle a l'origine
	Observable obs = new Observable();
	private boolean perdu;
	private Explosion explo;

	public Explosion getExplo() {
		return explo;
	}

	public void setExplo(Explosion explo) {
		this.explo = explo;
	}
	
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
		objectsPossible = new Vector<Form>();
		number = 0;
		points = 0;
		gravityX = 0;//pas de gravite
		gravityY = 0;//pas de gravite
		type = Type.NORMAL;
		setCoordinateX(setCoordinateY(0));
		perdu = false;
		
	}
	
	/**
	 * Charge un niveau sauvegarde sous forme de fichier texte de chemin
	 * absolu passe en parametres
	 * Le format d'enregistrement doit etre de la forme :
	 * forme x y width height vitesse rotate
	 * */
	public Level(Fenetre fenetre){
		this();
		assert(fenetre != null);
		
		this.fenetre = fenetre;
		obs.addObserver(fenetre);
	}//Level
	
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
		obs.addObserver(fenetre);
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
		fenetre.clearForms();
		objectsPossible.clear();//nettoyage des objets possibles precedents
		gravityX = gravityY = 0;//suppression de la gravite
		perdu = false;
		
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
				objectsPossible.add(o);//cree les objets
			}
		}//for
		repartirObjets();
	}
	
	public boolean isPerdu() {
		return perdu;
	}
	
	public void perdu() {
		System.out.println("perdu");
		perdu = true;
		ball.gravityY(0);
		//ball.setPosY(ball.getPosY()-10);
		gravityYStop();
	}

	/**
	 * Met la vue a jour
	 * */
	public void update() {
		recalculerObjets();
		Platform.runLater(() -> {
			fenetre.placerBalle();
		});
		fenetre.restart();
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
	 * Retourne les obstacles possibles du niveau sous forme de Vector<Form>
	 * @return objects
	 * */
	public Vector<Form> getObjectsPossible() {
		return objectsPossible;
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
		recalculerObjets();
		return coordinateY;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public int setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
		recalculerObjets();
		return coordinateX;
	}
	
	/**
	 * Recalcule les objets qui doivent etre ou non presents dans la fenetres afin
	 * d' alleger les calculs.
	 * */
	private void recalculerObjets(){
		if(type.equals(Type.ENDLESS) && isObjectsEnding()) {//niveau sans fin -> verifie pour ajout de nouvelles formes
			ajouterNouvellesFormes();
		}
		for(Form forme : objects) {
			if(!fenetre.isInComponent(forme)) {
				if(fenetre.isInBounds(forme)) {//si l'objet est dans les limites d'affichage
					System.out.println("ajout fenetre -> "+forme);
					//fenetre.placerForme(forme);
					fenetre.update(obs, forme);
				}
			}else {
				if(!fenetre.isInBounds(forme)) {//si l'objet n'est pas dans les limites d'affichage
					System.out.println("retrait fenetre -> "+forme);
					fenetre.retirerForme(forme);
					//fenetre.update(obs, forme);
				}
			}
		}//for
	}//recalculerObjets
	
	/**
	 * Teste si object est presque vide
	 * */
	private boolean isObjectsEnding() {
		for(Form forme : objects) {
			if(forme.getPosY() < -200) {//faux si il y a des objets non-visibles au dessus
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Choisit de mettre ou non les objets de objectsPossible dans objects
	 * */
	private void repartirObjets() {
		
		if(type.equals(Type.ENDLESS)) {//si on a un niveau sans fin -> place les premiers
			System.out.println("Endless");
			Vector<Form> assuprimer = new Vector<Form>();
			for(Form forme : objectsPossible) {
				if(fenetre.isInBounds(forme)) {//seulement pour les formes visibles au depart
					objects.add(forme);
					assuprimer.add(forme);
				}
			}
			objectsPossible.removeAll(assuprimer);
			System.out.println(objects + "\n---\n"+ objectsPossible);
			if(isObjectsEnding()) {//si objects arrive a la fin, ajoute de nouveaux obstacles
				ajouterNouvellesFormes();
			}
		}else {//autre niveau -> objets places en ordre
			System.out.println("Normal");
			for(Form forme : objectsPossible) {
				objects.add(forme);
			}
		}
	}
	
	/**
	 * Decide quand ajouter une nouvelle forme a l'ensemble des formes
	 * */
	private void ajouterNouvellesFormes() {
		System.out.println("Ajout de nouvelles formes");
		final short NB_FORMES = 3;
		int taillePre = 0;
		
		for(short i=1;i<=NB_FORMES;i++) {
			System.out.println("boucle "+i);
			int alea =  (int) (Math.random() * (objectsPossible.size()));
			Form forme = objectsPossible.get(alea);
			forme.setPosY(forme.getPosY() - taillePre - 60);
			taillePre = forme.getWidth();
			objects.addElement((Form) forme.clone());
		}
	}
}
