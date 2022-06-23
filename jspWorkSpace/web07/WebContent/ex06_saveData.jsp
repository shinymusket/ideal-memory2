<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>리퀘스트 내장 객체에 값을 저장</h3>
<%
	request.setAttribute("num1", 10);
	request.setAttribute("num2", 20);
%>
	<h3>표현식에서의 합계</h3>
<%=request.getAttribute("num1") %> + <%=request.getAttribute("num2") %> = <%=(Integer)request.getAttribute("num1") + (Integer)request.getAttribute("num2") %>
<hr>
	<h3>EL 표기법에서의 합계</h3>
${requestScope.num1} + ${requestScope.num2} = ${requestScope.num1 + requestScope.num2}

<hr>
<hr>
	<h3>세션 내장 객체에 값을 저장</h3>
<%
	session.setAttribute("num1", 10);
	session.setAttribute("num2", 20);
%>
	<h3>표현식에서의 합계</h3>
<%=session.getAttribute("num1") %> + <%=session.getAttribute("num2") %> = <%=(Integer)session.getAttribute("num1") + (Integer)session.getAttribute("num2") %>
<hr>
	<h3>EL 표기법에서의 합계</h3>
${sessionScope.num1} + ${sessionScope.num2} = ${sessionScope.num1 + sessionScope.num2}
</body>
</html>