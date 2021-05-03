package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.Service.BookRentService;
import com.callor.book.Service.impl.BookRentServiceImplV1;
import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;

@WebServlet("/rent/*")
public class BookRentController extends HttpServlet {

	protected BookRentService brService;

	public BookRentController() {
		brService = new BookRentServiceImplV1(); // new .. 추가하기
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();

		resp.setContentType("text/html;charset = UTF-8");

		PrintWriter out = resp.getWriter();
		

		if (subPath.equals("/list")) {
			// 도서 대여 전체 목록
			brService.selectAll();
			out.println("도서대여 전체목록 보기");
		} else if (subPath.equals("/seq")) {
		
			String strSeq = req.getParameter("id");
			Long nSeq = Long.valueOf(strSeq);
			BookRentDTO brDTO = brService.findById(nSeq);
			
			ServletContext app = this.getServletContext();
			// bService가 return한 brDTO를 
			//app객체에  BOOK이라는 속성 변수로 셋팅하기
			app.setAttribute("BOOK", brDTO);
			//book.jsp파일을 읽어서
			//app에 setting한 book 변수와 함께
			//rendering을 하라
			RequestDispatcher disp
			= app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			//Rendering 된 view 데이터를
			//Web browser로 response하라
			disp.forward(req, resp);
			
			// 도서코드로 찾기
		} else if (subPath.equals("/buyer")) {
			// 회원코드로 찾기
			brService.findByBuyerCode("buyercode");
		} else if (subPath.equals("/rent")) {
			BookRentVO bookRentVO = new BookRentVO();
			// 대여정보추가
			brService.insert(bookRentVO);
		} else if (subPath.equals("/return")) {
			// 반납하기
			BookRentVO bookRentVO = new BookRentVO();
			brService.update(bookRentVO);
		} else {
			// 더이상 그만하기
		}
		
		

	}

}
