<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

h1, form {
	width: 80%;
	margin: 10px auto;
}

h1 {
	background-color: rgba(0, 155, 255, 0.3);
	color: white;
	padding: 1.2rem;
	text-align: center;
}

form {
	border: 1px solid green;
	border-radius: 20px;
	padding: 10px;
}

label {
	display:inline-block;
	width: 20%;
	text-align: right;
	padding:8px;
	margin:5px;
}
button{
	background-color: gray;
	color: white;
	padding: 8px;
	whidth: 10%;
	outline: 0;
	border-radius: 10px;
	cursor: pointer;
	font-style: D2Conding
	}
	button:hover{
	/* x-offset y-offset blue spread color */
	box-shadow:3px 3px 3px rgba(0,0,0,0.3);
	}
input{
width:60%;
padding : 8px;
margin: 5px;
}
</style>
</head>
<body>
	<form method="POST">
		<h1>식품 섭취 내역 입력</h1>
		<p>
			<label>식품코드</label> <input name="mf_code" value="${FOODS.fd_code}">
		<p>
			<label>식품이름</label> <input name="mf_name"value="${FOODS.fd_name}">
		<p>
			<label>섭취일자</label> <input type="date" name="mf_date" value="${TODAY}">
		<p>
			<label>섭취량</label> <input name="mf_amt"value="1">
			<button>Enter</button>
	</form>
</body>
</html>







