package tests;

import static org.junit.Assert.*;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

import main.model.forms.FormsFactory;

class testFormsFactory {
	
	@Test
	void testbuild() {
		assertTrue("Default error", null == FormsFactory.build("DEFAULT", 10, 10, 12));
	}
	
}
