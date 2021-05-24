package com.soparifly.guest.service;

import java.util.List;

import com.soparifly.guest.model.GuestBookVO;

public interface GuestBookService {
	//모든정보,아이디로찾
	public List<GuestBookVO> selectAll();
	public GuestBookVO findById(Long seq);
	//작성자로찾기,날짜로찾기,내용으로찾
	public List<GuestBookVO> findByWriter(String gb_writer);
	public List<GuestBookVO> findByDate(String gb_date);
	public List<GuestBookVO> findByContext(String gb_text);
	//CRU
	public Integer INSERT(GuestBookVO gbVO);
	public Integer UPDATE(GuestBookVO gbVO);
	public Integer DELETE(Long seq);
	
	
}
