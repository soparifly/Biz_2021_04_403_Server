package com.callor.diet.model;
/*
 * VO클래스는 Insert, Update를 수행할때
 * 사용자 (WEB)가 입력한 (전달받은) 값을 담을 객체 
 */

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

public class MyFoodVO {
	private Long mf_seq;
	private String mf_date;
	private String mf_fcode;
	private Float mf_amt;
}
