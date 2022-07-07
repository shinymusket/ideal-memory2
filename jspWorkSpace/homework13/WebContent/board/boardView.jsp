<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
<link type="text/css" rel="stylesheet" href="./css/community.css">
</head>
<body>
<%@ include file="../header/header.jsp" %>
	<div class="container" align="center">
			<h1>게시물 조회</h1>
		<table class="boardView">
			<tr>
				<th>제목</th>
				<td>${board.subject}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.regdate}</td>
			</tr>
			<tr>
				<td colspan="2">
					${board.content}
				</td>
			</tr>
		</table>
			
			<c:if test="${commentList != null}">
				<table class="boardComment">
					<tr>
						<th colspan="4">댓글 조회</th>
					</tr>
					<c:forEach items="${commentList}" var="comment">
							<tr>
								<td>${comment.writer}</td>
								<td>${comment.content}</td>
								<td>${comment.regdate}</td>
								<td>
									<input type="button" value="삭제" onclick="location.href='/homework13/CD?idx=${comment.idx}&bidx=${comment.bidx}'">
								</td>
							</tr>
					</c:forEach>
				</table>
			</c:if>
			
			<form action="CW" method="post">
				<table class="boardComment">
					
						<tr>
							<th colspan="2">댓글 작성</th>
						</tr>
						<tr>
							<td>
								<input type="text" name="writer" placeholder="작성자" size=5>
								<input type="text" name="content" placeholder="댓글 내용">
								<input type="hidden" name="bidx" value="${boardIdx}"> 
							</td>
							<td>
								<input type="submit" value="작성완료">
							</td>
						</tr>
					
				</table>
			</form>
			
		<div>
			<input type="button" value="목록" onclick="location.href='/homework13/BL'">
			<input type="button" value="수정" onclick="location.href='/homework13/BU?idx=${board.idx}'">
			<input type="button" value="삭제" onclick="location.href='/homework13/BD?idx=${board.idx}'">
		</div>
	</div>
	

<%@ include file="../footer/footer.jsp" %>
</body>
</html>