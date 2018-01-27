package tests;

import org.junit.Test;

public class allTests {

	@Test
	public void testFormsFactory() {
		testFormsFactory t1 = new testFormsFactory();
		t1.testbuild();
		
	}

	@Test
	public void testLevel() {
		testLevel t2 = new testLevel();
		t2.testConstructorDefault();
		t2.testConstructorLoader();
		
	}
	
	@Test
	public void testLoader() {
		testLoader t3 = new testLoader();
		t3.testread();
		t3.testreadInTab();
	}
	
	@Test
	public void testType() {
		testType t4 = new testType();
		t4.testEnumType();
		
	}
}
