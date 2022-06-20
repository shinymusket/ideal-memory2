<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<link type="text/css" rel="stylesheet" href="css/board.css">
</head>
<body>
	<div id="wrap">
		<h1>게시물 등록</h1>
		<form action="BS" method="post">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name" required="required"> * 필수</td>
				</tr>	
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수(글 수정/삭제시 필요)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td><input type="text" name="title" required="required"> * 필수</td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td><textarea rows="15" cols="70" name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글 작성">
						<input type="reset" value="다시 작성">
						<input type="button" value="목록 보기" onclick="location.href='BS?command=board_list'">
					</td>
				</tr>
			
			</table>
		
		</form>
	</div>
</body>
</html>