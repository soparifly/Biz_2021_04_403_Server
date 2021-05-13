<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
background-color: rgba(0,0,255,0.5);
color:while;
padding:1.2rem;
text-alingn: center;
}
a {
	text-decoration :none;
}
/* CSS 3 를 사용한 interactiv 스타일 지정
동적(dynamic) 스타일 지정 
*/
/* a tag 에 마우스가 "떠" 있으면  */
a:hover{
	text-decoration: underline;
	background-color: rgb(0,2,5,2.8)
}

</style>
</head>
<body>
<h1>다이어트를 도와줘!!</h1>
<%-- /diet/food/search --%>
<a href="${pageContext.request.contextPath}/food/search">섭취정보등록</a>

</body>
</html>