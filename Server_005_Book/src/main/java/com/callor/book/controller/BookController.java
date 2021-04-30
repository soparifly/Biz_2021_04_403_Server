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

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.BookServiceImplV1;

// local:8080/book/book/~~~~ 로 요청을 하면 
//여기에서 수신을 처리하겠다 하는 내용임
@WebServlet("/book/*")
public class BookController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//항상 묶어서사용하는 버릇을 들여야함
	private BookService bService;
	public BookController() {
		bService = new BookServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ~~~로 되어있는 문자열을 추출하기
		// localhost:8080/book/book/input으로 요청하면
		// insert 추출된다
		String subPath = req.getPathInfo();
		// 요청에 응답하기위한 준비
		// 한글 인코딩 세팅
		resp.setContentType("text/html; charset=UTF-8");

		// 데이터를 보낼 명령
		PrintWriter out = resp.getWriter();

		if (subPath.equals("/input")) {
			// 첨부된 폼을 열어서 내용을 확인한다
			String bk_isbn = req.getParameter("bk_isbn");
			String bk_title = req.getParameter("bk_isbn");
			String bk_price = req.getParameter("bk_isbn");

			
			
			
			BookVO bookVO = new BookVO();
			bookVO.setBk_isbn(bk_isbn);
			bookVO.setBk_title(bk_title);
			bookVO.setBk_price(Integer.valueOf(bk_price));
			bookVO.setBk_ccode("C0001");
			bookVO.setBk_acode("A0001");
			bookVO.setBk_date("2019-10-01");
			
			bService.insert(bookVO);
			
			
			
			out.println("받은 데이터 확인");
			out.printf("ISBN : %s ", bk_isbn);
			out.printf("도서명 : %s ", bk_title);
			out.printf("가격: %s ", bk_price);
			out.close();
		} else if(subPath.equals("/select")) {
			
			List<BookDTO> booklist = bService.selectAll();
			
			
		} else if (subPath.endsWith("/isbn")) {
			
			String bk_isbn = req.getParameter("bk_isbn");
			BookDTO bookDTO = bService.findByID(bk_isbn);
			
			
			
			
			ServletContext app = this.getServletContext();
			app.setAttribute("BOOK", bookDTO);
			RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			
			disp.forward(req, resp);
			
			// 컨트롤러시에는 서버를 리스타트해줘야한다
		} else {
			out.println("반갑습니다");
			out.close();
		}

	}

}
