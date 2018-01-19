package tests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import main.model.Loader;

class testLoader {
	
	@Test
	void testread() {
		String[] tab = {
				"#####################################niveau de color switch###############################################",
				"niveau 1",
				"1",
				"NORMAL",
				"##########################################################################################################",
				"Round1 40 56 2"};
		Vector<String> vect = Loader.read("src/ressources/niveauTest.txt");
		Iterator<String> it = vect.iterator();
		
		for(int i=0;i<tab.length;i++) {
			assertTrue("read error", tab[i].equals(it.next()));
		}
	}
	
	@Test
	void testreadInTab() {
		String[] tab = {
				"#####################################niveau de color switch###############################################",
				"niveau 1",
				"1",
				"NORMAL",
				"##########################################################################################################",
				"Round1 40 56 2"};
		String[] tab2 = Loader.readInTab("src/ressources/niveauTest.txt");
		
		for(int i=0;i<tab.length;i++) {
			assertTrue("read error", tab[i].equals(tab2[i]));
		}
	}
	
}
