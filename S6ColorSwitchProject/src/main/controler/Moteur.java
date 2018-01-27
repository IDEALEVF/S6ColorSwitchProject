package main.controler;

import java.util.Iterator;

import javafx.scene.Group;
import main.model.Level;
import main.model.forms.Form;
import main.view.Fenetre;

public class Moteur extends Form{

	//private Level level;
	private Thread t;
	Group g;

	public Moteur(Group g,int posX, int posY, int speed) {
		super(posX, posY, speed);
		//this.level = new Level("src/ressources/niveauTest.txt");
		t = new Thread(this);
		t.start();
		this.g=g;
	}

	/*public Level getLevel() {
		return level;
	}*/

	/*public Group getFirstForm() {
		return level.getObjects().get(0).getForme();
	}*/

	@Override
	public void run() {
		int val = 0;
		while(true) {
			//Iterator<Form> it = level.getObjects().iterator();
			/*while(it.hasNext()){
				it.next().getForme().setRotate(val);
			}*/
			g.setRotate(val);
			val += 20;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deplacer() {


	}
}
