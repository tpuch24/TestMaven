package fr.thierry.testjdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMyBDD {

	private static ConnectMyBDD myConnection;
	private Connection connection=null;
	protected String url="jdbc:postgresql://localhost:5432/formhb";
	protected String login="tp24";
	protected String passwd="2491";
	
	
	private ConnectMyBDD() {
		// TODO Auto-generated constructor stub
		
		try {
				connection = DriverManager.getConnection(url, login, passwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 	
		
	public static ConnectMyBDD getInstance(){
		if (myConnection== null){
			myConnection = new ConnectMyBDD();
		}
		return myConnection;
	}
 
	public Connection getConnection(){
		return connection;

	}
	
	public void closeInstance(){
		if (myConnection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
