package com.callor.diet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.service.FoodService;
import com.callor.diet.service.impl.FoodServiceImplV1;
@WebServlet("/food/*")
public class FoodController extends HttpServlet{

	private static final long serialVersionUID = 5430871336219122803L;
	protected FoodService fdService;
	public FoodController() {
		fdService = new FoodServiceImplV1();	}
	 
	//anchor Link를 클릭했을때 처리할 method
	// a tag: <a href>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//food/search라고 요청을 보내면 /search문자열을 추출한다
		String subPath = req.getPathInfo();
		if(subPath==null||subPath.equals("")) {
			System.out.println("요청 subPath없음");
		} else if (subPath.equals("/search")) {
			//식품검색화면보여주기
			ReqController.forward(req, resp, "search");
		}
	}
	
	
	
	//form 에서 input Box에 입력한 데이터를 전송했을때
	//method를 POST로 지정하면 처리할 함수
	//<a href="${pageContext.request.contextPath}/food/search">섭취정보등록</a> home.jsp 에서 "/search" 부분을 처리할 내용
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String subPath = req.getPathInfo();
		if(subPath ==null || subPath.equals("")) {
			System.out.println("요청 subPath가 없음");
			
		} else if(subPath.equals("/search")) {
			//form에 입력된 데이터를 추출(parameter를 Get)하고 DB에서 조회하여 다시 Web에 보여주기
			String f_name =req.getParameter("f_name");
			List<FoodDTO> foodList = fdService.findByFName(f_name);
			
			
			req.setAttribute("FOODS",foodList);
			ReqController.forward(req, resp, "search");
			
			
		}
		

		
	
	}
	

}
