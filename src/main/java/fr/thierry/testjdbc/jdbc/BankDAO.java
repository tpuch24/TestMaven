package fr.thierry.testjdbc.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.thierry.testjdbc.Bank;

/**
 *  DAO for bank table in DB
 * @author Thierry
 *
 *@
 */
public class BankDAO extends objectDAO {
	
	public BankDAO(){
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get all bank in DB table
	 * @return list of all bank in DB table
	 */
	public List<Bank> getBankList(){
		String stSQL="SELECT * FROM bank;";
		List<Bank> myList = new ArrayList<Bank>();
		
		if(getResultset(stSQL)){					
			try {
				while (resultSet.next()) {
					myList.add(new Bank(resultSet.getString("bank_name")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return myList;
		
	}
}
