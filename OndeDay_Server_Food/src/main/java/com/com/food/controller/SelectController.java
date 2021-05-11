package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.service.FoodInfoService;
import com.com.food.service.FoodSerivceImplV1;

@WebServlet("/start")
public class SelectController extends HttpServlet {

	protected FoodInfoService fdService;
	
	public SelectController() {
		fdService = new FoodSerivceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/start.jsp").forward(req, resp);		
		resp.setContentType("text/html;charset = UTF-8");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset = UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String fd_name = req.getParameter("fd_name");
		if(fd_name.equals("")&&fd_name.equals(null)) {
			PrintWriter out = resp.getWriter();
			out.println("입력값이 없습니다");
		} else {
			List<FoodDTO> fdList = new ArrayList<FoodDTO>();
			System.out.println("입력한 값" + fd_name);
			System.out.println("목록찾습니다");
			fdList = fdService.findByFoodName(fd_name);
		

			req.setAttribute("FOODS", fdList);
			req.getRequestDispatcher("/WEB-INF/views/start.jsp").forward(req, resp);
		}
//		String subPath = req.getPathInfo();


	}
	
}
