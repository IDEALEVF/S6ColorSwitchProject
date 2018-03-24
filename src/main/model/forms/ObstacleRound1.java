package main.model.forms;

import javafx.scene.paint.Color;

class ObstacleRound1 extends Obstacles{
	private final Form part1;
	private final Form part2;
	private final Form part3;
	
	ObstacleRound1(int posX, int posY, int width, int height, int speed, int rotate){
		super(posX, posY, width, height, speed, rotate);
		part1 = FormsFactory.build("ROUND1", posX, posY, width, height, speed, 45);
		part2 = FormsFactory.build("ROUND2", posX, posY, width-34, height-34, speed, 45);
		part3 = FormsFactory.build("ROUND1", posX, posY, width-68, height-68, speed, 45);
		
		addObstacle(part1.getForme());
		addObstacle(part2.getForme());
		addObstacle(part3.getForme());
		
		Color[] colorPossible = {BLUE,YELLOW};//les couleurs possibles
		addColorPossible(colorPossible);
	}
	
	@Override
	public void deplacer() {
		part1.deplacer();
		part2.deplacer();
		part3.deplacer();
	}

	@Override
	public String toString() {
		return "ObstacleRound1 [part1=" + part1 + ", part2=" + part2 + ", part3=" + part3 + ", posX=" + posX + ", posY="
				+ posY + ", width=" + width + ", height=" + height + ", speed=" + speed + ", forme=" + forme
				+ ", rotation=" + rotation + "]";
	}
}
