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
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	double temp = Double.parseDouble((request.getParameter("temp")));
	
	session.setAttribute("name", name);
	session.setAttribute("temp", temp);
	
	if (temp <= 37.5 ) {
%>		
	<jsp:forward page="negative.jsp"></jsp:forward>
<%	
	} else if (temp > 37.5) {
		
%>
	<jsp:forward page="closeExam.jsp"></jsp:forward>
<%		
	}
	
%>
</body>
</html>