package main.model.forms;

class CroixD extends CroixG{

	public CroixD(int posX, int posY, int speed, int rotate) {
		super(posX, posY, speed, rotate);

	}

	public void deplacer() {
		int rotation=-8;
		if(rotation > 360 ) {//la rotation reste modulo 360
			rotation -= 360;
		}else if(rotation<-360){
			rotation += 360;
		}
		rotation -= 8;
		forme.setRotate(rotation);
	}
}
