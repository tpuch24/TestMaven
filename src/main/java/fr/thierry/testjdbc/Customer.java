package fr.thierry.testjdbc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Thierry
 *
 */
public class Customer {
	
	protected String lastName;
	protected String firstName;
	protected List<Account> accounts = new ArrayList<Account>();

	public Customer(String lastName, String firstName) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
	}

	//Getters & Setters
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	protected List<Account> getAccounts() {
		return accounts;
	}

	protected void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	//-----------------------------------------
	// Others
	//-----------------------------------------
	public String getCompletName() {
		return lastName+" "+firstName;
	}
	
	public void addAccount(Account account){
		this.accounts.add(account);
	}
	public void deleteAccount(Account account){
		this.accounts.remove(account);
	}

	public String toString(){
		String output = this.getCompletName();
		for( Iterator<Account> i = this.accounts.iterator(); i.hasNext(); ) {
			Account account = (Account) i.next();
			output+=" - "+account.getId();
		}
				
		return output;
	}
}
