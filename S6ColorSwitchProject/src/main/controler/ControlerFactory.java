package main.controler;

import javafx.event.EventHandler;
import javafx.event.EventType;
import main.model.Level;

public class ControlerFactory {
	
	public static final short ECOUTEUR_TOUCHE_ENFONCEE = 1;
	public static final short ECOUTEUR_TOUCHE_RELACHEE = 2;
	
	//<?>
	@SuppressWarnings("unchecked") //le type de retour est correct mais il ne le sait pas.
	public static <T> EventHandler<? super T> build(EventType<? super T> type, Level level, Moteur m) {
		System.out.println(type.getName());
		switch(type.getName()) {
		case "KEY_PRESSED":return (EventHandler<? super T>) new EcouteurToucheEnfoncee(level);
		case "KEY_RELEASED":return (EventHandler<? super T>) new EcouteurToucheRelachee(level);
		case "MOUSE_CLICKED":return (EventHandler<? super T>) new EcouteurSourisSortMenu(m);
		//case "MOUSE_RELEASED":return (EventHandler<? super T>) new ActionVide();
		case "ACTION": return (EventHandler<? super T>) new ActionBouton(m);
		case "WINDOW_SHOWING":return (EventHandler<? super T>) new EcouteurFenetreOuverte(m);
		case "WINDOW_HIDING":return (EventHandler<? super T>) new EcouteurFenetreFermee(m);
		case "DIALOG_SHOWING":return (EventHandler<? super T>) new EcouteurDialogOuvert();
		//case "EVENT_SHOWING":return (EventHandler<? super T>) new EcouteurMenuOuvert(m);
		//case "EVENT_HIDING":return (EventHandler<? super T>) new EcouteurMenuFerme(m);
		case "MOUSE_ENTERED":return (EventHandler<? super T>) new EcouteurSourisSurMenu(m);
		//case "MOUSE_EXITED":return (EventHandler<? super T>) new EcouteurSourisSortMenu(m);
		default: throw new IllegalArgumentException("type incorrect");
		}
	}
}
