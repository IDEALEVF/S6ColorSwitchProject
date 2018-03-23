package main.model.forms;

public class Croix2 extends Obstacles{
	private final Form part1;
	private final Form part2;

	Croix2(int posX, int posY, int width, int height, int speed, int rotate){
		super(posX, posY, width, height, speed, rotate);
		part1 = FormsFactory.build("CROIXG", posX-20, posY-20, width, height, speed, rotate);
		part2 = FormsFactory.build("CROIXD", posX+20, posY+20, width, height, speed, rotate);

		addObstacle(part1.getForme());
		addObstacle(part2.getForme());

		
	}

	@Override
	public void deplacer() {
		part1.deplacer();
		part2.deplacer();
	}

	@Override
	public String toString() {
		return "ObstacleRound1 [part1=" + part1 + ", part2=" + part2 + ", posX=" + posX + ", posY="
				+ posY + ", width=" + width + ", height=" + height + ", speed=" + speed + ", forme=" + forme
				+ ", rotation=" + rotation + "]";
	}
}
