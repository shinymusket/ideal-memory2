<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원매출조회</title>
<link type="text/css" rel="stylesheet" href="css/shopping.css">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>
	<div class="container" align="center">
		<h2>회원매출조회</h2>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			
			<c:forEach items="${memberPriceList}" var="member">
			<tr>
				<td>${member.custno}</td>
				<td>${member.custname}</td>
				<td>${member.grade}</td>
				<td>${member.sumPrice}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

<%@ include file="../footer/footer.jsp" %>
</body>
</html>