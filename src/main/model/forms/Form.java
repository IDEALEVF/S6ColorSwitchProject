package main.model.forms;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import main.model.ColorSelected;
import main.model.Level;

/**
 * Classe abstraite qui represente un des objets manipule par le jeu
 * Color Switch. La classe encapsule un champ forme qui correspond a l'apparence
 * de la forme sur une scene java FX et les proprietes de l'objet.
 * Elle definit aussi des services generiques aux formes.
 * @author PITROU Adrien
 * @since 20/01/2018
 * @version 1.0
 * */
public abstract class Form extends ColorSelected implements Cloneable{
	protected int posX;
	protected int posY;
	protected int width;
	protected int height;
	protected int speed;
	protected Group forme;
	protected int rotation;
	protected ArrayList<Color> colorPossible;

	Form(int posX, int posY, int width, int height, int speed, int rotate){
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.rotation = rotate;
		this.forme = new Group();

		forme.setRotate(rotation);
	}

	public abstract void deplacer();

	public void addColorPossible(Color[] liste) {
		assert(liste != null);

		colorPossible = new ArrayList<Color>();
		for(int i=0;i<liste.length;i++) {
			colorPossible.add(liste[i]);
		}
	}

	public void addColorPossible(ArrayList<Color> liste) {
		assert(liste != null);

		colorPossible = new ArrayList<Color>();
		for(Color couleur : liste) {
			colorPossible.add(couleur);
		}
	}

	public ArrayList<Shape> getShape(){
		return getShapeGroup(forme);
	}
	/**
	 * Fonction récursive qui retourne la liste des formes
	 * @author adélie
	 * @param Group f1
	 * @return ArrayList<Shape> listShape
	 * */
	private ArrayList<Shape> getShapeGroup(Group f1){
      ArrayList<Shape> listShape=new ArrayList<Shape>();
      //int taille=f1.getChildren().size();
      for(Node noeud : f1.getChildren()){
      	//System.out.println("for : "+noeud);
          //listShape.add((Shape) forme.getChildren().get(i));

          if((Shape.class).isAssignableFrom(noeud.getClass())){
              listShape.add((Shape) (noeud));
          }else if((Label.class).isAssignableFrom(noeud.getClass())) {
          	continue;
          }else{
              listShape.addAll(getShapeGroup((Group)noeud));
          }

      }
      return listShape;
	}

	public abstract boolean doCollision(Level level);

	public Group getForme() {
		return forme;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	protected void ajouterForme(Node n) {
		assert(n!=null);

		forme.getChildren().add(n);
	}

	public boolean isInBounds(Form forme) {
		return (posX > forme.posX && posX < forme.posX + width) ||
				(posY > forme.posY && posY < forme.posY + height) ||
				(posX + width > forme.posX && posX + width < forme.posX + width) ||
				(posY + height > forme.posY && posY + height < forme.posY + height);
	}

	public boolean isBoundsIntersect(Form forme) {
		return this.isInBounds(forme) || forme.isInBounds(this);
	}

	protected void tourner(){
		if(rotation > 360) {//la rotation reste modulo 360
			rotation -= 360;
		}
		rotation += speed;
		forme.setRotate(rotation);
	}



	@Override
	public String toString() {
		return "Form [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + posX;
		result = prime * result + posY;
		result = prime * result + rotation;
		result = prime * result + speed;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Form other = (Form) obj;
		if (height != other.height)
			return false;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		if (rotation != other.rotation)
			return false;
		if (speed != other.speed)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = this.getClass().getDeclaredConstructor(
					int.class, int.class, int.class, int.class, int.class, int.class).newInstance(
							posX, posY, width, height, speed, rotation);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return o;
	}

	public ArrayList<Color> getColorPossible() {
		return colorPossible;
	}
}
