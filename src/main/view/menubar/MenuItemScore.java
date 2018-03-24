package main.view.menubar;

import java.util.Optional;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.Level;
import main.model.Pair;
import main.model.Score;

/**
 * @author CALVO FERNANDEZ Adélie
 * @version 1.0
 * */
public class MenuItemScore extends MenuItem implements Action{

	private TextInputDialog name;


		Border border = new Border(new BorderStroke(Color.RED,null,null,new BorderWidths(3)));

		GridPane gp;


	MenuItemScore(Moteur m,Level l){


		this.setText("Score");
		name= new TextInputDialog("anonyme");

		name.setTitle("Score");
		name.setHeaderText("Voulez-vous enregistrer votre Score?");
		name.setContentText("Nom ");

		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l));
	}


	public void enregistrer(Level l,String s){



		l.getScore().add(s, l.getPoints());
	}

	@Override
	public void action(Level level) {
		gp = new GridPane();
		Score s1 = level.getScore();
		Vector<Pair<String, Integer>> tab = s1.getTab();

		//System.out.println(tab.size());
		for(int i=0;i<tab.size();i++) {//ajout des scores
			Label lnom = new Label(tab.get(i).first()+" ");
			Label lscore = new Label("score : "+tab.get(i).second());
			//lnom.setBackground(b);
			lnom.setBorder(border);
			lscore.setBorder(border);
			gp.add(lnom, 0, i);
			gp.add(lscore, 1, i);
		}

		name.setGraphic(gp);
		Optional<String> result=name.showAndWait();
		if (result.isPresent()) {
			//System.out.println(result.get());
			//System.out.println(level);
		     enregistrer(level,result.get());
		 }


	}
}