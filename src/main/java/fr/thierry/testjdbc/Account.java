package fr.thierry.testjdbc;
import java.util.List;

/**
 * 
 * @author Thierry
 *
 */
public class Account {

	protected int id;
	protected String iban="";
	protected double balance;
	protected Customer customer;
	
	protected RefAccountNumber refAccountNumber ;
	
	
	public Account(int id, double balance, Customer customer) {
		this.account(id, balance, customer);
	}
	
	public Account(int id ,Customer customer){
		this.account(id, 0.0, customer);	
	}
	
	public void account(int id, double balance, Customer customer) {
		this.refAccountNumber = RefAccountNumber.getInstance();
		//this.id = refAccountNumber.getNewId();
		this.id = id;
		this.balance = balance;
		this.customer = customer;
		
		customer.addAccount(this);
	}
	
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}
	
	protected void setIban(String iban) {
		this.iban = iban;
	}
	
	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	protected void setCustomer(Customer customer) {
		this.customer = customer;
	}

	//--------------------------
	/**
	 * setBalance for creditl or debit operations
	 * @param amount
	 * @param addAmount - true => credit / false => debit
	 * @return
	 */
	public double setBalance(double amount, boolean addAmount){
		if (amount <0) {
    		throw new IllegalArgumentException("Invalid amount : " +
					amount +" (must be positive)");
    	}
		this.setBalance(this.getBalance() + ((addAmount)? amount : amount*1.0));
		
		return this.getBalance();
	}
	
    public double debitAccount(double amount){
    	return this.setBalance(amount, false);
    }
    public double creditAccount(double amount){
    	return this.setBalance(amount, false);
    }
    
    public String toString(){
    	return "Number :" +this.getId()+" - Balance : "+this.getBalance()
    	+" - Owner :"+ this.getCustomer().toString();
    	
    }
}
