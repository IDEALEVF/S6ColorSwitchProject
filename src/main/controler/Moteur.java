package main.controler;

import javafx.scene.Group;
import main.model.Level;
import main.view.Fenetre;

public class Moteur implements Runnable{
	
	private Level level;
	private Thread t;
	Fenetre f;
	
	public Moteur(Fenetre f) {
		this.level = new Level("src/ressources/niveauTest.txt");
		t = new Thread(this);
		t.start();
	}

	public Level getLevel() {
		return level;
	}
	
	public Group getFirstForm() {
		return level.getObjects().get(0).getForme();
	}

	@Override
	public void run() {
		int val = 0;
		while(true) {
			getFirstForm().setRotate(val);
			val += 20;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
