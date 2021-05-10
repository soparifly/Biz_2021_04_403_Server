package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FoodVO {
	
	private String eat_seq; //primary key
	private String eat_date;	//VARCHAR2(10)	
	private String eat_ccode;	//CHAR(7)	NOT NULL
	private int eat_order = 0;	//NUMBER	

}
