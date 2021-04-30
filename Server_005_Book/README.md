# 도서 관리 서버 프로젝트
* 웹 브라우저에서 데이터를 입력하고 서버로 전송하여 처리하기


## 입력 화면 만들기

*웹 브라우저에서 데이터를 입력받기 위한화면 만들기 
* 컨트롤러에서 값을 추출할때
<form action = "요청 Path">
	<p> <input name="변수명"> 
	<p> <input name="변수명">
	<p> <button>전송</button>

</form>


## Controller 만들기
*HttpServlet 클래스를 extends 하여 클래스 생성
*@WebServlet ("요청path") annotation 어노테이션 선언

*doGet() 메서드를 오버라이드 
*res.getParameter("변수명")으로 데이터 받기



