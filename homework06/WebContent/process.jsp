<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); 
 	
	int pencil = Integer.parseInt(request.getParameter("pencil"));
	int erase = Integer.parseInt(request.getParameter("erase"));
	int pencilcase = Integer.parseInt(request.getParameter("pencilcase"));
	int ballpen = Integer.parseInt(request.getParameter("ballpen"));
	int ruler = Integer.parseInt(request.getParameter("ruler"));
	int boxCutter = Integer.parseInt(request.getParameter("boxCutter"));
	int stapler = Integer.parseInt(request.getParameter("stapler"));

	session.setAttribute("pencil", pencil);
	session.setAttribute("erase", erase);
	session.setAttribute("pencilcase", pencilcase);
	session.setAttribute("ballpen", ballpen);
	session.setAttribute("ruler", ruler);
	session.setAttribute("boxCutter", boxCutter);
	session.setAttribute("stapler", stapler);
	%>
	
	<jsp:forward page="shoppingBasket.jsp"></jsp:forward>
</body>
</html>