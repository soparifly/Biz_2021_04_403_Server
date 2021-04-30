package com.callor.db.model;

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
	
	//DB와 연동하는 프로젝트에서는
	//코딩의 혼란을 줄이기 위해서
	// sanke case로 VO 변수를 선언한다
	
		private String bk_isbn;
		private String bk_title;
		private String bk_ccode;
		private String bk_acode;
		private String bk_date;
		
		
		private Integer bk_price =0;
		private Integer bk_pages =0;
}
