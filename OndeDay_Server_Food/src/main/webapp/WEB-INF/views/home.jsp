<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>다이어트를 도와줘</h1>
	<form>
		
	
		<p>
			<label>날짜를 입력하고 조회를 클릭</label> <p><input name="eat_date">
			<button>조회</button>
			<p><label>상품명으로 검색하기</label><p><input name="상품명" value="${FOOD}"/>
			<button>찾기</button>
			
			
			
	</form>

</body>
</html>