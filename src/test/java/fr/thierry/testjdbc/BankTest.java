package fr.thierry.testjdbc;
/**
 * 
 * @author Thierry
 * Class testing of Customer
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest {

	private static final String BANK_NAME_TEST_STRING = "MyBank CGU";
	
	private Bank bankTest = new Bank(BANK_NAME_TEST_STRING);
	
	public BankTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void banKNameTest(){
		
		assertEquals(BANK_NAME_TEST_STRING, bankTest.getName());
	}

}
