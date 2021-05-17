<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table>
    <tr>
        <td>섭취일자</td>
        <td>식품코드</td>
        <td>식품명</td>
        <td>섭취량</td>
        <td>제공량</td>
        <td>탄수화물</td>
        <td>지방</td>
        <td>칼로리</td>
        <td>당</td>
        <td>총내용량</td>
        <td>단백질</td>
    </tr>
    <c:forEach items="${MFOODS}" var ="MF">
    

        <tr>
            <td>${MF.mf_date}</td>
            <td>${MF.mf_fcode}</td>
            <td>${MF.mf_name}</td>
            <td>${MF.mf_amt}</td>
            <td>${MF.mf_once}</td>
            <td>${MF.mf_capa}</td>
            <td>${MF.mf_carbo}</td>
            <td>${MF.mf_fat}</td>
            <td>${MF.mf_sugar}</td>
            <td>${MF.mf_protein}</td>
            <td>${MF.mf_cal}</td>
        </tr>
    </c:forEach>
    </table>
