package com.callor.diet.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



/*
 * Web Browser -->url req -->tomcat -->context-->Filter.doFilter() 
 * 											  	-->Controller.doGet() 또는
 * 											  	-->Controller.doPost() 
 * Controller에서 실제 업무와 연계되면서 모든 ( 많은) Conntroller에서 공통으로 설정해야하는 것들, 
 * 공통으로 처리해야하 는것들을 미리 Filter에서 처리를 하고 처리된 결과를 Controller에게 전달하는 Tomcat  WAS의 처리절차 
 * 
 * Filter에서 처리된 설정은 모든 Controller에서 처리하는 것과 같은 효과를 발휘한다 
 *  login과 같은 처리는 각각의 Controller가 사용자의 요청을 받으면 항상 login이 되어있는지 검사하고 
 *  그에따른 처리를 수행해야한다
 *  login여부에 따라 Controller로 전달할지 안할지를 판단하여 한번에 미리 처리할수 있다
 */
//urlPatterns ="/food/*"로 설정하면
//localhost:8080/diet/food로 요청하는 부분만 처리 
/*
 * filter에서 response.setcontenttexp을 지정할때 Text/html 로 지정하면 jsp, js...로 기타 여러가지 static 파일들이 모두
 * html ContextType으로 지정되어
 * WebBrowser로 전송되어 제기능을 수행하지 못하는 현상이 발생한다
 * 이럴때는 WebFilter urlPatterns를 문자열 배열로 생성하고 각 Controller에 지정된 WebServlet필터를 나열해주면
 * Controller로 요청되는 사항들만 Filtering를 하게되어 기타 다른 static File들 에는 영향을 미치지않는다
 */
@WebFilter(urlPatterns = {"/","/food/*"})  // 배열로 여러개를 지정해줄수있음
public class KoreaFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	//TODO 한글 Encoding 설정
	/*
	 * 프로젝트의 모든 Controller로 요청되는 데이터들의 문자 Encoding 을 설정하고 Controller에서 Web으로 응답하는 데이터들의 ContentType을 설정하기
	 */
	req.setCharacterEncoding("UTF-8");
//	res.setContentType("text/html;charset=UTF-8");
	chain.doFilter(req, res); // 안적으면 Controller로 넘어가지않음
	
	}
	
}
