package main.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.model.Level;
import main.model.forms.Form;
import main.model.forms.FormsFactory;
import main.view.menubar.ContextualMenu;
import main.view.menubar.ZMenuBar;
import javafx.stage.WindowEvent;
import javafx.scene.shape.Circle;

/**
 * Classe qui se charge de la vitrine de l'application.
 * @author PITROU Adrien
 * @version 1.0
 * @since 24/01/18
 * */
public class Fenetre extends Application implements Observer{
	private BorderPane root;
	private final int HAUTEUR_FENETRE = 600;
	private final int LARGEUR_FENETRE = 400;
	private Moteur m;
	private Level level;
	private Pane components;
	
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Retourne la hauteur de la fenetre
     * @return HAUTEUR_FENETRE
     * */
    public int getHauteurFenetre() {
    	return HAUTEUR_FENETRE;
    }

    /**
     * Renvoie les composants de la fenetre
     * */
    public Pane getComponents() {
    	return components;
    }
    
    /**
     * Retourne la largeur de la fenetre
     * @return LARGEUR_FENETRE
     * */
    public int getLargeurFenetre() {
    	return LARGEUR_FENETRE;

    }

    public Level getLevel() {
    	return level;
    }

    /**
     * Place la forme d'indice num du moteur aux coordonnees x et y de cette forme
     * @param components Le panneau dans lequel ajouter la forme
     * @param m le moteur de jeu qui contient l'objet Level et les formes
     * @param num le numero de la forme a ajouter
     * */
    /*public void placerForme(int num) {
    	Form forme = level.getObjects().get(num);
    	Node node = forme.getForme();
        node.setTranslateX(forme.getPosX());
        node.setTranslateY(forme.getPosY());
        components.getChildren().add(node);//formeG
    }*/
    
    /**
     * Place la forme d'indice num du moteur aux coordonnees x et y de cette forme
     * @param components Le panneau dans lequel ajouter la forme
     * @param m le moteur de jeu qui contient l'objet Level et les formes
     * @param num le numero de la forme a ajouter
     * */
    public void placerForme(Form forme) {
    	Node node = forme.getForme();
        node.setTranslateX(forme.getPosX());
        node.setTranslateY(forme.getPosY());
        components.getChildren().add(node);//formeG
    }

    /**
     * Place la balle du moteur aux coordonnees x et y de cette forme
     * @param components Le panneau dans lequel ajouter la balle
     * @param m le moteur de jeu qui contient l'objet Level et les formes
     * @param num le numero de la forme a ajouter
     * */
    public void placerBalle() {
    	//Node node = m.getBall();
    	Form balle = level.getBall();
    	System.out.println("balle placee en x="+balle.getPosX()+
    			" y="+balle.getPosY() + " balle="+balle);
    	Node node = balle.getForme();
    	node.setTranslateX(balle.getPosX());
        node.setTranslateY(balle.getPosY());
        components.getChildren().add(node);//ajout de la balle dans le canevas
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	//composants
    	components = new Pane();//boite contenant les formes du jeu
    	Background b = new Background(new BackgroundFill(ColorSelected.BLACK,null,null));
		components.setBackground(b);//fond
    	
    	this.level = new Level(this, "niveauTest");

    	//parametres de l'objet Stage
    	primaryStage.setTitle("Color Switch L3 group : PITROU BARRECH CALVO-FERNANDEZ");
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {//fermeture
            @Override
            public void handle(final WindowEvent event) {
				System.exit(0);
			}
        });

