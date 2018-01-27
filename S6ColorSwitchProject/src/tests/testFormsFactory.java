package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.model.forms.FormsFactory;

public class testFormsFactory {
	
	@Test
	public void testbuild() {
		assertTrue("Default error", null == FormsFactory.build("DEFAULT", 10, 10, 12));
	}
	
}
