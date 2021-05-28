package com.callor.todo.command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

public class TodoCommandImplV1 implements TodoCommand {
//	Logger 클래스의  객체인 log를 선언하고
//
//	생성할때 관리이름으로 TODO를 부착하라
//
//	TODO라는 이름으로 Logger를 싱글톤으로 생성하라
	// Factroy 패턴
	// 객체를 생성하는 클래스. 메소드()를 준비해두고 필요에따라 생성된 객체를 제공받는 패턴
	private static final Logger log = LoggerFactory.getLogger("TODO");

	private TodoService toService;

	public TodoCommandImplV1() {
		toService = new TodoServiceImplV1();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String td_doit = req.getParameter("td_doit");
		String td_sseq = req.getParameter("td_sseq");

//		Server app에서 sysout 을 대신에 출력할 메서드
		log.debug("td_doit {} ", td_doit);
		log.debug("td_sseq {} ", td_sseq);
		// 잘되는지 테스트하는 코드
		// 배포(Deploye) 하는 상황에서 쉽게 노출되어 문제가 발생될수 있다
		// 배포가 된후에는 사용이 필요없는 코드이다
		// console에 저런내용들이 많이 나타나면 아마존등에서 사용하는 서버사용비를
		// 더내야할수도있다.
		System.out.println(td_doit);

		// Map으로 만든 동적 VO(dynamic) vo
		// Value 를 Object로 만든 이유
		// Table에서 데이터를 SELECT 하거나
		// INSERT, UPDATE를 수행할때 각칼럼의 Data type이 문자열, 숫자등으로
		// 다양한 Type으로 구성되어있기때문에
		// 미리 어떤 Type으로 지정하기가 어려워 원시 클래스인 Super parent Type인 Object클래스 type으로 선언한다
		Map<String, Object> tdVO = null;
//				=new HashMap<String, Object>();

		// 최초로 TOD추가하는 날짜, 시각을 자동생성
		// 을 하기위해 시스템날짜 가져오기
		Date date = new Date(System.currentTimeMillis());

		// 가져온 날짜를 문자열로 변환하기 위하여 format(형식)을 생성하기
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");

		// 생성된 format을 사용하여 날짜 데이터를 문자열로 담기
		String curDate = sd.format(date);
		String curTime = st.format(date);

		// request로 부터 Uri 정보를 추출하기
		String uriPath = req.getRequestURI();
		log.debug("uri {} " + uriPath);

		// rootPath == contextRootPath == contextPath
		String rootPath = req.getContextPath();

		// 문자열.subString(어디서부터 ): 어디서부ㅡ터 끝까지
		// uriPath 에서 rootPath를 제외한 나머지만 추출하여 달라
		String path = uriPath.substring(rootPath.length());

		log.debug("PATH: {} " + path);
		if (path.equals("/insert")) {
			tdVO = new HashMap<String, Object>();

			tdVO.put(DBInfo.td_sdate, curDate);
			tdVO.put(DBInfo.td_stime, curTime);
			tdVO.put(DBInfo.td_doit, td_doit);

			log.debug("VO 데이터 {} :" + tdVO.toString());
//			toService.insert(tdVO);
			// 원칙적인코드는 기존에 코드에서 Integer ret을 추가한다
//			insert로ㅓ부터 전달받은 숫자가 1이상이면 정상 insert이고 그렇지 않으면 추가가 잘못됨

			Integer ret = toService.insert(tdVO);

		} else if (path.equals("/expir")) {
			// 전달 받은 seq에 해당하는 데이터가져오기
			Long seq = Long.valueOf(td_sseq);
			tdVO = toService.findById(seq);

			Object e_date = tdVO.get(DBInfo.td_edate);
			// 현제 조회된 TODO정보에서 만료일자를 검사하여 null이거나 ""dlaus

			if (e_date == null || e_date.equals("")) {
				tdVO.put(DBInfo.td_edate, curDate);
				tdVO.put(DBInfo.td_etime, curDate);
			}
			// 값이 있으면
			else {
				tdVO.put(DBInfo.td_edate, null);
				tdVO.put(DBInfo.td_etime, null);

			}
			log.debug("after set{}", tdVO.toString());
			
			toService.update(tdVO);
			
		}

		// Map type의 VO에 현재 날짜, 시각 , 할일 정보를 저장하기

		// VO에 칼럼을 추가하면서 동시에 데이터를 저장한다\
		// Map type의 특징
		// VO에 데이터를 put() 할때 만약 key에 해당하는 데이터가
		// 이미 있으면 기존의 데이터를 수정한다
		// 없으면 새로운 칼럼을 추가하고 데이터를 저장한다
//		if (ret < 1) {
//			req.setAttribute("ERROR", "Insert 실패");
//		} else {
//
//			req.setAttribute("COMP", "Insert 성공");
//		}

		// "/todo/"
		res.sendRedirect(req.getContextPath());
	}

}
