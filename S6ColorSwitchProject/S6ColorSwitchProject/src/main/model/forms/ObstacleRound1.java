package main.model.forms;

import javafx.scene.Group;

public class ObstacleRound1 extends Obstacles{
	private final Form part1;
	private final Form part2;
	private final Form part3;
	
	ObstacleRound1(int posX, int posY, int width, int height, int speed, int rotate){
		super(posX, posY, speed, rotate);
		part1 = FormsFactory.build("ROUND1", posX, posY, width+14, height+14, speed, rotate);
		part2 = FormsFactory.build("ROUND2", posX, posY, width+7, height+7, speed, rotate);
		part3 = FormsFactory.build("ROUND1", posX, posY, width, height, speed, rotate);
		
		this.forme.getChildren().add(part1.getForme());
		this.forme.getChildren().add(part2.getForme());
		this.forme.getChildren().add(part3.getForme());
	}
	
	@Override
	public void deplacer() {
		part1.deplacer();
		part2.deplacer();
		part3.deplacer();
	}
}
