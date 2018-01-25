package main.model;

import java.util.Scanner;
import java.util.Vector;

import main.model.forms.Form;
import main.model.forms.FormsFactory;

public class Level {
	private final int TAILLE_ENTETE = 5;
	
	private Score score;
	private Vector<Form> objects;
	private String name;
	private int number;
	private Type type;
	private int points;
	
	public Level() {
		name = "niveau 1";
		score = new Score(6);
		score.add("Bob", 23);
		objects = new Vector<Form>();
		number = 0;
		points = 0;
		type = Type.NORMAL;
	}
	
	/**
	 * Charge un niveau sauvegarde sous forme de fichier texte de chemin
	 * absolu passe en parametres
	 * Le format d'enregistrement doit etre de la forme :
	 * forme x y vitesse
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
		
		for(int i=TAILLE_ENTETE;i<lignes.length;i++) {//pour chaque objet du fichier texte, le cree
			String[] parties = lignes[i].split(" ");//coupe selon les espaces
			Form o = FormsFactory.build(parties[0],
					Integer.parseInt(parties[1]),
					Integer.parseInt(parties[2]),
					Integer.parseInt(parties[3]));
			if(o != null){
				objects.add(o);//cree les objets
			}
		}
		
	}

	public Score getScore() {
		return score;
	}

	/*public void setScore(int score) {
		this.score = score;
	}*/

	public Vector<Form> getObjects() {
		return objects;
	}
	
	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public int getPoints() {
		return points;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Level [points=" + points + ", score=" + score + ", objects=" + objects + ", name=" + name + ", number=" + number + ", type="
				+ type + "]";
	}
}
