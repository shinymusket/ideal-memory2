<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<link type="text/css" rel="stylesheet" href="./css/community.css">
</head>
<body>
<%@ include file="../header/header.jsp" %>

	<div class="container" align="center">
		<h2>총  ${boardCount}개의 게시물이 있습니다.</h2>
		
		<table class="boardList">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			
			<c:if test="${boardList != null}">
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.idx}</td>
						<td>${board.writer}</td>
						<td><a href="BV?idx=${board.idx}">${board.subject}</a></td>
						<td>${board.regdate}</td>
					</tr>
				</c:forEach>
			
			</c:if>
		</table>
		<div class="bts" align="right">
			<input type="button" value="작성" onclick="location.href='/homework13/BW'">
		</div>	
	</div>
	
	
	
<%@ include file="../footer/footer.jsp" %>
</body>
</html>