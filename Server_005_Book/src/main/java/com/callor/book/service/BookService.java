package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;

public interface BookService {
/*
 * DB연동하는 프로젝트에는 필수적으로 구현해야할 method가 있다
 * 
 * 필수 메서드는 반드시 모든 테이블을 기준으로 CRUD를 구현한다
 * 
 * C : create Insert
 * R : Read Select
 * U : Update update()
 * D : Delete delete()
 * 
 */

	//도서 정보 1개를 전달받아서 DB insert를 수행
	// 도서정보데이터는 ISBN, 도서명, 출판사코드, 저자 코드 
	//	발행일, 가격, 페이지의 데이터가 포함된다
	//String isbn  .. acode등등 
	
	//도서 정보 데이터를 1개 전달받아서 DB insert를 수행
	//도서 정보를 VO객체에 담아 전달받아서 DB에 insert수행 
	public void insert(BookVO bookVO);
	
	//도서 정보 데이터를 모두 조회하여 return 하는 기능 수행
	public List<BookDTO> selectAll();
	
	
	
	
	//ISBN을 1개 전달받아서 도서정보 1개를 return하는 기능을 수행할 메서드
	// PK (기본키) 1개만을 전달받아 조회하는 메서드는 0~ 1개의 데이터만 리턴을한다.
	//데이터가 없을때는 Null을, 있을때는 실제 데이터가 담긴 DTO가 리턴된다
	public BookDTO findByID(String bk_isbn);
	
	//도서명을 1개 전달받아서
	//도서명으로 조회를 하고 결과를 return하는 기능을 수행하는 메서드를 만들예정
	public List<BookDTO> findByTitle(String bk_title);
	
	//변경할 도서데이터 1개를 전달 받아서 
	//데이터를 갱신(변경,수정)하는 기능을 수행함
	public void update(BookVO bookVO);
	
	//삭제할 도서의 ISBN을 1개 전달받아서
	//한개의 도서정보를 삭제하는 기능수행
	public void delete(String bk_isbn);
	
	
	
	
	
}
