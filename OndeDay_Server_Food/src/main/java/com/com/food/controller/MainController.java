package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.service.FoodInfoService;
import com.com.food.service.FoodSerivceImplV1;
import com.sun.net.httpserver.Authenticator.Result;

@WebServlet("/")
public class MainController extends HttpServlet {
	
	protected FoodInfoService fdService;
	
	public MainController() {

		fdService = new FoodSerivceImplV1();

	}
		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset = UTF-8");
		String fd_name =req.getParameter("fd_name");
		FoodDTO fdDTO = fdService.findByData(fd_name);
		String subPath = req.getPathInfo();
		PrintWriter out = resp.getWriter();
		ServletContext app = this.getServletContext();
		app.setAttribute("FOOD", fdDTO);
		RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/home.jsp");
	}

}