package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import main.model.Level;
import main.model.Type;

class testLevel {
	
	@Test
	void testConstructorDefault() {
		Level l = new Level();
		assertTrue("Default constructor error", l.getName().equals("niveau 1") &&
				l.getScore() == 0 &&
				l.getObjects() != null &&
				l.getObjects().size() == 0 &&
				l.getNumber() == 0);
	}
	
	@Test
	void testConstructorLoader() {
		Level l = new Level("src/ressources/niveauTest.txt");
		assertTrue("Default constructor loader name", l.getName().equals("niveau 1"));
		assertTrue("Default constructor loader score",l.getScore() == 0);
		assertTrue("Default constructor loader object not null",l.getObjects() != null);
		assertTrue("Default constructor loader object size", l.getObjects().size() == 1);
		assertTrue("Default constructor loader number",l.getNumber() == 1);
		assertTrue("Default constructor loader type",l.getType() == Type.NORMAL);
	}
}
