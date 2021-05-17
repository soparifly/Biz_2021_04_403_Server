package com.callor.diet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.service.MyFoodService;
import com.callor.diet.service.impl.MyFoodServiceImplV1;
@WebServlet("/") //웹서블릿 루트
public class HomeController extends HttpServlet {

	/**
	 * 경고를 막기위해서 사용함 HomeController 커밋메뉴에서 2번째꺼
	 */
	private static final long serialVersionUID = -953531494441799347L;
	protected MyFoodService mfService;
	 
	public HomeController() {

	mfService = new MyFoodServiceImplV1();
	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//MVC패턴
		//웹브라우저에 접속했을때 최초로 보여줄화면을 설정하는 명령어 
		
		String mf_date = req.getParameter("mf_date");
		List<MyFoodCDTO> mfList = null;
		if(mf_date == null ||  mf_date.equals("")) {
			
			mfList = mfService.selectAll();
		} else {
			
			mfList= mfService.findByDate(mf_date);
			
		}

		req.setAttribute("MFOODS", mfList);
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		ReqController.forward(req, resp, "home");
		
		
	}

	
	
	
}
