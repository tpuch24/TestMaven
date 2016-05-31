package fr.thierry.testjdbc;
/**
 * 
 * @author Thierry
 * Class testing of Customer
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	private static final String LASTNAME_TEST_STRING = "Nomtest";
	private static final String LASTNAME_TEST_STRING2 = "Nomtest2";
	private static final String FIRSTNAME_TEST_STRING = "FirstnameTest";
	private static final String FIRSTNAME_TEST_STRING2 = "FirstnameTest2";
	
	private static final String COMPLET_NAME_TEST_STRING = LASTNAME_TEST_STRING + " " + FIRSTNAME_TEST_STRING;
	
	private Customer customer = new Customer(LASTNAME_TEST_STRING, FIRSTNAME_TEST_STRING);
	
	public CustomerTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void customerGetLastNameTest(){
		
		customer.setLastName(LASTNAME_TEST_STRING2);
		
		assertEquals(LASTNAME_TEST_STRING2, customer.getLastName());
	}

	@Test
	public void customerGetFirsttNameTest(){
		
		customer.setFirstName(FIRSTNAME_TEST_STRING2);
		
		assertEquals(FIRSTNAME_TEST_STRING2, customer.getFirstName());
	}
	
	@Test
	public void customerGetCompleteNameTest(){
		
		assertEquals(COMPLET_NAME_TEST_STRING, customer.getCompletName());
	}
	
	@Test
	public void customerAccountsNotNullTest(){
		assertNotNull(customer);
	}
	
	@Test
	public void customerEmptyAccountstoStringTest(){
		
		System.out.println(customer.toString());
		
		assertEquals(COMPLET_NAME_TEST_STRING, customer.toString());
	}
}
