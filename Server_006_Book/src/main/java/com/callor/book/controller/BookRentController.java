package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.model.BuyerDTO;
import com.callor.book.Service.BookRentService;
import com.callor.book.Service.BookService;
import com.callor.book.Service.BuyerService;
import com.callor.book.Service.impl.BookRentServiceImplV1;
import com.callor.book.Service.impl.BookServiceImplV1;
import com.callor.book.Service.impl.BuyerServiceImplV1;

@WebServlet("/rent/*")
public class BookRentController extends HttpServlet {
	
	private static final long serialVersionUID = 921652892464670154L;

	protected BookRentService brService;
	protected BuyerService buService;
	protected BookService bkService;
	

	public BookRentController() {
		brService = new BookRentServiceImplV1(); // new .. 추가하기
		buService = new BuyerServiceImplV1();
		bkService = new BookServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// rent/* 요청이되면 * 위치에 부착되는
		
		// Sub요청을 분리해낸다
		// rent/seq라고 요청을하면
		// subPath 에는 /seq라는 문자열이 담길것이다
		String subPath = req.getPathInfo();
//		System.out.println(subPath);

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
				RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/order_info.jsp");
				
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
			// ┌>page1.jsp의 bu_name
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
				// ServletContext를 생성하여 속성(변수)셋팅하기
				ServletContext app = req.getServletContext();
				// BUYERS에 BUlist를 담음
				app.setAttribute("BUYERS", buList);

//				RequestDispatcher disp =req.setAttribute("BUYER", buList);

				// page1.jsp파일을 열고 BUYERS변수와 함께
				// Rendering을 하여 HTML 코드를 생성하라
				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/page1.jsp");
				disp.forward(req, resp);
				// 서비스에서 전달된 데이터가 잘나왔는지 확인하는코드

				//
			}
			
		} else if (subPath.equals("/order/page2")) {

			String bu_code = req.getParameter("bu_code");
			// bu_code값에 해당하는 회원정보 추출
			BuyerDTO buyerDTO = buService.findById(bu_code);
			if (buyerDTO != null) {
				// bu_code값에 해당하는 정보가 있으면 콘설에 출력하라
				System.out.println(buyerDTO.toString());
			}
			ServletContext app = req.getServletContext();
			app.setAttribute("BUYER", buyerDTO);
			// BUYER에 담긴 회원정보를 page2.jsp에 Rendering 하여 보여라
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/page2.jsp");
			disp.forward(req, resp);
			
			
		} else if (subPath.equals("/order/book")) {
			String bu_code = req.getParameter("bu_code");
			String bk_title = req.getParameter("bk_title");
			
			if(bk_title == null || bk_title.equals("")) {
				out.println("도서명을 입력하세요");
				out.close();
				
			} else {
				//회원정보를 한번더 조회
					BuyerDTO buDTO = buService.findById(bu_code);
					req.setAttribute("BUYER", buDTO);
					

				List<BookDTO> bookList
				=bkService.findByTitle(bk_title);
				
				req.setAttribute("BOOKS", bookList);
				
				req.getRequestDispatcher("/WEB-INF/views/book.jsp").forward(req, resp);
			}
//			
//		} else if (subPath.equals("/order_info.jsp")) {
//				
//				brService.insert(null);
		
		} else if(subPath.equals("/order/insert")) {
			String bk_isbn = req.getParameter("bk_isbn");
			String bu_code = req.getParameter("bu_code");
			
			// 대여일자값을 생성하기 위하여
						// 날짜클래스와 날짜포멧클래스를 사용하여
						// 대여일자 문자열 만들기
			//INSert 를 수행하기 위해 
			//vo를 만들고 web에서 전달받은 도서 isbn과 회원 code 를 Setting
			Date date = new Date( System.currentTimeMillis()); //현재 시스템 날짜 가져오기
			//날짜 데이터를 문자열로 변환하기 위한 설정
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			
			//날짜 데이터를 설정한 포멧대로 문자열로 변환
			String sDate = sd.format(date);
			System.out.println("대여일자 : " + sDate);
			// INSERT 를 수행하기 위해
						// VO를 만들고 web에서 전달받은
						// 도서ISBN과 회원CODE를 Setting
			
			
			BookRentVO brVO = new BookRentVO();
			brVO.setBr_sdate(sDate);
			brVO.setBr_isbn(bk_isbn);
			brVO.setBr_bcode(bu_code);
			brVO.setBr_price(1000);
			
			int result = brService.insert(brVO);
			if(result > 0 ) {
//				out.println( "대여정보 추가 성공!!");
				resp.sendRedirect("/book/");
			} else {
				resp.sendRedirect("/book/order");
			}
			out.close();
			
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
