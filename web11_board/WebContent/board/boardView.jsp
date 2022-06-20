<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<link type="text/css" rel="stylesheet" href="css/board.css">
</head>
<body>
	<div id="wrap">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.name}</td>
				<th>이메일</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.writeDate}"/></td>
				<th>조회수</th>
				<td>${board.readCount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${board.title}</td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td colspan="3">${board.content}</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="button" value="수정" 
					onclick="openWin('BS?command=board_check_pass_form&num=${board.num}','update')">
					<input type="button" value="삭제" 
					onclick="openWin('BS?command=board_check_pass_form&num=${board.num}','delete')">
					<input type="button" value="목록 보기" onclick="location.href='BS?command=board_list'">
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript">
	function openWin(url, name) {
		window.open(url, name, "width=500, height=400")
	}

</script>	
</body>
</html>