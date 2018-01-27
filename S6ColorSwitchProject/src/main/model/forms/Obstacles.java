package main.model.forms;

public abstract class Obstacles extends Form{

	Obstacles(int posX, int posY, int speed) {
		super(posX, posY, speed);
	}

	@Override
	public String toString() {
		return "Obstacles [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
