package com.callor.guest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

	
	
	private static Connection dbConn;
	
	
	static {
		
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String url  = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "username";
		String password = "password";

		try {
			Class.forName(jdbcDriver);
			if(dbConn.equals(null)) {
				dbConn = DriverManager.getConnection(url, username, password);
				
			}
		} catch (ClassNotFoundException e) {

			System.out.println("odbc6.jar를 찾을수 없습니다.!!");
		} catch (SQLException e) {
			
		
		}
	}
}
