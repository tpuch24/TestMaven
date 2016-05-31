package fr.thierry.testjdbc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.thierry.testjdbc.Bank;
import fr.thierry.testjdbc.Customer;

/**
 *  DAO for Customer table in DB
 * @author Thierry
 *
 *@
 */
public class CustomerDAO extends objectDAO{
	
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get all Customer in DB table
	 * @return list of all Customer in DB table
	 */
	public List<Customer> getCustomerList(){
		String stSQL="SELECT * FROM customer;";
		List<Customer> myList = new ArrayList<Customer>();
			
		if (getResultset(stSQL)){		
			try {
				while (resultSet.next()) {
					myList.add(new Customer(resultSet.getString("lastname"),resultSet.getString("firstname")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myList;
	}
	
	/**
	 * Get a Customer in DB table
	 * @return a customer
	 */
	public Customer getACustomer(String lastname, String firstname){
		String stSQL="SELECT * FROM customer";
		stSQL+= " where firstname = '"+firstname+"' and lastname = '"+lastname+"';";
		Customer customer = null;
			
		if (getResultset(stSQL)){					
			try {
				if (resultSet.next()) {
					customer = new Customer(resultSet.getString("lastname"),resultSet.getString("firstname"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return customer;
	}
	
}
