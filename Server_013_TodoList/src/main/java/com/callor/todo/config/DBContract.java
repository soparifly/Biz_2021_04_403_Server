package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;

	static {

		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/TodoListDB";
		String username = "tdUser";
		String password = "tdUser";

		try {
			Class.forName(jdbcDriver);

			if (dbConn == null) {

				dbConn = DriverManager.getConnection(url, username, password);

			}
			System.out.println("MySQL 연결 OK!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getDbConn() {
		return dbConn;
	}

}
