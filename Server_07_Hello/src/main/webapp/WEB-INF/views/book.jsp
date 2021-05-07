<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 도서 정보 등록 </h1>

<p><label>ISBN</label>
	<input name="bk_isbn" value="${bk_isbn}"/></p>
<p><label>도서명</label>
	<input name="bk_title"value="${bk_title}"/></p>
<p><label>출판사</label>
	<input name="bk_code"value="${bk_ccode}"/></p>
<p><label>저자</label>
	<input name="bk_acode"value="${bk_acode}"/></p>

</body>
</html>