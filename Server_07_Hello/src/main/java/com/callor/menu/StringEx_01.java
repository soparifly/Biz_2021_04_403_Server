package com.callor.menu;

public class StringEx_01 {

	public static void main(String[] args) {
		
		
		
		String menu = "3";
		if(menu.equals("1")) {
			System.out.println("메뉴에 저장된 값은 1");
			
		} else if( menu.equals("2")) {
			
			System.out.println("저장된값 2");
		} else if( menu.equals("3")) {
			
			System.out.println("저장된값 3");
		} else if( menu.equals("4")) {
			
			System.out.println("저장된값 4");
		} else {
			System.out.println("모르겠음");
		}
		/*
		 * 실행조건에 맞는 상황이 될때까지 

브레이크를 넣어야만 멈추고 실행되고

널값을 처리할수 없음

스위치 명령은 다중 if else , esle if를 대신하여 사용할수 있는 구조적인 명령문

단점은 반드시 case 조건문을 수행한다음 break; 를 실행하여

더이상 불필요한 코드가 실행되는것을 사전에 방지해야하며

만약 변수에 저장된 값이 null이있다면 미리 if명령 등을 이용하여 검사를 하던지 절대 변수에 null값이 저장되지않도록 미리 조치를 해주어야한다

java 1.5 이전에는 swich문으로 문자열을 조건 처리를 할수 없었다

스위치는 변수가 숫자형일 경우에만 사용하는 것이 오류를 막고 깔끔한 코드가 될수있다
		 */
		if(menu != null) {
		switch(menu) {
		case "1":
			System.out.println("1");
			break;
		case "2":
			System.out.println("2");
			break;
		case "3":
			System.out.println("3");
			break;
		case "4":
			System.out.println("4");
			break;
		case "5":
			System.out.println("5");
			break;
		default : System.out.println(" 모르겠음");
		}
		}
		
		
	}
}
