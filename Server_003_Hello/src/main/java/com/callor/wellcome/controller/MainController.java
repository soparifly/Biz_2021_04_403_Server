package com.callor.wellcome.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/*
 * Controller : Web Servcer App에서
 * Web Application Service(Was): 서비스 개념
 * Web application Ser(WAS) :소프트 웨어 , 시스템
 * 
 * 
 * Requewst를 제일먼저 받는 main class이다
 * class이름은 중요하지않다
 */




//WebSrvlet Annotation
//지금부터 이클래스로 생성된 객체는
//Web Service에서 Request를 처리할 객체이다 라는 선언
//main() method의 역할을 한다
//실제 Request를 처리하기 위해서는 많은 코드를 작성해야한다
//그런데 Network과 관련된 코드는 너무 복잡하고 다양한기술을 
//요구하기 때문에 코드를 직접작성하는것은
//너무 어렵다
//java에서 제공하는 JDK를 상속받아서 대부분의 기능을 처리하고
//꼭 필요한 기능만 구현을 하게된다
//WebServlet Annotation  을 가지고있는 클래스는
//Tomcat에 의해서 관리되고
//사용자의 Request에 따라 Tomcat이 클래스의 method를 
//호출하고 기능을 수행한다

//만약 사용자가 htt://localhost:8080/welcome/home라고 요청을 하면
//1.현재 컴퓨터에서 시작한 tomcat이 응답을 수신 받는다
// 		http://localhost:8080 : tomcat을 호출하는 request
//2. tomcat이후에 보내지는 문자열을 분석하기 시작한다
//		/welcome부분을 분석하여 Run As Server로 시작된 프로젝트 중에서
// 		root Context가 welcome인 프로젝트를 찾는다.
//3. 프로젝트가 있으면 /home 문자열을 다시 분석하여 프로젝트 내의 클래스 중에서 
// @webServlet("/home") Annotation으로 설정된 클래스를 찾는다
//4. 클래스내의 doGet(...) method를 호출한다.
//5. doGet() method의 코드를 재정의(Overrideing)하여 서비스를 구현하게된다 .

@WebServlet ("/home")
public class MainController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("여기는 home Controller");
		out.println("<a href = '");
		out.println("http://localhost");
		out.println(":8080");
		out.println("/welcome/book'>");
		out.println("북으로</a>");
		out.close();
	
	}
	

}
