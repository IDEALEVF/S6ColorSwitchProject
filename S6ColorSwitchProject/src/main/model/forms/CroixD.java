package main.model.forms;

public class CroixD extends CroixG{

	public CroixD(int posX, int posY, int speed) {
		super(posX, posY, speed);
	}

	public void deplacer() {
		if(rotation > 360 ) {//la rotation reste modulo 360
			rotation -= 360;
		}else if(rotation<-360){
			rotation += 360;
		}
		rotation -= 8;
		forme.setRotate(rotation);
	}
}
