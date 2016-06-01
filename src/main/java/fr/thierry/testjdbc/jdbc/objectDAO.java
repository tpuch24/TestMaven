package fr.thierry.testjdbc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ObjectDAO {

	ResultSet resultSet;
	ConnectMyBDD myBDD;
	Connection connexion;
	
	public ObjectDAO() {

	}

	protected boolean getResultset(String stSQL){
		Statement statement;
		try {
			 myBDD= ConnectMyBDD.getInstance();
			 connexion = myBDD.getConnection();
				
			statement = connexion.createStatement();
			resultSet = statement.executeQuery(stSQL);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	protected boolean execSQL(String stSQL){
		Statement statement;
		try {
			 myBDD= ConnectMyBDD.getInstance();
			 connexion = myBDD.getConnection();
				
			statement = connexion.createStatement();
			int value = statement.executeUpdate(stSQL);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
