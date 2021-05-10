package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

	// 보여줄 정보

//	섭취날짜, 식품명, 내가섭취한량, 총내용량, 회당제공량, 칼로리, 단백질, 지방량, 탄수화물, 총당

//	private String eat_date;
//	private String fd_name;
//	private String eat_order;
//	private String fd_weight;
//	private String fd_order;
//	private int fd_kcal = 0;
//	private int fd_dan = 0;
//	private int fd_gi = 0;
//	private int fd_tan = 0;
//	private int fd_dang = 0;
	private Long eat_seq;
	private String eat_date;
	private String fd_code;// CHAR(7)
	private String fd_name;// nVARCHAR2(200)
	private int fd_order = 0; // NUMBER
	private int fd_weight = 0; // NUMBER
	private int fd_kcal = 0; // NUMBER
	private int fd_dan = 0; // NUMBER
	private int fd_gi = 0; // NUMBER
	private int fd_tan = 0; // NUMBER
	private int fd_dang = 0; // NUMBER

}
