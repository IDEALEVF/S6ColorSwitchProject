package main.model.forms;

/**
 * Une fabrique a formes qui suit la logique du Design Pattern Factory
 * */
public class FormsFactory {
	
	public static Form build(String forme, int x, int y, int width, int height, int vitesse, int rotate) {
		String acomparer = forme.toUpperCase();
		switch(acomparer) {
		case "ROUND1":return new Round1(x , y, width, height, vitesse, rotate);//ROUND1
		case "ROUND2" :return new Round2(x , y, width, height, vitesse, rotate);//ROUND2
		case "CARRE" :return new Carre(x, y, vitesse, rotate);//CARRE
		case "BALL" :return new Ball(x, y, width, vitesse, rotate);//BALL
		case "CROIXG" :return new CroixG(x, y, vitesse, rotate);//CROIXG
		case "CROIXD" :return new CroixD(x, y, vitesse, rotate);//CROIXD
		case "CHANGECOLOR" :return new ChangeColor(x, y, vitesse, rotate);//CHANGECOLOR
		case "ETOILE" :return new Etoile(x, y, vitesse, rotate);//ETOILE
		case "POINT" :return new Point(x, y, vitesse, rotate);//POINT
		case "OBSTACLEROUND1" :return new ObstacleRound1(x , y, width, height, vitesse, rotate);//OBSTACLEROUND1
		case "LIGNEFIN" :return new LigneFin(x , y, width, height, vitesse, rotate);//LIGNE FIN
		case "MESSAGECOLORSWITCH" :return new MessageColorSwitch(x , y, width, height, vitesse, rotate);//MESSAGECOLORSWITCH
		case "DOIGT" :return new Doigt(x , y, width, height, vitesse, rotate);//DOIGT
		default:throw new FormeInexistanteException();
		}
	}

	@Override
	public String toString() {
		return "FormsFactory []";
	}
	
}