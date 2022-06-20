<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"반지의 제왕", "시간을 달리는 소녀", "귀멸의 칼날", "양들의 침묵", "장고", "너의 이름은"};
	pageContext.setAttribute("mList", movieList);
%>
	<h3>단순 반복</h3>
<c:forEach items="${mList}" var="mTitle">
	${mTitle}<br>	
</c:forEach>
<hr>
<table border="1">
	<tr>
		<td>인덱스</td>
		<td>카운트</td>
		<td>영화제목</td>
	</tr>
	<c:forEach items="${mList}" var="mTitle" varStatus="vs">
		<tr>
			<td>${vs.index}</td>
			<td>${vs.count}</td>
			<td>${mTitle}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<ul>
	<c:forEach items="${mList}" var="mTitle" varStatus="vs">
		<c:choose>
			<c:when test="${vs.first}">
				<li style="color:gold; font-weight:bold">${mTitle}</li>
			</c:when>
			<c:when test="${vs.last}">
				<li style="color:blue; background-color:pink;">${mTitle}</li>
			</c:when>
			<c:otherwise>
				<li>${mTitle}</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>
<hr>
	<c:forEach items="${mList}" var="mTitle" varStatus="vs">
		${mTitle} <c:if test="${not vs.last}">,</c:if>
	</c:forEach>
<hr>
	<table border="1">
		<tr>
			<td>인덱스</td>
			<td>카운트</td>
			<td>숫자</td>
		</tr>
		<c:forEach var="num" begin="1" end="5" varStatus="vs">
			<tr>
				<td>${vs.index}</td>
				<td>${vs.count}</td>
				<td>${num}</td>
			</tr>
		</c:forEach>
	</table>
<hr>
	<table border="1">
		<tr>
			<td>인덱스</td>
			<td>카운트</td>
			<td>숫자</td>
		</tr>
		<c:forEach var="num" begin="3" end="11" step="2" varStatus="vs">
			<tr>
				<td>${vs.index}</td>
				<td>${vs.count}</td>
				<td>${num}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>