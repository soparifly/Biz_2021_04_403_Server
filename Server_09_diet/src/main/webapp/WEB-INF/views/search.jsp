<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:set value="${pageContext.request.contextPath}"
		 var="rootPath"/>
<html>
<head>
<meta charset="UTF-8">
<title>식품정보 검색</title>
<style>
/* tag 에 padding 을 설정하면
실제 width  보다 더 커지는 현상이 발생한다
이러한 현상은   UI 화면을 눈에 더 거슬리게 하는 결과가 된다
padding 주었을때
좌, 우의 크기를 padding 을 밖으로 보내지않고
내부로 흡수하는 옵션

이 설정을 style의 맨상단에 설정하면
padding으로 인한 Layout의 흐트러짐을 막을수 있다.


*/
*{
	box-sizing: border-box;
}

/*h1,form,table,tag에 공통된 style지정 */
h1, form, table {
	whidth: 80%;
	margin: 0px auto;
}

h1 {
	background-color: rgba(0, 255, 0, 0.2); 
	text-alin: white;
	padding: 1rem;
}

form {
	border: 1px solid green;
	padding-left:10px;
}

table {
	border: 1px solid green;
	margin-top: 5px;
	border-collapse: collapse;
}

td, th {
	border: 1px solid green;
	padding: 5px;
}
td{
color:hotpink;
}
/*
 	table 의 어떤 row에 마우스가 올라가면
 	바탕색을 #aaa로 마우스 커서 모양을 손모양으로 
 	
*/
tr:hover {
	/*rgb(100,100,100);*/
	/*rgb(255.255.255):white (0,0,0)black */
	background-color: #aaa; /* AA.AA.AA  10*10, 10*10, 10*10 */
	cursor: pointer;
}
tr:nth-child(odd)){
	background-color: #ccc; /* #000 ~ #fff gray level */
}
tr:nth-child(even){
	background-color: #eee;
}
input {
	border :1px solid green;
	padding:5px;
	width:60%;
	border-line:10px;
}
a{
	text-decoration: none; /*하이퍼 위에 밑줄없앰*/
	color : inherit; /* */
	
}
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
							<td>
				<a href ="${rootPath}/food/insert?fd_code=${FOOD.fd_code}"> <%-- td 태그가 감싸고있는 상태에서 td { text color} 를 바꾸었을때 상속받은 태그도 같이 바뀌는 것 : style의 상속 --%>
							${FOOD.fd_name}
							</a>
							</td>
							<td>${FOOD.fd_year}</td>
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