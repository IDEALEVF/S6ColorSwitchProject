package main.controler;

import javafx.scene.Group;
import javafx.scene.Node;
import main.model.Level;
import main.model.Score;
import main.model.Type;
import main.view.Fenetre;

public class Moteur implements Runnable{
	Fenetre f;
	private Thread t;
	
	public Moteur(Fenetre f) {
		t = new Thread(this);
		this.f = f;
	}
	
	/*public Score getScore() {
		return level.getScore();
	}*/
	
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

//	public Level getLevel() {
//		return level;
//	}
//	
//	public Group getForm(int num) {
//		return level.getObjects().get(num).getForme();
//	}
//	
//	public int getFormX(int num) {
//		return level.getObjects().get(num).getPosX();
//	}
//	
//	public int getFormY(int num) {
//		return level.getObjects().get(num).getPosY();
//	}
//	
//	public void setFormX(int num, int val) {
//		level.getObjects().get(num).setPosX(val);
//	}
//	
//	public void setFormY(int num, int val) {
//		level.getObjects().get(num).setPosY(val);
//	}
//	
//	private void deplacerForme(int num) {
//		level.getObjects().get(num).deplacer();
//	}
//	
//	public int getFormNumber() {
//		return level.getObjects().size();
//	}
	
//	public Node getBall() {
//		return level.getBall().getForme();
//	}
//	
//	public int getBallX() {
//		return level.getBall().getPosX();
//	}
//	
//	public int getBallY() {
//		return level.getBall().getPosY();
//	}
//	
//	public void gravityDown() {
//		level.gravityDown();
//	}
//	
//	public void gravityUp() {
//		level.gravityUp();
//	}
//	
//	public void gravityLeft() {
//		level.gravityLeft();
//	}
//	
//	public void gravityRight() {
//		level.gravityRight();
//	}
//	
//	public void setBallY(int val) {
//		level.getBall().setPosY(val);
//	}
	
	private void deplacerBall() {
		if(f.getLevel().getBall().getPosY()<f.getHauteurFenetre()/4) {
			f.defilerEcranY();
		}else {
			f.getLevel().getBall().deplacer();
			f.getLevel().getBall().gravityY(f.getLevel().gravityY());//la balle tombe selon la gravite
		}
		
	}
	
	private boolean isPerdu() {
		return f.getLevel().getBall().getPosY()>f.getHauteurFenetre();//en bas de l'ecran
	}

	@Override
	public void run() {
		try {//pause pour epargner mon ordi -> retarde le lancement
			t.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(true) {
			synchronized(t) {
				try {//pause
					t.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				deplacerBall();//deplace la balle ou fait defiler l'ecran
				if(isPerdu()) {//teste la defaite
					System.exit(0);
				}
				for(int i=0;i<f.getLevel().getObjects().size();i++) {
					f.getLevel().getObjects().get(i).deplacer();//deplace chaque forme
				}
			}
		}
	}
	
}
