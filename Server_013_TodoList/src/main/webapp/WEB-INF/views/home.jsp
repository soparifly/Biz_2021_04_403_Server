<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

h1, form.doit {
	width: 50%;
	margin: 10px auto;
	border-radius: 5px;
}

h1 {
	background-color: rgba(0, 255, 0, 0.3);
	color: white;
	padding: 1rem;
	text-align: center;
	/*문자에 그림자를 지정함*/
	text-shadow: 1px 1px 1px #000;
}

form.doit {
	border: 1px solid red;
	padding: 10px;
	text-align: center;
}

form.doit input {
	width: 90%;
	/* input 박스를 클릭하면 진한 테두리가 박스에 둘러지는것을 방지하기위함*/
	outline: 0;
	border: 1px solid #eee;
	border-radius: 5px;
	padding: 15px;
	margin: 10px;
	font-weight: bold;
}

form.doit input:hover {
	background-color: #eee;
}
</style>
<body>
	<h1>TO DO List</h1>
	<div class="input">
		<%--form tag의 action 속성 
form tag의 action 속성은 form 에 담긴 데이터를
submit(서버로 전송할때) 어떤 uri path를 통해서 서버에 보낼것인가를 지정하는것 

만약 이  action속성을 지정하지 않으면
현재 파일(home.jsp)을 보여줄때 사용한 uri주소가 (기본주소)가 자동으로 설정된다

&{rootPath}/ 처럼 지정하는 것 
form, a tag등에 URL, URI를 지정할때

주소의 지정방식에 따라 상대주소, 절대 주소 방법이 있는데 
지정하는 방법에 따라 연결이 잘 안되는경우가 많다

우리프로젝트는 모두 절대 주소 방식을 사용하고
항상 주소(uri, url) 과 관련된 모든항목은 ${rootPath}로 시작하는 주소로 사용한다

rootPath = http://localhost:8080/todo
--%>
		<form class="doit" method="POST" action="${rootPath}/insert">
			<input name="td_doit" placeholder="할일을 입력한 후 Enter">
		</form>
	</div>
</body>
</html>