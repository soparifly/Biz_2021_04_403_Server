package com.callor.book.Service;

import java.util.List;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;

public interface BookRentService {
/*
 * 최소한으로 CRUD를 구현하기위한 인터페이스선언
 * 
 */

	
	
	public List<BookRentDTO> selectAll();
	
	//PK값으로 조회하기
	public BookRentDTO findById(Long seq);
//PK값으로 조회되는 것제외하면 모두 리스트형식이다
	
	//도서코드로 대여목록조회
	public List<BookRentDTO> findByBISBN(String isbn);
	
	//도서명으로 대여목록조회
	public List<BookRentDTO> findByBookName(String name);

	//회원코드로 대여먹록조회
	public List<BookRentDTO> findByBuyerCode(String bcode);
	
	//회원명으로 대여목록조회
	public List<BookRentDTO>  findByBuyerName(String bName);
	
	//미반납 대여목록 조회
	//연체자 목록
	public List<BookRentDTO> findByOverDue(String eDate);
	
	//대여 일자를 지정하여 목록조회
	public List<BookRentDTO> findByTerm(String sDate, String eDate);
	/*
	 * prepare...를 통해서 SQL을 실행하면 
	 * CUR가 정상적으로 수행되면 결과값이 정수 1이상이 되돌아오고 
	 * 그렇지 못하면 0값이 되돌아온다
		
	 */
	public int insert(BookRentVO bookRentVO);
	public int update(BookRentVO bookRentVO);
	public int delete(Long seq);
	
}
