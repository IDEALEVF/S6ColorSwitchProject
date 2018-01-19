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
    	Moteur m = new Moteur(this);
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(final WindowEvent event) {
				System.exit(0);
			}
        });
    	
        primaryStage.setTitle("Hello World!");
        
        root = new StackPane();
        System.out.println(root.getChildren().toString());
        
        root.getChildren().add(m.getFirstForm());
        System.out.println(root.getChildren().toString());
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}



