package com.soparifly.guest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	
	private static Connection dbConn;
	
	static {
		
		String jdbcDriver ="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://192.168.219.103:3306/GuestBook";
		String username ="gbUser";
		String password ="gbUser";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				
				dbConn = DriverManager.getConnection(url, username, password);
				
			}
			System.out.println("- MySQL Connection complete -");
			
		} catch (ClassNotFoundException e) {
			System.out.println("접속 실패 ! jstl driver 를 확인하세요!");
		} catch (SQLException e) {
			System.out.println("-".repeat(30));
			System.out.println("mysql 접속에 실패했습니다 접속정보를 확인하세");
			System.out.println("jdbcDriver : " + jdbcDriver);
			System.out.println("url : " + url);
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			System.out.println("-".repeat(30));
		}
		
		
	}
	public static Connection getConnection() {
		return dbConn;
	}
}
