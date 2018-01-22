package main.model;

import java.util.Comparator;

public class QuickSort {

	class Comparateur implements Comparator<Integer> {

	    @Override
	    public int compare(Integer v1, Integer v2) {
	        return v1 - v2;
	    }
	}

	private class ComparateurBis {

	    public <T> void quickSort(T[] arr, Comparator<T> cmp, int debut, int fin) {
	        if (debut < fin) {
	            int d = debut;
	            int f = fin;
	            T x = arr[(d + f) / 2];

	            do {
	                while (cmp.compare(arr[d], x) < 0) d++;
	                while (cmp.compare(x, arr[f]) < 0) f--;

	                if ( d <= f) {
	                    T tmp = arr[d];
	                    arr[d] = arr[f];
	                    arr[f] = tmp;
	                    d++;
	                    f--;
	                }

	            } while (d <= f);

	            quickSort(arr, cmp, debut, f);
	            quickSort(arr, cmp, d, fin);
	        }
	    }

	}
}
