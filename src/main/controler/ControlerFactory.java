package main.controler;

import javafx.event.EventHandler;
import javafx.event.EventType;
import main.model.Level;

public class ControlerFactory {

	@SuppressWarnings("unchecked") //le type de retour est correct mais il ne le sait pas.
	public static <T> EventHandler<? super T> build(EventType<? super T> type, Level level, Moteur m, Object src) {
		
		switch(type.getName()) {

		case "KEY_TYPED":return (EventHandler<? super T>) new EcouteurToucheClique(level);
		case "KEY_PRESSED":return (EventHandler<? super T>) new EcouteurToucheEnfoncee(level);
		case "MOUSE_CLICKED":return (EventHandler<? super T>) new EcouteurSourisSortMenu(m, level,src);
		case "MOUSE_RELEASED":return (EventHandler<? super T>) new ActionNouvellePartie(level,src);
		case "ACTION": return (EventHandler<? super T>) new ActionBouton(m, level);
		case "MOUSE_ENTERED":return (EventHandler<? super T>) new EcouteurSourisSurMenu(m);
		case "WINDOWS_":return (EventHandler<? super T>) new EcouteurSourisSurMenu(m);
		default: throw new IllegalArgumentException("type incorrect");
		}
	}

	public static <T> EventHandler<? super T> build(EventType<? super T> type, Level level) {
		return build(type, level, null,null);
	}

	public static <T> EventHandler<? super T> build(EventType<? super T> type, Moteur m) {
		return build(type, null, m,null);
	}
}
