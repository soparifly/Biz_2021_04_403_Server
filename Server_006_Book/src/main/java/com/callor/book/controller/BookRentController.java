package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.Service.BookRentService;
import com.callor.book.Service.BuyerService;
import com.callor.book.Service.impl.BookRentServiceImplV1;
import com.callor.book.Service.impl.BuyerServiceImplV1;
import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.model.BuyerDTO;

@WebServlet("/rent/*")
public class BookRentController extends HttpServlet {

	protected BookRentService brService;
	protected BuyerService buService;

	public BookRentController() {
		brService = new BookRentServiceImplV1(); // new .. 추가하기
		buService = new BuyerServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// rent/* 요청이되면 * 위치에 부착되는
		// Sub요청을 분리해낸다
		// rent/seq라고 요청을하면
		// subPath 에는 /seq라는 문자열이 담길것이다
		String subPath = req.getPathInfo();

		// outputStream 사용하여 문자열방식으로 응답을 하기위한 준비
		resp.setContentType("text/html;charset = UTF-8");

		PrintWriter out = resp.getWriter();
		// rent /seq로 요청이들어오면..
		if (subPath.equals("/seq")) {

			String strSeq = req.getParameter("id");
			if (strSeq == null || strSeq.equals("")) {
				out.println("주문번호가 없음");
				out.close();
			} else {
				Long nSeq = Long.valueOf(strSeq);
				BookRentDTO brDTO = brService.findById(nSeq);
				// view에서 보여줄 데이터 생성
				/*
				 * ServeltContext app Tomcat 기반으로 작성된 Web APP Service 에서 요청 (Req) 응답(Res)를 총괄하는
				 * 정보가 담긴 객체 Web App Service를 구현하기위해 Req, Res를 처리하는 여러가지 기능을 구현해야하는데
				 * 
				 * SeveletContext가 미리구현해놓았기때문에 getter를 하는 것만으로도 충분하다
				 * 
				 * 
				 * DB등으로부터 조회된 데이터를 Web에게 응답하고자 할때 쉬운 방법으로 전달할 수 있도록 구현하는 기능이 미리구현되어있다.
				 * 
				 */
				ServletContext app = this.getServletContext();

				// bService가 return한 brDTO를
				// app객체에 BOOK이라는 속성 변수로 셋팅하기
				// app 객체에 BOOK이라는 객체 변수를 생성하고
				// BookRentDTO BOOK = brDTO이런 형식의 코드가 실행된다
				// 셋팅된 boiok객체변수는 jsp에서 참조하여 값을 표현할수 있다.
				app.setAttribute("BOOK", brDTO);

				// book.jsp파일을 읽어서
				// app에 setting한 book 변수와 함께
				// rendering을 하라
				// webapp/WeB-INF/views/book.jsp파일을 읽어서 java코드로 변환하고, 실행할 준비를 하라.
				RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
				// Rendering 된 view 데이터를
				// Web browser로 response하라
				disp.forward(req, resp);
			}

		} else if (subPath.equals("/list")) {
			// 도서코드로 찾기
			// 도서 대여 전체 목록
			brService.selectAll();
			out.println("도서대여 전체목록 보기");

		} else if (subPath.equals("/isbn")) {

			brService.findByBISBN("isbn");

		} else if (subPath.equals("/buyer")) {
			// 회원코드로 찾기
			brService.findByBuyerCode("buyercode");

			// rent/order 로 요청하면 주문서 작성 처음화면 보여주기
			// 회원이름을 입력하는 화면보여주기
		} else if (subPath.equals("/order")) {

			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/order.jsp");
			disp.forward(req, resp);

		} else if (subPath.equals("/order/page1")) {

			String bu_name = req.getParameter("bu_name");
			if (bu_name == null || bu_name.equals("")) {
				out.println("회원 이름은 반드시 입력해야 합니다.");
				out.close();
			} else {

				List<BuyerDTO> buList = buService.findByName(bu_name);
				System.out.println("=".repeat(50));
				for (BuyerDTO d : buList) {
					System.out.println(d.toString());
				}
				System.out.println("=".repeat(50));
				ServletContext app = req.getServletContext();
				app.setAttribute("BUYERS", buList);

				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/page1.jsp");
				disp.forward(req, resp);
				// 서비스에서 전달된 데이터가 잘나왔는지 확인하는코드

				//
			}

		} else if (subPath.equals("/order/page2")) {

			String bu_code = req.getParameter("bu_code");

			BuyerDTO buyerDTO = buService.findById(bu_code);
			System.out.println(buyerDTO.toString());

			ServletContext app = req.getServletContext();
			app.setAttribute("BUYER", buyerDTO);

			RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/page2.jsp");
			disp.forward(req, resp);

		} else if (subPath.equals("/return")) {
			// 반납하기
			BookRentVO bookRentVO = new BookRentVO();
			brService.update(bookRentVO);
		} else {
			out.println("NOT FOUND");
			out.close();
		}

	}

}
