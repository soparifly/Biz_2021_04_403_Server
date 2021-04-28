package com.callor.wellcome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("여기는 book Controller");
		//<a href='http://localhost:8080/welcome/book'> Book으로</a>
		out.println("<a href = '");
		out.println("http://localhost");
		out.println(":8080");
		out.println("/welcome/home'>");
		out.println("홈으로</a>");
		out.close();
	
	}
	
	
	

	
	
}
