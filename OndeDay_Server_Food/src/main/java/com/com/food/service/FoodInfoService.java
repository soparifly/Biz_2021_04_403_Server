package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;

public interface FoodInfoService {
	
	//모두 조회하기
	public List<FoodVO> selectAll();
	
	//날짜값으로 입력하기
	public FoodDTO select(String eat_date);
	
	//섭취정보 등록
	String eatInsert(FoodVO foodVO);
	
}
