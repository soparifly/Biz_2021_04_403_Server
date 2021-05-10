package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/")
public class MainController extends HttpServlet {
	
	protected FoodInfoService fdService;
	
	public MainController() {

		fdService = new FoodSerivceImplV1();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();
		resp.setContentType("Text/html;charset = UTF-8");
		List<FoodVO> FoodList = fdService.selectAll(); 
		
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/select")) {
			//상품명받기
			out.println("상품명을 검색합니다");
			String fd_name = req.getParameter("fd_name");
			
			FoodDTO foodDTO = fdService.select("fd_name");
			
			ServletContext app = this.getServletContext();
			
			app.setAttribute("FOOD", foodDTO);
			
			req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
			
			
			
			
			
		} else if(subPath.equals("/insert")) {
		}

		}
		
		
	}

