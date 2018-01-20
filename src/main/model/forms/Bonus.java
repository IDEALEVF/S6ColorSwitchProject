package main.model.forms;

public abstract class Bonus extends Form{

	Bonus(int posX, int posY, int speed) {
		super(posX, posY, speed);
	}

	@Override
	public String toString() {
		return "Bonus [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
	
}
