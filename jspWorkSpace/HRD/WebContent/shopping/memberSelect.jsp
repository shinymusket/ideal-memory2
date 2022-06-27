<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록조회/수정</title>
<link type="text/css" rel="stylesheet" href="css/shopping.css?">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>
	<div class="container" align="center">
		<h2>회원목록조회/수정</h2>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			
			<c:forEach items="${memberList}" var="member">
			<tr>
				<td><a href="SS?command=member_update_form&custno=${member.custno}">${member.custno}</a></td>
				<td>${member.custname}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>
				<td>${member.joindate}</td>
				<td>${member.grade}</td>
				<td>${member.city}</td>
			</tr>
			</c:forEach>
		
		</table>
	</div>
<%@ include file="../footer/footer.jsp" %>
</body>
</html>