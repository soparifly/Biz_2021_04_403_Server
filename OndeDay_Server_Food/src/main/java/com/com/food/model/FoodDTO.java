package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodDTO {

//상품정보 DTO

//	섭취날짜, 식품명, 내가섭취한량, 총내용량, 회당제공량, 칼로리, 단백질, 지방량, 탄수화물, 총당

	private String cb_name; //fd_분류명
	private String fd_code; //상품코드
	private String cp_name; // 회사명
	private String fd_name; //상품명
	private int fd_order; //회당제공량
	private int fd_weight; //총내용량
	private int fd_kcal; //칼로리
	private int fd_dan; //단백질
	private int fd_gi; //지방
	private int fd_tan; //탄수화물
	private int fd_dang; //당

}
