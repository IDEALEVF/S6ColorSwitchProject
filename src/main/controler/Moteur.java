package main.controler;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import main.model.Collision;
import main.model.Type;
import main.view.Fenetre;

/**
 * Classe-moteur de l'application. Gere une tache d'arriere plan qui s'occupera
 * de deplacer la balle, les obstacles et lancer les tests de collision entre
 * objets.
 * Cette classe a une forte interdependance avec la fenetre principale qu' elle
 * va raffraichir sans arret.
 * @author PITROU Adrien
 * @version 1.0
 * @since 23/02/18
 * */
public class Moteur extends Service<Object>{
	Fenetre f;
	Task<Object> t;
	Collision col;

	/**
	 * Constructeur du moteur.
	 * @param Fenetre f la fenetre avec qui communiquer
	 * */
	public Moteur(Fenetre f) {
		assert(f != null);

		col=new Collision(f.getLevel());
		this.f = f;
	}

	/**
	 * Deplace la balle ou fait defiler l'ecran. Gere aussi l'attraction de la balle.
	 * */
	private void deplacerBall() {
		assert(f.getLevel() != null);

		if(f.getLevel().getType() != Type.AUTOMATIQUE && f.getLevel().getBall().getPosY()<f.getHauteurFenetre()*2/5) {
			f.defilerEcranY();
		}
		if(f.getLevel().getType() == Type.AUTOMATIQUE) {//mode automatique -> deplacement automatique
			f.getLevel().getBall().deplacer();
		}else {
			f.getLevel().getBall().deplacer();
			f.getLevel().getBall().gravityY(f.getLevel().gravityY());//la balle tombe selon la gravite
		}
	}

	/**
	 * Renvoie true si le niveau est perdu
	 * */
	public boolean isPerdu() {
		assert(f.getLevel() != null);

		if(f.getLevel().getBall() == null) {//pour le menu principal -> pas de balle
			return false;
		}
		return f.getLevel().getBall().getPosY()>f.getHauteurFenetre()-50;//en bas de l'ecran
	}

    @Override
    protected Task<Object> createTask() {
    	t = new MaTask();
    	return t;
    }

    /**
     * Classe interne qui gere l'ensemble des actions realisees par la tâche.
     * */
    private class MaTask extends Task<Object>{

		@Override
		protected Object call() throws Exception {
			System.out.println("call");
			while(true) {
				synchronized(this) {
					Thread.sleep(50);
					for(int i=0;i<f.getLevel().getObjects().size();i++) {//a jouer aussi pour le menu
						f.getLevel().getObjects().get(i).deplacer();//deplace chaque forme
					}
					try{
						if(col.isCol()) {
							this.cancel();
							//Thread.sleep(50);
							f.getLevel().getBall().exploser(f.getLevel().getExplo());
							//Thread.sleep(50);
							//f.getLevel().getExplo().seDeplacer(f.getLevel().getBall());
							f.getLevel().perdu();//fait perdre le niveau
							f.menu();
							return f;
						}
					}
					catch(ClassNotFoundException e){

						e.printStackTrace();

						this.cancel();
					}
					if((isPerdu() && !f.getLevel().isPerdu())) {//teste la defaite
						f.getLevel().perdu();//fait perdre le niveau
						f.menu();
						return f;
					}else {
						deplacerBall();//deplace la balle ou fait defiler l'ecran
					}//else
				}//synchronized
			}//while
		}//call
    }//MaTask

}
