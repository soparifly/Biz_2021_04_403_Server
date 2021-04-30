package com.callor.db.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet ("/Book/*")
public class BookController extends HttpServlet{
	
	
	private BookService bService;
	public BookController();
	
	bService = new BookServiceImplV1();
	
	

}
