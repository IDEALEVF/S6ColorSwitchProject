package main.model;

/**
 * Enum pour modeliser le type de partie associee a un niveau.
 * */
public enum Type{
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
	public static Type get(String string){
		String str = string.toUpperCase();//suppression de la casse
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
