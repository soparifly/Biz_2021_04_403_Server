package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;

public interface FoodInfoService {
	
	//모두 조회하기
	public List<FoodDTO> selectAll();
	
	//날짜값으로 입력하기
	public FoodDTO findByData(String eat_date);
	
	//섭취정보 등록
	public String eatInsert(FoodVO foodVO);
	
	//식품명으로 조회하기
	public List<FoodDTO> findByFoodName(String name);
	
}
