package Model;

import java.util.Scanner;
import java.util.Vector;

import Forms.FormsFactory;

public class Level {
	private final int TAILLE_ENTETE = 5;
	
	private int score;
	private Vector<Object> objects;
	private String name;
	private int number;
	private Type type;
	
	enum Type{
		NORMAL,
		INVERSE,
		DEUX_AXES,
		AUTOMATIQUE,
		IA;
		
		/**
		 * Change un String en Type
		 * @param str le type a obtenir
		 * @return le type obtenu
		 * */
		public static Type get(String str){
			str.toUpperCase();//suppression de la casse
			if(str.equals("INVERSE")) {
				return INVERSE;
			}else if(str.equals("DEUX_AXES")) {
				return DEUX_AXES;
			}else if(str.equals("AUTOMATIQUE")) {
				return AUTOMATIQUE;
			}else if(str.equals("IA")) {
				return IA;
			}else{
				return NORMAL;
			}
		}
	}
	
	public Level() {
		name = "niveau 1";
		score = 0;
		objects = new Vector<Object>();
		number = 0;
		type = Type.NORMAL;
	}
	
	/**
	 * Charge un niveau sauvegarde sous forme de fichier texte de chemin
	 * absolu passe en parametres
	 * Le format d'enregistrement doit etre de la forme :
	 * forme x y vitesse
	 * */
	public Level(String path){
		super();
		String[] lignes = Loader.readInTab(path);//lit les informations contenues dans le fichier
		
		if(lignes.length < TAILLE_ENTETE) {//genere une erreur si l'entete est superieure a lignes
			throw new IllegalStateException("Erreur de taille.");
		}
		
		name = lignes[1];//recupere le nom du niveau
		number = Integer.parseInt(lignes[2]);//recupere le numero du niveau
		type = Type.get(lignes[3]);//recupere le type de niveau
		
		for(int i=TAILLE_ENTETE;i<lignes.length;i++) {//pour chaque objet du fichier texte, le cree
			Scanner sc = new Scanner(lignes[i]);
			sc.useDelimiter(" ");//coupe selon les espaces
			objects.add(FormsFactory.build(sc.next(),
					Integer.parseInt(sc.next()),
					Integer.parseInt(sc.next()),
					Integer.parseInt(sc.next())));//cree les objets
		}
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Vector<Object> getObjects() {
		return objects;
	}
	
	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Level [score=" + score + ", objects=" + objects + ", name=" + name + ", number=" + number + ", type="
				+ type + "]";
	}
	
	
	
}
