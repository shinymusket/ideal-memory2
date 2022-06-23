<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link type="text/css" rel="stylesheet" href="css/board.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시판 목록</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border:white; text-align:right">
					<a href="BS?command=board_write_form">게시글 등록</a>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td><a href="BS?command=board_view&num=${board.num}">${board.title}</a></td>
					<td>${board.name}</td>
					<td><fmt:formatDate value="${board.writeDate}"/></td>
					<td>${board.readCount}</td>
				</tr>
			</c:forEach>
		</table>

		<div class="cls2">
			<c:if test="${totalCnt != null}">
				<c:choose>
					<c:when test="${totalCnt > 100}">
						<c:if test="${(section*100) < totalCnt}">
							<c:forEach var="page" begin="1" end="10" step="1">
								<c:if test="${section > 1 && page == 1}">
									<a href="BS?command=board_list&section=${section-1}&pageNum=${10}">  ◀ </a>
								</c:if>
								<a href="BS?command=board_list&section=${section}&pageNum=${page}">${(section-1)*10 + page}</a>
								<c:if test="${page == 10}">
									<a href="BS?command=board_list&section=${section+1}&pageNum=${1}">  ▶  </a>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${(section*100) > totalCnt}">
							<c:forEach var="page" begin="1" end="${((totalCnt + 9)-((section-1)*100)) / 10}" step="1">
								<c:if test="${section > 1 && page == 1}">
									<a href="BS?command=board_list&section=${section-1}&pageNum=${10}"> ◀ </a>
								</c:if>
								<a href="BS?command=board_list&section=${section}&pageNum=${page}">${(section-1)*10 + page}</a>
							</c:forEach>
						</c:if>
					</c:when>
					
					<c:when test="${totalCnt == 100}">
						<c:forEach var="page" begin="1" end="10" step="1">
							<a href="BS?command=board_list&section=${section}&pageNum=${page}">${page}</a>
						</c:forEach>
					</c:when>
					
					<c:when test="${totalCnt < 100}">
						<c:forEach var="page" begin="1" end="${(totalCnt + 9)/10}" step="1">
							<a href="BS?command=board_list&section=${section}&pageNum=${page}">${page}</a>
						</c:forEach>
					</c:when>
					
				</c:choose>
			</c:if>	
		</div>
	</div>
</body>
</html>