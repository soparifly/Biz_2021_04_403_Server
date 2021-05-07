package com.callor.menu.contorller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Web에서 /hello/rent/~~ 또는 /hello/rent/insert 등과 같이 
 * subPath가 있는 상태로 요청을 하면 응답하도록 설정
 * 
 * 
 */
@WebServlet("/rent/*")
public class BookRentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// rent/ ~~ 를 요청하면 
		//~~부분의 문자열을 분리하여 추출하는 메서드
		String subPath = req.getPathInfo();
		System.out.println("subPath :  "+ subPath);
	
		req.getRequestDispatcher("/WEB-INF/views/rent.jsp")
		.forward(req,resp);
	}

}
