package main.model.forms;

import javafx.scene.Group;
import main.model.Level;

abstract class Obstacles extends Form{

	Obstacles(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		
		ajouterForme(new Group());
	}
	
	protected void addObstacle(Group g) {
		Group obstacles = (Group) this.forme.getChildren().get(0);
		obstacles.getChildren().add(g);
	}
	
	@Override
	public boolean doCollision(Level level) {
		//level.getBall().setCouleur(ColorSelected.couleuralea());
		return true;
	}

	@Override
	public String toString() {
		return "Obstacles [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed="
				+ speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}
}
