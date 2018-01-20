package Forms;

public class FormsFactory {
	
	enum Formes{
		ROUND,
		RECTANGLE,
		DEFAULT;
		
		/**
		 * Change un String en Formes
		 * @param str la forme a obtenir
		 * @return la forme obtenue
		 * */
		public static Formes get(String str){
			str.toUpperCase();//suppression de la casse
			if(str.equals("ROUND")) {
				return ROUND;
			}else{
				return DEFAULT;
			}
		}
	}
	
	public static Form build(String forme, int x, int y, int vitesse) {
		switch(Formes.get(forme)) {
		case ROUND:break;//return new Round()
		case RECTANGLE:break;//return new Rectangle()
		default:break;//DEFAULT
		}
		return null;//DEFAULT
	}

	@Override
	public String toString() {
		return "FormsFactory []";
	}
	
}
