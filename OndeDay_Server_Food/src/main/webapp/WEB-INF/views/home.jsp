<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<p><label>상품명으로 검색하기</label><p><input name="fd_name"/>
			<button>찾기</button>
		<h5>SEQ : ${FOOD.eat.seq}</h5>
		<h5>식품명 : ${FOOD.fd_name}</h5>
		<h5>식품명 : ${FOOD.fd_order}</h5>
		<h5>식품명 : ${FOOD.fd_weight}</h5>
		<h5>식품명 : ${FOOD.fd_kcal}</h5>
		<h5>식품명 : ${FOOD.fd_dan}</h5>
		<h5>식품명 : ${FOOD.fd_gi}</h5>
		<h5>식품명 : ${FOOD.fd_tan}</h5>
		<h5>식품명 : ${FOOD.fd_dang}</h5>
			
			
	</form>

</body>
</html>