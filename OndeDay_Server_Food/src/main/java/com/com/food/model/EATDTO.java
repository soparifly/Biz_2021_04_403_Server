package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EATDTO {

	private int eat_seq; // EAT_SEQ
	private String eat_data;// 섭취일
	private String eat_name;// 식품명
	private String eat_code;// 식품코드
	private int eat_order;// 회제공량
	private int eat_weight;// 총제공량
	private int eat_oweight;// 내가섭취한량
	private int eat_kcal;// 에너지
	private int eat_dan;// 단백질
	private int eat_gi;// 지방량
	private int eat_tan;// 탄수화물
	private int eat_dang;// 총당

}
