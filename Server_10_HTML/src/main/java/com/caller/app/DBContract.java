package com.caller.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;

	static {

		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "";
		String password = "";
		if (dbConn == null) {
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url, username, password);
				System.out.println(" oracle 접속완료!! ");
			} catch (ClassNotFoundException e) {

				System.out.println("오라클 드라이버 찾을수 없음!! ojdbc6 확인하세요!");

			} catch (SQLException e) {

				System.out.println("=".repeat(30));
				System.out.println(jdbcDriver);
				System.out.println("Driver :" + jdbcDriver);
				System.out.println("url :  " + url);
				System.out.println("username : " + username);
				System.out.println("password : " + password);

				System.out.println("=".repeat(30));
				System.out.println(" 접속 정보를 확인하세요 ");
			}
		}
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}

}
