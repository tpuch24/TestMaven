package fr.thierry.testjdbc;
/**
 * 
 * @author Thierry
 * Class testing of Customer
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	private static final String LASTNAME_TEST_STRING = "Nomtest";
	private static final String LASTNAME_TEST_STRING2 = "Nomtest2";
	private static final String FIRSTNAME_TEST_STRING = "FirstnameTest";
	private static final String FIRSTNAME_TEST_STRING2 = "FirstnameTest2";
	private static final double INITIAL_VALUE_DOUBLE = 2010.50;
	
	private Customer customer = new Customer(LASTNAME_TEST_STRING, FIRSTNAME_TEST_STRING);
	private Account account = new Account(1, customer);
	
	public AccountTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void accountGetIdTest(){
		assertEquals(1, account.getId());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void accountInitialValueAfterConstructTest(){
		assertEquals(0.0, account.getBalance(), 0.0000000001);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void accountInitialValueTest(){
		account.setBalance(INITIAL_VALUE_DOUBLE);
		assertEquals(INITIAL_VALUE_DOUBLE, account.getBalance(), 0.0000000001);
	}
	
	@Test
	public void accountCustomerNotNullTest(){
		assertNotNull(account.getCustomer());
	}
	
	@Test
	public void isValidTransfert(){
		Account accADebit = new Account(1, 1000.0, new Customer("PUCH", "Thierry"));
		Account accACredit = new Account(1, 1000.0, new Customer("BONNET", "Jerome"));
		double amount=190.0;
		
		assertTrue((accADebit.getBalance() > amount));
		
	}
	
	@Test
	public void isNotValidTransfertByAmount(){
		Account accADebit = new Account(1, 1000.0, new Customer("PUCH", "Thierry"));
		Account accACredit = new Account(1, 1000.0, new Customer("BONNET", "Jerome"));
		double amount=1200.0;
		
		assertNotNull(accADebit);
		assertNotNull(accACredit);

		assertFalse((accADebit.getBalance() > amount));
	}
	
}
