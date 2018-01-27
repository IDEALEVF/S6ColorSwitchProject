package tests;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

class allTests {

	@Test
	void testFormsFactory() {
=======
import org.junit.Test;

public class allTests {

	@Test
	public void testFormsFactory() {
>>>>>>> figure
		testFormsFactory t1 = new testFormsFactory();
		t1.testbuild();
		
	}

	@Test
<<<<<<< HEAD
	void testLevel() {
=======
	public void testLevel() {
>>>>>>> figure
		testLevel t2 = new testLevel();
		t2.testConstructorDefault();
		t2.testConstructorLoader();
		
	}
	
	@Test
<<<<<<< HEAD
	void testLoader() {
=======
	public void testLoader() {
>>>>>>> figure
		testLoader t3 = new testLoader();
		t3.testread();
		t3.testreadInTab();
	}
	
	@Test
<<<<<<< HEAD
	void testType() {
=======
	public void testType() {
>>>>>>> figure
		testType t4 = new testType();
		t4.testEnumType();
		
	}
}
