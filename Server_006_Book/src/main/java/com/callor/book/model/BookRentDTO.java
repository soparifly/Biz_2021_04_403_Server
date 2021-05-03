package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * 대여일	VARCHAR2(10)
 * 회원코드	CHAR(5)
 * 회원명	NVARCHAR2(50)
 * 회원연락처	VARCHAR2(20)
 * ISBN	CHAR(13)
 * 도서명	NVARCHAR2(125)
 * 반납일	VARCHAR2(10)
 * 대여금	NUMBER
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class BookRentDTO {


	private Long br_seq = 0L;
	private String br_bcode;
	private String br_bname;
	private String br_tel;
	private String br_isbn;
	private String br_title;
	private String br_edate;
	private Integer br_price = 0;
	private String br_sdate;
}
