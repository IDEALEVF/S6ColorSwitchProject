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
			return new Carre(x, y, vitesse, rotate);//CARRE
		}else if(acomparer.equals("BALL")){
			return new Ball(x, y, width, vitesse, rotate);//BALL
		}else if(acomparer.equals("CROIXG")){
			return new CroixG(x, y, vitesse, rotate);//CROIXG
		}else if(acomparer.equals("CROIXD")){
			return new CroixD(x, y, vitesse, rotate);//CROIXD
		}else if(acomparer.equals("CHANGECOLOR")){
			return new ChangeColor(x, y, vitesse, rotate);//CHANGECOLOR
		}else if(acomparer.equals("ETOILE")){
			return new Etoile(x, y, vitesse, rotate);//POINT
		}else if(acomparer.equals("POINT")){
			return new Point(x, y, vitesse, rotate);//POINT
		}else if(acomparer.equals("OBSTACLEROUND1")){
			return new ObstacleRound1(x , y, width, height, vitesse, rotate);//OBSTACLEROUND1
		}else if(acomparer.equals("LIGNEFIN")){
			return new LigneFin(x , y, width, height, vitesse, rotate);//OBSTACLEROUND1
		}else {
			return null;//DEFAULT
		}
	}

	@Override
	public String toString() {
		return "FormsFactory []";
	}
	
}
