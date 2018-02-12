package main.model.forms;

public abstract class Obstacles extends Form{

	Obstacles(int posX, int posY, int speed, int rotate) {
		super(posX, posY, speed, rotate);
	}

	@Override
	public String toString() {
		return "Obstacles [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
