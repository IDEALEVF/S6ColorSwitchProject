package main.model;

import java.util.Comparator;
import java.util.Vector;

/**
 * QuickSort trouve sur internet et utilise pour trier les scores.
 * */
public class QuickSort {

	public void quickSort(Vector<Pair<String, Integer>> tab, int debut, int fin) {
		System.out.println("--Quicksort--");
		if (debut < fin) {
	    	int d = debut;
	    	int f = fin;
	        int pivot = tab.get((d + f) / 2).second();

	        do {
	        	while ((tab.get(d).second() - pivot) < 0) { 
	        		d++;
	        	}
	        	while ((pivot - tab.get(f).second()) < 0) {
	        		f--;
	        	}

	        	if ( d <= f) {
	            	String tmp1 = tab.get(d).first();
	            	int tmp2 = tab.get(d).second();
	            	System.out.println("d="+d+" f="+f+" pivot="+pivot);
	            	
	            	//tab.add(d, tab.get(f));
	            	tab.get(d).setFirst(tab.get(f).first());
	            	tab.get(d).setSecond(tab.get(f).second());
	            	
	            	//tab.add(f, tmp);
	            	tab.get(f).setFirst(tmp1);
	            	tab.get(f).setSecond(tmp2);
	            	
	                d++;
	                f--;
	                //System.out.println("fin casse d="+d+" f="+f+" pivot="+pivot);
	            }
	        } while (d <= f);
	        
	        quickSort(tab, debut, f);
	        quickSort(tab, d, fin);
	    }
	}
}

//public class QuickSort {
//
//	private class Comparateur implements Comparator<Integer> {
//		@Override
//	    public int compare(Integer v1, Integer v2) {
//	    	return v1 - v2;
//	    }
//	}
//
//	public void quickSort(int[] tab, int debut, int fin) {
//		if (debut < fin) {
//	    	int d = debut;
//	    	int f = fin;
//	        int pivot = tab[(d + f) / 2];
//
//	        do {
//	        	while ((tab[d] - pivot) < 0) { 
//	        		d++;
//	        	}
//	        	while ((pivot - tab[f]) < 0) {
//	        		f--;
//	        	}
//
//	        	if ( d <= f) {
//	            	int tmp = tab[d];
//	                tab[d] = tab[f];
//	                tab[f] = tmp;
//	                d++;
//	                f--;
//	            }
//	        } while (d <= f);
//	        
//	        quickSort(tab, debut, f);
//	        quickSort(tab, d, fin);
//	    }
//	}
//}
