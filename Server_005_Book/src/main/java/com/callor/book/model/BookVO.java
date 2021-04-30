package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class BookVO {

	// table 의 컬럼이름과 같은 방식으로 사용하기
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	//Integer방식이기때문에 0으로 초기화를 시켜주자
	private Integer bk_price = 0;
	private Integer bk_pages = 0;
}
