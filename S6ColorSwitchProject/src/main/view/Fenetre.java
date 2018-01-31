package main.view;

import java.util.Iterator;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.controler.Moteur;
import main.model.ColorSelected;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

public class Fenetre extends Application {
	VBox root;

    public static void main(String[] args) {
        launch(args);
    }

    public VBox getRoot() {
    	return root;
    }

    public Rectangle fond() {
    	Rectangle r = new Rectangle();//fond
        r.setFill(ColorSelected.BLACK);
        r.setWidth(500);
        r.setHeight(800);

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

        MenuBar2 menuBar = new MenuBar2(root);//la barre de menu

        components.getChildren().add(fond());//fond
        for(int i=0;i<m.getFormNumber();i++) {//place les formes
        	 placerForme(components, m, i);
        }

        root.getChildren().add(menuBar);//Barre de Menu
        root.getChildren().add(components);

        primaryStage.setScene(new Scene(root, 500, 800));
        m.start();
        primaryStage.show();
    }

}



