package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


			Line ligneHaut=new Line(10.0,10.0,40.0,10.0);
			ligneHaut.setFill(Color.BLUE);
			ligneHaut.setStroke(Color.BLUE);
			ligneHaut.setStrokeWidth(5);

			Line ligneBas=new Line(10.0,40.0,40.0,40.0);
			ligneBas.setFill(Color.YELLOW);
			ligneBas.setStroke(Color.YELLOW);
			ligneBas.setStrokeWidth(5);

			Line ligneGauche=new Line(10.0,10.0,10.0,40.0);
			ligneGauche.setFill(Color.GREEN);
			ligneGauche.setStroke(Color.GREEN);
			ligneGauche.setStrokeWidth(5);

			Line ligneDroite=new Line(40.0,10.0,40.0,40.0);
			ligneDroite.setFill(Color.RED);
			ligneDroite.setStroke(Color.RED);
			ligneDroite.setStrokeWidth(5);

			Shape angle1=Shape.union(ligneGauche, ligneHaut);
			Shape angle2=Shape.union(ligneDroite, ligneBas);
			Shape carre=Shape.union(angle1, angle2);
			root.getChildren().add(ligneHaut);
			root.getChildren().add(ligneBas);
			root.getChildren().add(ligneGauche);
			root.getChildren().add(ligneDroite);






			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
