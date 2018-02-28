package main.model;

import java.util.ArrayList;
import java.util.Vector;
import javafx.scene.*;
import javafx.scene.paint.Color;
import main.model.forms.Ball;
import main.model.forms.Form;

public class Collision<Obstacles> {
	Ball balle;
	private Vector<Form> formes;

	public Collision( Ball b, Vector<Form> f) {
		balle=b;
		formes=f;
	}

	public boolean isCol(){
		for (Form it : formes){
			Node ob=it.getForme();
			Node bal=balle.getForme();
            if (ob != bal) {
            	if (ob.getBoundsInParent().intersects(bal.getBoundsInParent())) {
                    //((Node)(it.getForme().getChildren().get(0)));
            		if(balle.getCouleur()!=ColorSelected.MENU){
            			balle.setCouleur(ColorSelected.MENU);
            		}
            		else{
            			balle.setCouleur(ColorSelected.BLUE);
            		}
                	System.out.println("collision réussie");//collision
                	return true;
                } else {
                	System.out.println("collision non réussie");    //no collision
                }
            } else {
            	System.out.println("balle");    //no collision -same block
            }
			//System.out.println("ITX "+it.getPosX());

			///System.out.println("ITY "+it.getPosY());
		}

		/*System.out.println("BALLEeeeeee "+balle.getBoundsInLocal());
		System.out.println("BALLE "+balle.getPosX());
		System.out.println("BALLE "+balle.getPosY());*/
		return false;

	}

}
