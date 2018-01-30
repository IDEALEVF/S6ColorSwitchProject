package main.view.menubar;

import java.util.Vector;

import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import main.controler.Moteur;
import main.model.Pair;
import main.model.Score;

public class DialogScores extends Dialog{
	private Moteur m;
	private Score s;
	
	DialogScores(Moteur m){
		//Background b = new Background(new BackgroundFill(Color.GRAY,null,null));
		Border border = new Border(new BorderStroke(Color.RED,null,null,new BorderWidths(3)));
		
		this.setTitle("Table des scores");
		this.m = m;
		GridPane gp = new GridPane();
		s = m.getScore();
		Vector<Pair<String, Integer>> tab = s.getTab();
		
		for(int i=0;i<6;i++) {//ajout des scores
			Label lnom = new Label(tab.get(i).first()+" ");
			Label lscore = new Label("score : "+tab.get(i).second());
			//lnom.setBackground(b);
			lnom.setBorder(border);
			lscore.setBorder(border);
			gp.add(lnom, 0, i);
			gp.add(lscore, 1, i);
		}
		
		this.setGraphic(gp);
		this.show();
	}
}
