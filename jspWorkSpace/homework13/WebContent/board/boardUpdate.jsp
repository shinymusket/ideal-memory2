<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link type="text/css" rel="stylesheet" href="./css/community.css">
</head>
<body>
<%@ include file="../header/header.jsp" %>

	<div class="container" align="center">
		<h1>게시물 수정</h1>
		<form action="BU" method="post">
			<table>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="writer" value="${board.writer}">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="subject" value="${board.subject}">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" rows="5" cols="20">
							${board.content}
						</textarea>
					</td>
				</tr>
			</table>
			<input type="hidden" name="idx" value="${board.idx}">
			<input type="reset" value="취소">
			<input type="submit" value="완료">
		</form>
	</div>
<%@ include file="../footer/footer.jsp" %>
</body>
</html>