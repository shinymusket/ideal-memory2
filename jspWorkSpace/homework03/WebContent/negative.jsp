<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = (String) session.getAttribute("name");

%>
	<h2><%=name%>님은 음성입니다.</h2>
</body>
</html>