<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p { text-align: center;}
input {   width : 200px;
      border : 0.5px solid 	#E9967A}
a { text-decoration-line : none;
   color : #20B2AA   ;}
h1, h2, h3, h4, h5, h6 {text-align: center;}
table {
   border-top : 1px solid #cccccc;
   border-collapse: collapse;}
th,td {   padding : 15px 10px; 
   border-top : 1px solid #cccccc;
   text-align: center}
body { font-family : "Noto Sans CJK KR Light", "돋움", dotum, arial,"굴림", gulim}
</style>
</head>
<body>
	<h1>무엇을 먹을까</h1>
	<%--form의 method를 POST로 지정하면 
Contorller의 doPst()함수가 받아서 처리를 한다
보여지는 search.jsp 파일을 요청한 요청주소는
/food/search이다
form에 action을 임의로 지정하지않으면
action="form/search"가 자동으로 지정된다  --%>

	<form method="POST">
		<p>
			<label>식품명</label>
			<%-- input placeholer : 입력박스의 안내메시지 --%>
			<input name="f_name" placeholder="식품명을 입력한 후 Enter...." />
		</p>
	</form>
	<div>
		<c:choose>
		<%--
		
		<c:choose>
		<c:when>  : if에 해당하는 부분
		
		c:taglib에는 if else가 없어서 choose를 사용한다 
		
		</c:when>
		<c:otherwise> :else 에 해당하는 부분 
		</c:ortherwise>
		</c:choose>
		
		 --%>
			<c:when test="${not empty FOODS}">
				<table>
					<tr>
					<th>식품코드</th>
					<th>식품명</th>
					<th>출시연도</th>
					<th>제조사코드</th>
					<th>분류코드</th>
					<th>제공량</th>
					<th>총내용량</th>
					<th>에너지</th>
					<th>단백질</th>
					<th>지방</th>
					<th>탄수화물</th>
					<th>총당류</th>
					</tr>
					<%--
					Controller에서 전달받은
					FOODS Attribute 를
					for 반복문으로 반복되면서
					itme 을 gtter하여 FOOD(dto)에 담아라 --%>
					<c:forEach items="${FOODS}" var="FOOD">
						<tr>
						<%-- forEach가 만든 FOOD를 
						Get하여  --%>
						<td>${FOOD.fd_code}</td>
						<td>${FOOD.fd_name}</td>
						<td>${FOOD.fd_year}</td>
						<td>${FOOD.fd_ccode}</td>
						<td>${FOOD.fd_icode}</td>
						<td>${FOOD.fd_once}</td>
						<td>${FOOD.fd_capa}</td>
						<td>${FOOD.fd_cal}</td>
						<td>${FOOD.fd_protein}</td>
						<td>${FOOD.fd_fat}</td>
						<td>${FOOD.fd_carbo}</td>
						<td>${FOOD.fd_sugar}</td>
					</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</div>
</body>
</html>