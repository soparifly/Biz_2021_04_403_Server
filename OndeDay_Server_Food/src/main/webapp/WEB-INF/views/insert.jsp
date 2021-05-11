<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 먹은 내용 등록하기 </h1>
<form>
<p><label>날짜</label> <input name="eat_date"></p>
<p><label >섭취량</label><input name="eat_order"/></p>
<p><label>식품 코드: </label><input name ="fd_code" value ="${CODE}"></p>
<button>등록하기</button>

</form>
</body>
</html>