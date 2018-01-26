package main.model.forms;

/**
 * Une fabrique a formes qui suit la logique du Design Pattern Factory
 * */
public class FormsFactory {
	
	public static Form build(String forme, int x, int y, int width, int height, int vitesse, int rotate) {
		String acomparer = forme.toUpperCase();
		if(acomparer.equals("ROUND1")){
			return new Round1(x , y, width, height, vitesse, rotate);//ROUND1
		}else if(acomparer.equals("ROUND2")) {
			return new Round2(x , y, width, height, vitesse, rotate);//ROUND2
		}else if(acomparer.equals("CARRE")) {
			return new Carre(x, y, vitesse);//CARRE
		}else {
			return null;//DEFAULT
		}
	}

	@Override
	public String toString() {
		return "FormsFactory []";
	}
	
}
