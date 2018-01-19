package main.model.forms;

/**
 * Une fabrique a formes qui suit la logique du Design Pattern Factory
 * */
public class FormsFactory {
	
	public static Form build(String forme, int x, int y, int vitesse) {
		switch(Formes.get(forme)) {
		case ROUND1:System.out.println("ici");return new Round1(x , y, vitesse);//ROUND 1
		case RECTANGLE:break;//return new System.out.println("ici");
		default:break;//DEFAULT
		}
		return null;//DEFAULT
	}

	@Override
	public String toString() {
		return "FormsFactory []";
	}
	
}
