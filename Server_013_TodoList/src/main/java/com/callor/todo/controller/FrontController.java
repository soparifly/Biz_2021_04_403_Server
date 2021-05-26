package com.callor.todo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.command.HomeCommandImplV1;
import com.callor.todo.command.TodoCommand;
import com.callor.todo.command.TodoCommandImplV1;

@WebServlet("/")
public class FrontController extends HttpServlet {

	protected Map<String, TodoCommand> commands;

//	FrontController가 최초 호출될때 한번 실행되어서
//	여러가지 변수등을 초기화하는코드
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	
		commands = new HashMap<String, TodoCommand>();
		
		/*
		 * 만약 http://localhost:8080/{rootPath}/로 요청이 오면
		 * HomeCommandImplV1 객체를 사용하여
		 * 요청을 처리하기 위한 준비
		 */
		//commands.put("/" ->라우팅
		commands.put("/", new HomeCommandImplV1());
		/*
		 *  * 만약 http://~ /{rootPath}/insert 로 요청이 오면
		 * HomeCommandImplV1 객체를 사용하여
		 * 요청을 처리하기 위한 준비
		 * 
		 */
		commands.put("/insert",new TodoCommandImplV1());
	}
//	doGet(), doPst()로 분리해서 요청을 처리하던 방식을 한개의 메서드에서 동시에 처리하기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//요청한 Path 가져오기
		String urlPath = req.getRequestURI();
		String path = urlPath.substring(req.getContextPath().length());
		
		//req 된 URI중에서 실제 subPath  부분을 사용하여
		//MAP 으로부터 처리할 객체를 추출
		TodoCommand subCommand = commands.get(path);
		if(subCommand != null) {
			//각 Command객체의 execute() method에게 실제 요청을 처리하도록 위임한다
			subCommand.execute(req, res);
			
		}
		
	}

	
	
	
	
}
