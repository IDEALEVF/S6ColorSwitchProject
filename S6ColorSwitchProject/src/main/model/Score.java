package main.model;

import java.util.Comparator;
import java.util.Vector;
import java.util.function.ToIntFunction;


public class Score {
	Vector<Pair<String, Integer>> tabScores;
	
	Score(int size){
		tabScores = new Vector<Pair<String, Integer>>();
		for(int i=0;i<size;i++) {
			tabScores.add(new Pair<String, Integer>("Default", 0));
		}
	}
	
	public String[] getNames(){
		int taille = tabScores.size();
		String[] retour = new String[tabScores.size()];
		
		for(int i=0; i<taille; i++) {
			retour[i] = tabScores.get(i).first();
		}
		
		return retour;
	}
	
	public int[] getScores() {
		int taille = tabScores.size();
		int[] retour = new int[tabScores.size()];
		
		for(int i=0; i<taille; i++) {
			retour[i] = tabScores.get(i).second();
		}
		
		return retour;
	}
	
	public void add(String name, int score) {
		tabScores.add(new Pair<String, Integer>(name, score));
		deleteMin();
	}
	
	private void deleteMin() {
		assert(tabScores.size() > 0);
		
		int indexMin = 0;
		int min = tabScores.get(0).second();
		
		for(int i=1;i<tabScores.size();i++) {
			int val = tabScores.get(i).second();
			if(min > val) {
				indexMin = i;
				min = val;
			}
		}
		tabScores.remove(indexMin);
	}
	
	public Vector<Pair<String, Integer>> getTab(){
		trierParScores();
		return tabScores;
	}

	private void trierParScores() {
		ToIntFunction compare = new ToIntFunction<compare>();
		Comparator<Pair<String, Integer>> c = Comparator.comparingInt(compare);
		tabScores.sort(c);
	}
	
	private void sort() {
		int[] atrier = getScores();
		qsort(atrier);
	}
	
	
	
//	public int compareTo(Object obj) {
//		if(obj.getClass() != Pair.class){
//			throw new IllegalArgumentException("Impossible de comparer une Pair avec un "+obj.getClass());
//		}
//		Pair<String, Integer> paire = (Pair<String, Integer>) obj;
//		if(paire.arg2 < this.arg2){
//			return 1;
//		}else if(paire.arg2 > this.arg2){
//			return -1;
//		}else {
//			return 0;
//		}
//	}
	
	public int compare(int d, int d1) {
		  return d - d1;
	}
}
