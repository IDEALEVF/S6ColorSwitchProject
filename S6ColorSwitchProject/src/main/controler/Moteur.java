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

	private void deplacerBall() {
		if(f.getLevel().getBall().getPosY()<f.getHauteurFenetre()/2) {
			f.defilerEcranY();
		}
		f.getLevel().getBall().deplacer();
		f.getLevel().getBall().gravityY(f.getLevel().gravityY());//la balle tombe selon la gravite
	}

	private boolean isPerdu() {
		return f.getLevel().getBall().getPosY()>f.getHauteurFenetre()-50;//en bas de l'ecran
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
					f.getLevel().gravityYStop();//arrete la balle
					f.getLevel().getBall().gravityY(0);
					break;
					//System.exit(0);
				}
				for(int i=0;i<f.getLevel().getObjects().size();i++) {
					f.getLevel().getObjects().get(i).deplacer();//deplace chaque forme
				}
			}
		}
	}

}
