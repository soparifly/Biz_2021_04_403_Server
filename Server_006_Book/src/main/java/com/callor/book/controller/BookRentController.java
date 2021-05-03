package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.Service.BookRentService;
import com.callor.book.Service.impl.BookRentServiceImplV1;
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
		} else if (subPath.equals("/isbn")) {
		
			// 도서코드로 찾기
			brService.findByBISBN("isbn");
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
