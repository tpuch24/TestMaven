package fr.thierry.testjdbc;

import java.util.List;

import fr.thierry.testjdbc.jdbc.AccountDAO;
import fr.thierry.testjdbc.jdbc.BankDAO;
import fr.thierry.testjdbc.jdbc.ConnectMyBDD;
import fr.thierry.testjdbc.jdbc.CustomerDAO;

/**
 * Class for testing jdbc objects
 * @author Thierry
 *
 */
public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Entry point for test jdbc application
	 * @param args
	 */
	public static void main(String[] args) {

		BankDAO  bankDAO = new BankDAO();
		CustomerDAO  customerDAO = new CustomerDAO();
		AccountDAO  accountDAO = new AccountDAO();
		
		
		List<Bank> lBank = bankDAO.getBankList();
		List<Customer> lCustomer = customerDAO.getCustomerList();
		List<Account> lAccount = accountDAO.getAccountList();
		
		System.out.println(lBank.toString());
		System.out.println(lCustomer.toString());
		System.out.println(lAccount.toString());
		
		Customer aDebiter = customerDAO.getACustomer("PUCH", "Thierry");
		Customer aCrediter = customerDAO.getACustomer("BONNET", "Jerome");
		Double montant = 200.0;

		//Close connection
		ConnectMyBDD myBDD = ConnectMyBDD.getInstance();
		myBDD.closeInstance();
	}

}