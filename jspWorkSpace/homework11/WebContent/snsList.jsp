<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS</title>
<script src="./jQuery/jquery-3.6.0.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="css/sns.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>SNS</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>글제목</th>
				<th>글 내용</th>
				<th>날짜</th>
			</tr>
			
			<div id="comment_list"></div>
			
	
<%-- 			<c:if test="${list != null}">
				<c:forEach var="text" items="${list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${text.title}</td>
						<td>${text.content}</td>
						<td>${text.writeDate}</td>
					</tr>
				</c:forEach>
			</c:if> --%>
		</table>
		
		<div>
			<form action="" method="post">
				<table>
					<tr>
						<th>제목</th>
						<td colspan="2">
							<input type="text" name="title" id="title">
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<textarea rows="5" cols="100" name="content" id="content"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="button" value="등록" onclick="register()">
							<input type="button" value="수정" onclick="">
							<input type="button" value="삭제" onclick="">
						</td>	
					</tr>
				</table>
			</form>
		</div>
	</div>
<script type="text/javascript">

	function register() {
		let title = $('#title').val();
		let content = $('#content').val();
		
		let textInfo = {
						"title" : title,
						"content" : content
						};
		$.ajax({
			type : "POST",
			async : true,
			url : "snsAjaxServlet",
			data : {
				"textInfo" : JSON.stringify(textInfo) // 자바 스크립트 객체를 JSON 포장해야함.
			}, success:function(result) {
				
				if(result > 0) {
					$('#title').val("");
					$('#content').val(""); 
					refresh();
				}
				
			} 
				
				
			});
	}
	
	
	
  	function refresh() {
		
		$.ajax({
			type : "POST",
			async : true,
			url : "snsAjaxServlet2",
			success: function(list) {
			var result = "";
			
			for(var i in list) {
					result +=
						"<tr>" +
						"<td>" + list[i].num  + "</td>" +
						"<td>" + list[i].title + "</td>" +
						"<td>" + list[i].content + "</td>" +
						"<td>" + list[i].writeDate + "</td>" +
						"</tr>"					
			}
				
				${"#comment_list"}.html(result);
			}
		});
	} 
	
	
</script>	
</body>
</html>