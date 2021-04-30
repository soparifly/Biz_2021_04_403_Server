package com.callor.db.service;

import java.util.List;

import com.callor.db.model.BookVO;
/*
 * 업무적인 분석이 없이 만드는 DB프로젝트에서는 필수족으로 필요한 메서드가 있다
 * 
 * 이비와 연동되는 프로젝트는 1개의 테이블마다 서비스가 만들어지는데 CRUD를 최소한 구현해야한다
 * 
 */

public interface BookService {
	/*
	 *웹 브라우저에서 데이터를 보내면 컨트롤러에서 데이터를 전달받고 
	 *서비스 클래스에 데이터를 전달하여 디비에 인서트를 수행한다 
	 */
	public void insert(BookVO bookVO);
	/*
	 * 웹에서 데이터를 보여달라는 요청이 있으면
	 * 컨트롤러 서블렛의 셀렉트 메소드를 호출할 것이며
	 * 셀렉트 메서드는 디비로부터 데이터를 읽어서 컨트롤러에게 리턴한다
	 */
	public List<BookVO> selectAll();
	/*
	 *  컨트롤러로 부터 기본키에 해당하는 값 1개를 전달받고
	 *  기본키 컬럼에 조건을 1개만 부여하여 셀렉트한후 데이터를 리턴하는 메소드
	 */
	public BookVO findById(String bk_isbn);
	
	/*
	 * 도서명으로 검색
	 * 도서명을 받아서 
	 * 해당도서명의 모든데이터를 리턴함
	 */
	public List<BookVO> findByTitle(String bk_title);
	/*
	 * 출판사 코드로 검색함
	 */
	public List<BookVO> findByComp(String bk_comp);
	/*
	 * 저자 코드로 검색 발행일로검색, 가격으로검색등
	 */
	
	
	
	/*
	 * 변경하고자하는 데이터를 전달받아서(전달받은 데이터에는 반드시 PK값이 포함되어있어야한다)
	 * pk로 조건을 설정하고 데이터를 update한다
	 *
	 */
	
	
	public void update(BookVO bookVO);
	
	
	/*
	 * 삭제 하고자 하는 데이터의 pk값을 매개변수로 전달받고 
	 *1개의 데이터를 삭제한다
	 */
	
	public void delete(String bk_isbn);
}
