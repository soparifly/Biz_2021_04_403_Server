<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p { text-align: center;}
input {   width : 200px;
      border : 0.5px solid #cccccc}
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
<h1>다이어트를 도와줘!!</h1>
<%-- /diet/food/search --%>
<a href="${pageContext.request.contextPath}/food/search">섭취정보등록</a>

</body>
</html>