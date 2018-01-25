package main.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.view.menubar.ContextualMenu;
import main.view.menubar.ZMenuBar;
import javafx.stage.WindowEvent;
 
/**
 * Classe qui se charge de la vitrine de l'application.
 * @author PITROU Adrien
 * @version 1.0
 * @since 24/01/18
 * */
public class Fenetre extends Application {
	private BorderPane root;
	private final int HAUTEUR_FENETRE = 600;
	private final int LARGEUR_FENETRE = 400;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Place la forme d'indice num du moteur aux coordonnees x et y de cette forme
     * @param components Le panneau dans lequel ajouter la forme
     * @param m le moteur de jeu qui contient l'objet Level et les formes
     * @param num le numero de la forme a ajouter
     * */
    private void placerForme(Pane components, Moteur m, int num) {
    	components.getChildren().add(m.getForm(num));//formeG
        components.getChildren().get(num).setTranslateX(m.getFormX(num));
        components.getChildren().get(num).setTranslateY(m.getFormY(num));
    }
    
    @Override
    public void start(Stage primaryStage) {
    	Background b = new Background(new BackgroundFill(ColorSelected.BLACK,null,null));
    	
    	//parametres de l'objet Stage
    	primaryStage.setTitle("Color Switch L3 group : PITROU BARRECH CALVO-FERNANDEZ");
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {//fermeture
            @Override
            public void handle(final WindowEvent event) {
				System.exit(0);
			}
        });
    	
        //composants
        Pane components = new Pane();//boite contenant les formes du jeu
		components.setBackground(b);//fond

		//Menus
		Moteur m = new Moteur(this);
        ZMenuBar menuBar = new ZMenuBar(root, m);//la barre de menu
        ContextualMenu cm = new ContextualMenu(m);
        components.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
        	@Override public void handle(MouseEvent e) {
        	if (e.getButton() == MouseButton.SECONDARY)
        	cm.show(components, e.getScreenX(), e.getScreenY());
        	}
        });
        
		//placement des formes
        for(int i=0;i<m.getFormNumber();i++) {//place les formes
        	 placerForme(components, m, i);
        }
        
        //objet root
        root = new BorderPane();
        root.setCenter(components);
        root.setTop(menuBar);//Barre de Menu
        primaryStage.setScene(new Scene(root, LARGEUR_FENETRE, HAUTEUR_FENETRE));
        root.setPrefSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        
        //primaryStage.setResizable(false);
        primaryStage.show();
        
        //synchronise sinon le show() lance un nouveau thread et le moteur n'a pas 
        //le temps de charger le jeu que la fenetre se raffraichit deja
        synchronized(Thread.currentThread()){
        	m.start();
        }
    }
    
}



