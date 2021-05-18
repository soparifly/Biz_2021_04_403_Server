<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<%-- crome browser의 캐쉬때문에 css, js 등 외부 파일이 변경되어도 적용이 안되는 경우가 있다. '?ver=숫자' 값을 변경하면 chrome browser가 파일이 변경된것으로 인식하여 새로고침을
해준다 --%>
<link href="${pageContext.request.contextPath}/css/home.css?ver=2021-05-18-111"
	rel="stylesheet"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=1">
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%--
외부의 css file 가져오기
webapp 폴더는 프로젝트의 외부에서 접근할때
root folder로 인식된다
슬래시(/)로 시작되는 경로는 webapp폴더로 인식된다

그런데 지금 프로젝트에서 슬래시(/)로 접근하는 모든 요청은
HomeController가 catcher 하도록 만들어져있기때문에
어떠한 파일로 연결할수 없다
 --%>



</head>
<body>
	<h1>다이어트를 도와줘!!</h1>
	<%-- /diet/food/search --%>
	<a href="${pageContext.request.contextPath}/food/search">섭취정보 등록</a>
	<div>
		<form>
			<label>날짜 </label> <input name="mf_date">
		</form>

	</div>
	<%-- JSP 파일에서 다른  JSP파일 연결하기  --%>

	<%@ include file="/WEB-INF/views/list.jsp"%>




</body>
</html>