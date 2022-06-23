<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>전달된 값을 출력</h3>
	<h5>1. request객체를 활용한 방법</h5>
	아이디 : <%=request.getParameter("userId") %><br>
	비밀번호 : <%=request.getParameter("userPwd") %><br>
	
	<h5>2. EL 표기를  활용한 방법</h5>
	아이디 : ${param.userId}<br>
	비밀번호 : ${param["userPwd"]}<br>
</body>
</html>