package main.model.forms;

abstract class Bonus extends Form{

	Bonus(int posX, int posY, int speed, int rotate) {
		super(posX, posY, speed, rotate);
	}

	@Override
	public String toString() {
		return "Bonus [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
	
}
