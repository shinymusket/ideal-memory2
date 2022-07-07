<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<link type="text/css" rel="stylesheet" href="../css/community.css">
</head>
<body>
<%@ include file="../header/header.jsp" %>

	<div class="container" align="center">
		<h1>게시물 작성</h1>
		<form action="../BW" method="post" name="frm">
			<table class="boardView">
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="writer" id="writer" size="10">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="subject" id="subject" size="30">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" id="content" rows="10" cols="70"></textarea>
					</td>
				</tr>
			</table>
			<div class="bts" align="right">
				<input type="button" value="목록" onclick="location.href='/homework13/BL'">
				<input type="button" value="완료" onclick="check();">
			</div>
		</form>
	</div>
<%@ include file="../footer/footer.jsp" %>
</body>

<script type="text/javascript">
	function check() {
		var writer = document.getElementById("writer").value;
		var subject = document.getElementById("subject").value;
		var content = document.getElementById("content").value;
		
		if (writer == "") {
			alert("작성자 명이 입력되지 않았습니다.");
			writer.focus();
			return false;
		}
		if (subject == "") {
			alert("제목이 입력되지 않았습니다.");
			subject.focus();
			return false;
		}
		if (content == "") {
			alert("내용이 입력되지 않았습니다.");
			content.focus();
			return false;
		}
		
		alert("게시물 작성이 완료 되었습니다!");
		document.frm.submit();
	}
</script>
</html>