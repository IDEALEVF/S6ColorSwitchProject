package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.controler.ControlerFactory;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import main.model.Level;

public class MenuItemFormeBalle extends MenuItem implements Action{
	private int num;
	private Shape forme;
	//private Level l;

	public MenuItemFormeBalle(int num, Level l){
		this.num = num;
		//this.l = l;
		this.setText("Balle "+num);
		this.setGraphic(new ImageView(new Image("balle"+num+".png")));
		
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l));
		chargerForme();
	}
	
	private void chargerForme() {
		switch(num) {
		case 1:	Circle cercle = new Circle();
				cercle.setRadius(6);//l.getBall().getWidth()
				this.forme = cercle;
				break;
		case 2:	Polygon chemin = new Polygon();//triangle
				chemin.getPoints().add(0.0);//p1
				chemin.getPoints().add(0.0);
				chemin.getPoints().add(10.0);//p2
				chemin.getPoints().add(0.0);
				chemin.getPoints().add(5.0);//p3
				chemin.getPoints().add(10.0);
				this.forme = chemin;
				break;
		default:Rectangle rect = new Rectangle();
				rect.setWidth(10);//l.getBall().getWidth()
				rect.setHeight(10);//l.getBall().getHeight()
				this.forme = rect;
				break;
		}
	}

	public int getNum() {
		return num;
	}

	@Override
	public void action(Level level) {
		System.out.println("Changement de balle : "+this.getNum());
		if(level.getBall() == null) {//pas de balle pas de changement
			return;
		}
		level.getBall().changerApparenceBalle(forme);
	}
}
