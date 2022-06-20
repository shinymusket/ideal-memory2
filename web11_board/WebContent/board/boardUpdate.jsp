<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link type="text/css" rel="stylesheet" href="css/board.css">
</head>
<body>
	<div id="wrap">
		<h1>게시물 수정</h1>
		<form action="BS" method="post">
			<input type="hidden" name="command" value="board_update">
			<input type="hidden" name="num" value="${board.num}">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name" required="required" value="${board.name}"> * 필수</td>
				</tr>	
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pass"> * 미입력시 기존의 비밀번호가 유지됩니다.
						<input type="hidden" name="originPass" value="${board.pass}">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" value="${board.email}"></td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td><input type="text" name="title" required="required" value="${board.title}"> * 필수</td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td><textarea rows="15" cols="70" name="content">${board.content}</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글 수정하기">
						<input type="reset" value="다시 작성하기">
						<input type="button" value="목록 보기" onclick="location.href='BS?command=board_list'">
					</td>
				</tr>
			
			</table>
		
		</form>
	</div>
</body>
</html>