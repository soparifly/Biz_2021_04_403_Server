package com.com.food.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn = null;

	static {
		String jdbcDriver = "oracle:jdbc:Oracledriver";
		String url = "jdbc.oracle.thin@localhost:1521:xe";

		String username = "food";
		String password = "food";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("오라클 접속 ok");
		} catch (SQLException e) {
			System.out.println("오라클 Driver를 찾을수 없음");
			System.out.println("오라클 ojdbc6.jar찾을수 없음.");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 DBMS를 확인하세요");
			System.out.println("오라클 ");
		}

	}

	public static Connection getDBConnection() {
		return dbConn;
	}
}