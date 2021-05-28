<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

h1, form.doit, table.td_list {
	width: 50%;
	margin: 10px auto;
	border-radius: 5px;
}

h1 {
	background-color: rgba(0, 255, 0, 0.3);
	color: white;
	padding: 1rem;
	text-align: center;
	/*문자에 그림자를 지정함*/
	text-shadow: 1px 1px 1px #000;
}

form.doit {
	border: 1px solid red;
	padding: 10px;
	text-align: center;
}

form.doit input {
	width: 90%;
	/* input 박스를 클릭하면 진한 테두리가 박스에 둘러지는것을 방지하기위함*/
	outline: 0;
	border: 1px solid #eee;
	border-radius: 5px;
	padding: 15px;
	margin: 10px;
	font-weight: bold;
}

form.doit input:hover {
	background-color: #eee;
}

table.td_list {
	border-collapse: collape;
	border-spaction: 0;
}

table.td_list td {
	padding: 7px;
	border-top: 1px solid green;
	cursor: pointer;
	/*
	실험적인 css: 적용하기
	user-select:none은 text dblcick했을때
	선택박스가 나타지 않도록 적용 
	그냥 user-select: 기능이 적용되는 브라우저용
	-webkit-:크롬, google, sapari 적용
	-moz-:파이어폭스계열
	-ms-: explorer
	-o- : opera
	*/
	user-select:none;
	-webkt-user-user-select:none;
	-moz-user-select:none;
	-ms-user-select:none;
	-o-user-select:none;
}
/* table 의 마지막 라인(tr)에  포함된 td에만 */
table.td_list tr:last-child td {
	border-bottom: 3px solid green;
}

table.td_list  td.count {
	font-size: 20px;
	text-align: right;
	width: 5%;
	color: blue;
}

table.td_list td.sdate, table.td_list td.edate {
	font-size: 10px;
	text-align: center;
	width: 20%;
}

table.td_list td.doti {
	font-size: 30px;
	text-align: left;
	/* 두줄이상의 본문을 1줄로 줄이고 말줄임표 표현
table이아닌 box형 tag의 경우
max-width대신 width값을 설정해야한다
아래 4가지 속성을 동시에 적용해야된다 */
	max-width: 0;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.through-text {
	text-decoration: line-through red;
}
/*화면 폭이 480px 이하 (max)일때 적용할 style*/
@media screen and (max-width:480px){
 h1,form.doit, table.td_list{
 width: 95%;
 margin:0 auto;
 
 }
/*화면 폭이 800px 이하 (max)일때 적용할 style*/
@media screen and (max-width:800px){
 h1,form.doit, table.td_list{
 width: 70%;
 margin:0 auto;
 
 }

}
</style>
<script>
 document.addEventListener("DOMContentLoaded",()=>{
	
	 document.querySelector("table.td_list").addEventListener("dblclick",(ev)=>{
		 ev.preventDefault()
		 
		 
		 
		 let tagName= ev.target.tagName
		 if(tagName=="TD"){
			 // 클릭된 TD tag를 감싸고 있는 TR객체를 확인하기
			 let tr= ev.target.closest("TR").dataset
			 //let seq = ev.target.closest("TR").dataset.seq
			 let td_sseq=tr.sseq
			 let td_edate=tr.edate
			 
			 let confirm_msg = td_edate 
			 						?  
					 			"완료를 취소합니다"
					 			:"TODO를 완료했나요?";
					 					
					if(confirm(confirm_msg)){
						//document 는 생략가능하다
						     location.href=
							"${rootPath}/expire?td_sseq="+td_sseq
					}
		 }
		 alert(tagName);
	 })
 	})
 


</script>
<body>
	<h1>TO DO List</h1>
	<div class="input">
		<%--form tag의 action 속성 
form tag의 action 속성은 form 에 담긴 데이터를
submit(서버로 전송할때) 어떤 uri path를 통해서 서버에 보낼것인가를 지정하는것 

만약 이  action속성을 지정하지 않으면
현재 파일(home.jsp)을 보여줄때 사용한 uri주소가 (기본주소)가 자동으로 설정된다

&{rootPath}/ 처럼 지정하는 것 
form, a tag등에 URL, URI를 지정할때

주소의 지정방식에 따라 상대주소, 절대 주소 방법이 있는데 
지정하는 방법에 따라 연결이 잘 안되는경우가 많다

우리프로젝트는 모두 절대 주소 방식을 사용하고
항상 주소(uri, url) 과 관련된 모든항목은 ${rootPath}로 시작하는 주소로 사용한다

rootPath = http://localhost:8080/todo
--%>
		<form class="doit" method="POST" action="${rootPath}/insert">
			<input name="td_doit" placeholder="할일을 입력한 후 Enter">
		</form>
	</div>
	<div class="msg">${ERROR}${COMP}</div>
	<table class="td_list">
		<c:forEach items="${TDLIST}" var="TD" varStatus="ST">
			<tr data-seq="${TD.td_sseq}" data-edate="${TD.td_edate}">
				<td class="count">${ST.count}</td>
				<td class="sdate">${TD.td_sdate}<br />${TD.td_stime}</td>
				<td class="doit ${empty TD.edate ? '':'through-text' }">${TD.td_doit}</td>
				<td class="edate">${TD.td_edate}<br />${TD.td_etime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>