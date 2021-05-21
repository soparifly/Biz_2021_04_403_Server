package com.callor.maven.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBConnection {

	private static Connection dbConn;

	static {

		String jdbcDriver = "";
		String url = "";
		String username = "";
		String password = "";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}

			System.out.println("MySQL Connection sucess!!");
		} catch (ClassNotFoundException e) {
			System.out.println("=".repeat(50));
			System.out.println("JDBC드라이버를 확인하세요");
			System.out.println();
		} catch (SQLException e) {
			System.out.println("mysql 접속실패 계정정보를 확인하세요");
			System.out.println("=".repeat(50));
			System.out.println("jdbcDriver : " + jdbcDriver);
			System.out.println("url : " + url);
			System.out.println("username: " + username);
			System.out.println("password: " + password);
		}

	}

}
