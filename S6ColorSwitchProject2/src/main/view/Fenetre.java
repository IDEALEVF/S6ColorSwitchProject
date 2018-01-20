package main.view;

import java.util.Iterator;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.controler.Moteur;
import main.model.Level;
import main.model.forms.Carre;
import main.model.forms.Form;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

public class Fenetre extends Application {
	StackPane root;

    public static void main(String[] args) {
        launch(args);
    }

    public StackPane getRoot() {
    	return root;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        root = new StackPane();
        System.out.println(root.getChildren().toString());
    	Level level = new Level("src/ressources/niveauTest.txt");
    	Iterator<Form> it = level.getObjects().iterator();
    	int i=1;
		while(it.hasNext()){
			Group g=it.next().getForme();
			Moteur m = new Moteur(g,0,0,0);
			root.getChildren().add(g);
			System.out.println(i);
			i++;
		}
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(final WindowEvent event) {
				System.exit(0);
			}
        });

        //Node n=m.getLevel().getObjects().get(0).getForme();
        //root.getChildren().add(n);
        System.out.println(root.getChildren().toString());
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}



