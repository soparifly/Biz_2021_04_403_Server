package com.callor.todo.exec;

import java.util.HashMap;
import java.util.Map;

public class Map_01 {

	/*
	 * Map<K,V>
	 * List 데이터와 함께 Java에서 매우 많이 사용되는 자료구조
	 * 
	 * Key , Value형식으로 데이터를 저장하고
	 * 읽을 수 있는 자료구조 
	 * 
	 * Ex>
	 * List Type
	 * list.add(값)  : list요소 추가하기
	 * list.get(index) : list요소 읽기
	 * 
	 * Map Type
	 * map.put(key,값): Map에서 데이터 저장
	 * map.get(key) :  Map에서 값을 읽기
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map은 인터페이스이다 //HashMap생성자 인스턴스를 만든다 
		
		Map<String,String> maps = new HashMap<String,String>();
		maps.put("이름", "홍길동");
		maps.put("나이", "30");
		maps.put("직업", "IT");
		System.out.println(maps.get("이름"));
		System.out.println(maps.get("나이"));
		System.out.println(maps.get("직업"));
		
	}

}
