package main.model.forms;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import main.model.ColorSelected;

class MessageColorSwitch extends Form{
	
	Set<Form> parties = new HashSet<Form>();
	
	MessageColorSwitch(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, speed, rotate);
		
		Label lab = new Label("C");
		//lab.setTranslateY(posY);
		//lab.setPrefWidth(width);
		//lab.setPrefHeight(height);
		lab.setFont(new Font(3*width));
		lab.setTextFill(ColorSelected.BLUE);
		
		Round1 round1 = new Round1(0, 0, width, height, speed, rotate);
		round1.getForme().setTranslateX(3*width+width/2);
		round1.getForme().setTranslateY(3*(height/2));
		
		Label lab2 = new Label("lor switch");
		lab2.setTranslateX(6*width);
		//lab2.setTranslateY(posY);
		//lab2.setPrefWidth(width);
		//lab2.setPrefHeight(height);
		lab2.setFont(new Font(3*width));
		lab2.setTextFill(ColorSelected.BLUE);
		
		parties.add(round1);
		
		this.forme.getChildren().add(lab);
		this.forme.getChildren().add(round1.getForme());
		this.forme.getChildren().add(lab2);
	}

	@Override
	public void deplacer() {
		Iterator<Form> it = parties.iterator();
		while(it.hasNext()) {
			it.next().deplacer();
		}
	}
	
}
