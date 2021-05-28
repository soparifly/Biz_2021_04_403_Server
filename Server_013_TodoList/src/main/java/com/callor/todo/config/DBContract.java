package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * 
 * MySQL을 연동하기 위한 클래스
 * cj가 붙어잇는 친구는 mysql의 최신버젼이기때문에 사용함
 * 스키마가 데이터 베이스라는 개념으로 되어있기때문에 오라클하고 차이가있다. 
 *  user, pass는 접속 하기 위한 개념
 *  그에반해 오라클은 유저의 개념이 스키마이다 그렇기때문에 유저 비밀번호가 중요하고
 *  mysql은 DB명이 중요하다
 *  
 *  <싱글톤패턴>
 *  자원(Resource:하드웨어장치, 네트워크 , 파일)을 코드에서 활용할때는 
 *  최소한의 연결을 하여 사용하는것이 여러모로 좋다 
 *  데이터베이스 서버와 네트웍을 통해서 자료를 주고받는 상황이다
 *  이럴때 필요한 연결 객체를 1개만 선언하고 , 공용으로 사용하는 방법 
 *  동시에 얼마나 많은사람이 접속해서 소스를 사용할지 모른다 
 *  접속할때마다 소스를 만들어사용한다면 과부하가 쉽낟
 *  그래서 한개만 만들어놓고 필요할때마다 사용하는것을 싱글톤패턴이라고한다
 *  아래항목에서 static이 그런이유에서 사용한다
 *  
 */
public class DBContract {
	
	private static Connection dbConn;
	private static final Logger log = LoggerFactory.getLogger("DB");
	/*
	 * static초기화 블럭
	 * 스태틱으로 선언된 변수나 객체를 프로젝트가 시작될때 자동으로 생성하는 코드를
	 * 작성하는 부분 
	 * 
	 * Connection 객체인 dbConn을 사용할 준비를 하기
	 * DB Server와 연동을 시작하여 연결 session을 생성
	 * 필요할때 get() 메서드를 통하여 제공해준다.
	 */
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
		log.debug("MySQL 연결 OK!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//private static으로 선언된 변수, 객체를 다른곳에서 사용할 수 있도록 제공하는 메소드
	// => get Instance method
//	Instance: 사용준비 (생성된, 초기화된 객체)
	public static Connection getDbConn() {
		return dbConn;
	}

}
