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

import com.com.food.model.FoodVO;
import com.com.food.service.FoodInfoService;
import com.com.food.service.FoodSerivceImplV1;

@WebServlet("/start/insert")
public class InsertController extends HttpServlet {

	protected FoodInfoService fdService;

	public InsertController() {
		fdService = new FoodSerivceImplV1();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset = UTF-8");
		PrintWriter out = resp.getWriter();
		String fd_code = req.getParameter("fd_code");
		req.setAttribute("CODE", fd_code);
		List<FoodVO> inList = new ArrayList<FoodVO>();

		try {
		FoodVO foodVO = new FoodVO();
		foodVO.setEat_date(req.getParameter("eat_date"));
		foodVO.setEat_ccode(req.getParameter("fd_code"));
		foodVO.setEat_order(Integer.valueOf(req.getParameter("eat_order")));
			
		inList.add(foodVO);
			
		fdService.eatInsert(foodVO);
		
		out.println(inList.toString());
		
		} catch (NumberFormatException e) {
			// 섭취량 입력오류시 메시지
			out.println("섭취량은 숫자로만");
		}

		
//		System.out.println("eat_order");

//		req.setAttribute("CODE", fd_code);
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String fd_code = req.getParameter("fd_code");
//		System.out.println(fd_code);
//		String eat_date = req.getParameter("eat_date");
//		System.out.println(eat_date);
//		String eat_order = req.getParameter("eat_order");
//		System.out.println("eat_order");
//		
//		req.setAttribute("CODE", fd_code);
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);

	}

}
