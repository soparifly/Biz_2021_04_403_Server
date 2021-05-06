<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    <!-- html Web Source 보기로 하면 노출되는 주석 --> 
    
    jsp 주석 
    Source보기로 했을때 보이지 않는 주석
    HTML 주석 보다는 다소 자유롭게 작성가능
     --%>
     <%--
     
     Standard TagLib
     HTML 에서 지원하지 않는 기능을 수행하기 위하여
     JSP 파일에서 사용하는 확장된 tag 기능
     Controller에서 List 배열에 데이터를 담아보내면
     단순한 HTML, EL tag만으로는 보여주기가 매우어렵다 
     이러한 데이터를 다소 쉽게 표현하기 위한도구
     JSTL : JSP standard Tag Lib

	JSP 2.0이상에서 사용가능, Tomcat 5.5이상에서 사용가능

	Tomcat 5.5 2006부터 사용하는  Tomcat
      --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
    	prefix= "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원 정보 조회 결과 </h1>
<c:if test="${ empty BUYERS }">회원 정보 없음</c:if>
<%--
for (BuyerDTO d: buList){
}

items = "Contorller 에서 받은 list,배열"
list를 전체반복하면서 각각의 요소를 Getter하여 var로 지정된 변수에 담기 
El teg를 사용하여 각각의 변수를 화면에 출력 

--%>

<c:forEach items="${BUYERS}" var="BUYER">


<p><a href = "page2?bu_code=${BUYER.bu_code}">${BUYER.bu_name}</a></p>${BUYER.bu_addr},${BUYER.bu_addr}
</c:forEach>
</body>
</html>