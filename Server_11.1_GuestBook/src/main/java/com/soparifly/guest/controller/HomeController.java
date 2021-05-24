package com.soparifly.guest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soparifly.guest.model.GuestBookVO;
import com.soparifly.guest.service.GuestBookService;
import com.soparifly.guest.service.impl.GuestBookImplV2;
@WebServlet("/")
public class HomeController extends HttpServlet{

	protected GuestBookService gbService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8709985257237196572L;
	
	public HomeController() {
		gbService = new GuestBookImplV2();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<GuestBookVO> gbList = gbService.selectAll();
		req.setAttribute("GBLIST", gbList);
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		RequestForwardController.forward(req, resp, "home");
	}
	
	
	
	

}
