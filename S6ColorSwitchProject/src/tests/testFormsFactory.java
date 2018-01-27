package tests;

import static org.junit.Assert.*;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import main.model.forms.FormsFactory;

class testFormsFactory {
	
	@Test
	void testbuild() {
=======
import org.junit.Test;

import main.model.forms.FormsFactory;

public class testFormsFactory {
	
	@Test
	public void testbuild() {
>>>>>>> figure
		assertTrue("Default error", null == FormsFactory.build("DEFAULT", 10, 10, 12));
	}
	
}