		//Menus
		m = new Moteur(this);
        ZMenuBar menuBar = new ZMenuBar(root, m, level);//la barre de menu
        ContextualMenu cm = new ContextualMenu(m);
        components.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
        	@Override public void handle(MouseEvent e) {
        	if (e.getButton() == MouseButton.SECONDARY)
        	cm.show(components, e.getScreenX(), e.getScreenY());
        	}
        });

        //objet root
        root = new BorderPane();
        root.setCenter(components);
        root.setTop(menuBar);//Barre de Menu
        primaryStage.setScene(new Scene(root, LARGEUR_FENETRE, HAUTEUR_FENETRE));
        root.setPrefSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        
        //ecouteur de touche
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, 
        		ControlerFactory.build(KeyEvent.KEY_PRESSED, level));
        //primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, 
        //		ControlerFactory.build(KeyEvent.KEY_RELEASED, level));
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        		ControlerFactory.build(MouseEvent.MOUSE_CLICKED, level, m));
        
        primaryStage.setResizable(false);
        primaryStage.show();
        
        menu();
        
        m.start();
    }
    
    /**
     * Teste si la forme passee en parametres est dans les limites de la fenetre ou non
     * @param Form forme la forme a tester
     * @return true si la forme est dans les limites de la fenetre et false sinon
     * */
    public boolean isInBounds(Form forme) {
    	assert(forme != null);
    	
    	return forme.getPosX() < getLargeurFenetre() + 200
				&& forme.getPosX() > - 200
				&& forme.getPosY() < getHauteurFenetre() - 50//+ 200
				&& forme.getPosY() > - 200;
    }
    
    /**
     * Teste si la forme est deja dans la fenetre ou non
     * @param Form forme la forme a tester
     * @return true si la forme est dans la fenetre et false sinon
     * */
    public boolean isInComponent(Form forme) {
    	return components.getChildren().contains(forme.getForme());
    }
    
    /**
     * Nouvelle parite
     * */
    public void nouvellePartie() {
    	m.cancel();//arrete le moteur
    	components.getChildren().removeAll(components.getChildren());//enleve les formes actuelles
    	
    	//placement des formes
        for(Form forme:level.getObjects()) {//place les formes
        	if(isInBounds(forme)) {
        		placerForme(forme);
        	}
        }
        
        //placement de la balle
        //placerBalle();
        m.restart();
    }

    /**
     * Fait defiler l'ecran selon l'axe des Y
     * */
	public void defilerEcranY() {
		//int DEFILEMENT = level.getBall().getSpeed();
		
		for(int i=0;i<level.getObjects().size();i++) {//bouge les objets
			Form forme = level.getObjects().get(i);
			forme.setPosY(forme.getPosY()+level.getBall().getSpeed());
			Node node = forme.getForme();
	    	node.setTranslateY(forme.getPosY());
		}
		Form balle = level.getBall();
		balle.setPosY(balle.getPosY()+level.getBall().getSpeed());//bouge la balle
		Node node = balle.getForme();
    	node.setTranslateY(balle.getPosY());
    	
    	level.setCoordinateY(level.getCoordinateY()+level.getBall().getSpeed());//modifie les coordonnees
	}
	
	@Override
	public void update(Observable arg0, Object obj) {
		//System.out.println("J'observe bien !!!");
		Platform.runLater(() -> {
			placerForme((Form)obj);
		});
	}


	public void retirerForme(Form forme) {
		Platform.runLater(() -> {
			components.getChildren().remove(forme.getForme());
		});
	}


	public void clearForms() {
		Platform.runLater(() -> {
			components.getChildren().clear();
		});
	}
	
	/**
     * Menu
     * */
    public void menu() {
    	//m.stop();
    	//Pane aremplacer = new Pane();
    	System.out.println("nbre : "+components.getChildren().size());
    	System.out.println("comp : "+components.getChildren());
    	clearForms();
    	
    	Form forme = FormsFactory.build("BoutonJouer", getLargeurFenetre()/2 - 10,
    			getHauteurFenetre()/2 - 10,100 , 100, 3, 0);
        //bouton.setFill(ColorSelected.BLUE);
        //bouton.setRadius(20);
    	Group bouton = forme.getForme();
        bouton.setTranslateX(getLargeurFenetre()/2 - 10);
        bouton.setTranslateY(getHauteurFenetre()/2 - 10);
        bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        		ControlerFactory.build(MouseEvent.MOUSE_RELEASED, level, m));
        //aremplacer.getChildren().add(bouton);
        //components = aremplacer;
        Platform.runLater(() -> {
        	components.getChildren().add(bouton);
        });
        
        //assuprimer.getChildren().remove(1);
        //assuprimer.getChildren().add(aremplacer);
        //components = aremplacer;
    }
}



