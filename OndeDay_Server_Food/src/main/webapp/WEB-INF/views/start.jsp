<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "POST">
			<p><label>상품명으로 검색하기</label><p><input name="fd_name">
			<button>찾기</button>
			<c:forEach items = "${FOODS}" var="FOOD">
		<h5> ${FOOD.cp_name}<a href="start/insert?fd_code=${FOOD.fd_code}">${FOOD.fd_name}</a> ( 총제공량 : ${FOOD.fd_weight}g 1회제공량 : ${FOOD.fd_order}g ) </h5>
		<h6> 칼로리 : ${FOOD.fd_kcal} , 단백질 : ${FOOD.fd_dan} 지방 : ${FOOD.fd_gi} 탄수화물 : ${FOOD.fd_tan} 당류 : ${FOOD.fd_dang}</h6>
			</c:forEach>
			<label>먹었던 기록확인하기</label>
			<input name="eat_date"><button>찾기</button>
			<c:forEach items = "${sEATS}" var="FOOD">
		<h5> ${FOOD.cp_name}<a href="start/insert?fd_code=${FOOD.fd_code}">${FOOD.fd_name}</a> ( 총제공량 : ${FOOD.fd_weight}g 1회제공량 : ${FOOD.fd_order}g ) </h5>
		<h6> 칼로리 : ${FOOD.fd_kcal} , 단백질 : ${FOOD.fd_dan} 지방 : ${FOOD.fd_gi} 탄수화물 : ${FOOD.fd_tan} 당류 : ${FOOD.fd_dang}</h6>
			</c:forEach>
	</form>

</body>
</html>