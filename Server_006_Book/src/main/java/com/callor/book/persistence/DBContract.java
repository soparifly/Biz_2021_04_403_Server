package com.callor.book.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

/*
 * DB 연동을 위한 dbCOnnect 객체를 미리 작성해두고 필요할때 사용할수 있도록 하는 클래스 
 * static class로 생성
 * 클래스에 포함된 필드변수, 멤버 메소드 중 1개라도 스태틱 키워드가 부착도미ㅕㄴ static class가 된다
 * 프로젝트가 Run되는 순간 미리 객체로 생성되어 준비되는 클래스
 */
public class DBContract {

	private static Connection dbConn = null;

//static 으로 선언된 dbConn객체를 초기화 하는 코드
	static {

		String jdbcDriver = "oracle.jdbc.OracleDriver";

		String url = "jdbc:oracle:thin:@10.211.55.3:1521:xe";
		String username = "bookuser";
		String password = "bookuser";

			// Java 1.7 이상에서는 사용하지않아도되는코드
			try {
				Class.forName(jdbcDriver);
				if (dbConn == null) {
					dbConn = DriverManager.getConnection(url, username, password);
				}
				System.out.println("오라클 접속 OK!!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("오라클 Drivcver를 찾을수 없음");
			System.out.println("오라클 ojdbc6.jar를 확인하세요");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			System.out.println("=".repeat(50));
			System.out.println("오라클 DBMS 연결 실패!!");
			System.out.println("접속 정보를 확인하세요!!");
		}

	} //end static
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
