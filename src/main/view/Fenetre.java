package main.view;

import java.util.Iterator;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.view.menubar.ContextualMenu;
import main.view.menubar.ZMenuBar;
import javafx.scene.shape.*;
import javafx.stage.WindowEvent;
 
public class Fenetre extends Application {
	private VBox root;
	private final int HAUTEUR_FENETRE = 600;
	private final int LARGEUR_FENETRE = 400;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    public VBox getRoot() {
    	return root;
    }
    
    public Rectangle fond(VBox root) {
    	Rectangle r = new Rectangle();//fond
        r.setFill(ColorSelected.BLACK);
        r.setWidth(LARGEUR_FENETRE);
        r.setHeight(HAUTEUR_FENETRE);
        
        return r;
    }
    
    private void placerForme(StackPane components, Moteur m, int num) {
    	components.getChildren().add(m.getForm(num));//formes
        components.getChildren().get(num).setTranslateX(m.getFormX(num));
        components.getChildren().get(num).setTranslateY(m.getFormY(num));
    }
    
    @Override
    public void start(Stage primaryStage) {
    	Moteur m = new Moteur(this);
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(final WindowEvent event) {
				System.exit(0);
			}
        });
    	
        primaryStage.setTitle("Color Switch L3 group : PITROU BARRECH CALVO-FERNANDEZ");
        
        root = new VBox();
        StackPane components = new StackPane();//boite contenant les formes du jeu
        
        ZMenuBar menuBar = new ZMenuBar(root, m);//la barre de menu
        ContextualMenu cm = new ContextualMenu(m);
        
        components.getChildren().add(fond(root));//fond
        components.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
        	@Override public void handle(MouseEvent e) {
        	if (e.getButton() == MouseButton.SECONDARY)
        	cm.show(components, e.getScreenX(), e.getScreenY());
        	}
        });
        Background b = new Background(new BackgroundFill(ColorSelected.BLACK,null,null));
		components.setBackground(b);//fond
        for(int i=0;i<m.getFormNumber();i++) {//place les formes
        	 placerForme(components, m, i);
        }
        
        root.getChildren().add(menuBar);//Barre de Menu
        root.getChildren().add(components);
        
        primaryStage.setScene(new Scene(root, LARGEUR_FENETRE, HAUTEUR_FENETRE));
        /*components.setLayoutX(0);
        components.setLayoutY(40);
        components.setScaleX(root.getWidth());
        components.setScaleY(root.getWidth());*/
        components.minHeight(400);
        //root.getChildren().get(1).setLayoutY(40);
        System.out.println(root.getChildren().get(1).getLayoutBounds());
        m.start();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}



