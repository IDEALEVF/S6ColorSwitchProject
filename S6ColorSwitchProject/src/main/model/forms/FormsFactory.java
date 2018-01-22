package main.model.forms;

/**
 * Une fabrique a formes qui suit la logique du Design Pattern Factory
 * */
public class FormsFactory {

	public static Form build(String forme, int x, int y, int vitesse) {
		String acomparer = forme.toUpperCase();
		if(acomparer.equals("ROUND1")){
			return new Round1(x , y, vitesse);//ROUND 1
		}else if(acomparer.equals("CARRE")) {
			return new Carre(x, y, vitesse);//return new System.out.println("ici");
		}else if(acomparer.equals("CROIXG")) {
			return new CroixG(x, y, vitesse);//return new System.out.println("ici");
		}else {
			return null;//DEFAULT
		}
	}

	@Override
	public String toString() {
		return "FormsFactory []";
	}

}
