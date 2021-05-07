package com.callor.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class menuController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String rootPath = req.getContextPath();
		String id = req.getParameter("id");
		System.out.println(rootPath);
		resp.sendRedirect(rootPath + "/" + id );
		/*
		if (id.equals("buyer")) {
			resp.sendRedirect(rootPath + "/" + id);
		} else if (id.equals("product")) {
			resp.sendRedirect(rootPath + "/" + id); 
		} else if (id.equals("mypage")) {
			resp.sendRedirect(rootPath + "/" + id);
		} else {
			resp.sendRedirect("/hello");
		}
	*/
	}

}
