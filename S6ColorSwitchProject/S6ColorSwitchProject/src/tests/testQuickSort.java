package tests;

import static org.junit.Assert.assertTrue;

import java.util.Vector;


import org.junit.Test;


import main.model.QuickSort;
import main.model.Pair;

class testQuickSort{
	Vector<Pair<String, Integer>> tab = new Vector<Pair<String, Integer>>();
	Vector<Pair<String, Integer>> tab2 = new Vector<Pair<String, Integer>>();

	@Test
	void testQuickSort() {
		tab.add(new Pair<String, Integer>("Bob", 3));
		tab.add(new Pair<String, Integer>("Bob", 56));
		tab.add(new Pair<String, Integer>("Bob", 8));
		tab.add(new Pair<String, Integer>("Bob", 16));
		tab.add(new Pair<String, Integer>("Bob", 4));
		tab.add(new Pair<String, Integer>("Lyse", 1));
		tab.add(new Pair<String, Integer>("Manon", 9));



		afficher(tab);


		tab2.add(new Pair<String, Integer>("Lyse", 1));
		tab2.add(new Pair<String, Integer>("Bob", 3));
		tab2.add(new Pair<String, Integer>("Bob", 4));
		tab2.add(new Pair<String, Integer>("Bob", 8));
		tab2.add(new Pair<String, Integer>("Manon", 9));
		tab2.add(new Pair<String, Integer>("Bob", 16));
		tab2.add(new Pair<String, Integer>("Bob", 56));


		afficher(tab2);


		QuickSort q = new QuickSort();
		q.quickSort(tab,  0,  tab.size()-1);

		afficher(tab);

		assertTrue("Tri incorrect : "+tab, iddentiques(tab,tab2));
	}


	public boolean iddentiques(Vector<Pair<String, Integer>> tab,Vector<Pair<String, Integer>> tab2 ) {
		for(int i=0;i<tab.size();i++) {
			if(tab.get(i).second() != tab2.get(i).second()) {
				return false;
			}
		}
		return true;
	}

	public void afficher(Vector<Pair<String, Integer>> tab) {
		for(int i=0; i <tab.size();i++) {
			System.out.println(tab.get(i));
		}
	}
}
