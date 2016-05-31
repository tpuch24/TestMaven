package fr.thierry.testjdbc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Thierry
 *
 */
public class Bank {

	protected String name;
	protected List<Account> accounts;
	protected List<Customer> customers;
	
	/**
	 * Constructor by name 
	 * @param bankName
	 */
	public Bank(String bankName) {
		super();
		
		if (bankName.length() <= 2) {
			throw new IllegalArgumentException("Invalid bank name : " +
					bankName+" (At least 3 digits)");
			}
		this.name = bankName;
		this.accounts = new ArrayList<Account>();
		this.customers = new ArrayList<Customer>();
		
	}

	//Getters & Setters
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected List<Account> getAccounts() {
		return accounts;
	}


	protected void setAccounts(List<Account> bankAccounts) {
		this.accounts = bankAccounts;
	}


	protected List<Customer> getCustomers() {
		return customers;
	}


	protected void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	//-----------------------------------
	//Other Methods
	//-----------------------------------
	
	/**
	 *  Get/ Found customer in customers list bank's by name
	 * @param lastName
	 * @param firstName
	 * @return
	 */
	public Customer getCustomer(String lastName, String firstName){
	
		for( Iterator<Customer> i = this.customers.iterator(); i.hasNext(); ) {
			Customer customer = (Customer) i.next();
			if ((customer.getFirstName()==firstName)&& (customer.getLastName()==lastName)){
				return customer;
			}
		}
		return null;
	}
	
	/**
	 * Get/ Found account in accounts bank's list by id
	 * @param refAccount
	 * @return
	 */
	public Account getAccount(int refAccount){
		
		for( Iterator<Account> i = this.accounts.iterator(); i.hasNext(); ) {
			Account account = (Account) i.next();
			if (account.getId()==refAccount){
				return account;
			}
		}
		return null;
	}
	/**
	 * add in customers bank's list from existant customer
	 * @param customer
	 */
	public void addNewCustomer(Customer customer){
		this.customers.add(customer);
	}
	/**
	 * add in customers bank's list from new customer by name
	 * @param lastName
	 * @param firstName
	 */
	public void addNewCustomer(String lastName, String firstName){
		this.customers.add(new Customer(lastName, firstName));
	}
	/**
	 * delete in customers bank's list by name
	 * @param lastName
	 * @param firstName
	 */
	public void deleteCustomer(String lastName, String firstName){
		this.deleteCustomer(this.getCustomer(lastName, firstName));
	}
	/**
	 * delete in customers bank's list by customer object
	 * @param customer
	 */
	public void deleteCustomer(Customer customer){
		this.customers.remove(customer);
	}
	/**
	 * Make a new account by customer and initial value
	 * @param customer
	 * @param initialValue
	 */
	public void makeAccount(int id, Customer customer, double initialValue){	
		accounts.add(new Account(id, initialValue, customer));	
	}

	/**
	 * 
	 * @param lastName
	 * @param firstName
	 */
	public void makeAccount(int id, String lastName, String firstName ){	
		makeAccount(id, lastName, firstName, 0.0 );
	}
	/**
	 * 
	 * @param lastName
	 * @param firstName
	 * @param initialValue
	 */
	public void makeAccount(int id, String lastName, String firstName, double initialValue ){	
		
		Customer customer = this.getCustomer(lastName, firstName);
		if (customer == null) customer = new Customer(lastName, firstName);
		makeAccount(id, customer,initialValue);
	}
	/**
	 * Close an account in bank
	 * @param account
	 */
	public void closeAccount(Account account){
		this.accounts.remove(account);
	}
	
	public void closeAccount(int refAccount){
		this.accounts.remove(getAccount(refAccount));
	}
	
	public String toString(){
		return getName()+" - "+getCustomers().toString()+" - "+getAccounts().toString();
	}
	
}
