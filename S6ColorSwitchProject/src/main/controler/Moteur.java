package main.controler;

import javafx.scene.Group;
import main.model.Level;
import main.model.Score;
import main.view.Fenetre;

public class Moteur implements Runnable{
	
	private Level level;
	private Thread t;
	Fenetre f;
	
	public Moteur(Fenetre f) {
		this.level = new Level("src/ressources/niveauTest.txt");
		t = new Thread(this);
	}
	
	public Score getScore() {
		return level.getScore();
	}
	
	public void start() {
		t.start();
	}
	
	public synchronized void restart() {
		t.resume();
		/*synchronized(t) {
			t.notify();
		}*/
	}
	
	public synchronized void stop() {
		t.suspend();
		/*synchronized(t) {
			t.interrupt();
		}*/
	}

	public Level getLevel() {
		return level;
	}
	
	public Group getForm(int num) {
		return level.getObjects().get(num).getForme();
	}
	
	public int getFormX(int num) {
		return level.getObjects().get(num).getPosX();
	}
	
	public int getFormY(int num) {
		return level.getObjects().get(num).getPosY();
	}
	
	private void deplacerForme(int num) {
		level.getObjects().get(num).deplacer();
	}
	
	public int getFormNumber() {
		return level.getObjects().size();
	}

	@Override
	public void run() {
		while(true) {
			for(int i=0;i<getFormNumber();i++) {
				deplacerForme(i);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
