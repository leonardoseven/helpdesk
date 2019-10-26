package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverFactory {
	
	
	private DriverFactory () {
		getConnection();
	}
	
	private static Connection con;
	
	public static Connection getInstance() {
		if(con == null) {
			new DriverFactory();
		}
		return con;
	}
	
	

	private void getConnection() {		
		String url = "jdbc:mysql://localhost/spmhelp";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
