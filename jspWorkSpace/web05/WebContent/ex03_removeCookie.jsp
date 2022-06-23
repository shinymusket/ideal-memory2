<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 삭제</h3>
	<%
		// 쿠키를 삭제하는 기능은 존재하지 않음
		// 
		Cookie c = new Cookie("name", ""); // 이름이 같은 쿠키를 덮어쓴다.
		c.setMaxAge(0); // 쿠키 삭제
		response.addCookie(c);
	%>
</body>
</html>