package fr.thierry.testjdbc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.thierry.testjdbc.Account;

/**
 *  DAO for account table in DB
 * @author Thierry
 *
 */
public class AccountDAO extends ObjectDAO{

	
	public AccountDAO() {
		// TODO Auto-generated constructor stub
	}

	//CRUD
	/**
	 * Read an account in DB table
	 * @return an account from DB table
	 */
	public Account readAccountById(int idAccount){
		String stSQL="SELECT * FROM account";
				stSQL+=" where id =" + idAccount;
		Account account = null;
		
		if (getResultset(stSQL)){
			try {
				CustomerDAO  customerDAO = new CustomerDAO();
				if (resultSet.next()) {
					account= new Account(resultSet.getInt("id"),resultSet.getDouble("balance"), customerDAO.getACustomer(resultSet.getString("lastname"), resultSet.getString("firstname")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}
	
	/**
	 * Insert an account in DB table
	 * @return true if ok
	 */
	public boolean insertAccount(Account account){
		String stSQL="INSERT INTO account (iban, balance, firstname, lastname)";
				stSQL+=" VALUES('" + account.getIban()+"', "+ account.getBalance();
				stSQL+=", '"+account.getCustomer().getFirstName()+"'";
				stSQL+=", '"+account.getCustomer().getLastName()+"'";
				stSQL+=");";
		return(execSQL(stSQL));
	}
	
	/**
	 * update an account in DB table
	 * @return true if ok
	 */
	public boolean updateAccount(Account account){
		String stSQL="UPDATE account SET";
				stSQL+=" iban = '" + account.getIban()+"', ";
				stSQL+=" balance = "+ account.getBalance()+", ";
				stSQL+=" firstname = '" + account.getCustomer().getFirstName()+"', ";
				stSQL+=" lastname = '" + account.getCustomer().getLastName()+"'";
				stSQL+=" where id = "+ account.getId()+"';";
				
		return(execSQL(stSQL));
	}
	
	/**
	 * Delete an account in DB table
	 * @return true if ok
	 */
	public boolean deleteAccount(Account account){
		String stSQL="DELETE FROM where id= "+account.getId();
				stSQL+=";";
		return(execSQL(stSQL));
	}
	
	//Others
	
	/**
	 * Get all account in DB table
	 * @return list of all bank in DB table
	 */
	public List<Account> getAccountList(){
		String stSQL="SELECT * FROM account;";
		List<Account> myList = new ArrayList<Account>();
		
		getResultset(stSQL);
				
		try {
			CustomerDAO  customerDAO = new CustomerDAO();
			while (resultSet.next()) {
				myList.add(new Account(resultSet.getInt("id"), resultSet.getDouble("balance"), customerDAO.getACustomer(resultSet.getString("lastname"), resultSet.getString("firstname"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myList;
	}
	
	public boolean muteAmount(Account debit, Account credit, double amount){
		
		if ((debit==null) || (credit==null)) return false;	
		if (amount > debit.getBalance()) return false;
		
		debit.debitAccount(amount);
		credit.creditAccount(amount);
		
		//Ininterrupt mode (Transaction)
		try {
			connexion.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if ((updateAccount(debit)) && (updateAccount(credit))){
			try {
				connexion.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		else {
			try {
				connexion.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
}
