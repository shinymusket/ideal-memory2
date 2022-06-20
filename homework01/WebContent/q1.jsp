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
	int korScore = Integer.parseInt(request.getParameter("korScore"));
	int engScore = Integer.parseInt(request.getParameter("engScore"));
	int mathScore = Integer.parseInt(request.getParameter("mathScore"));
	
	int sumScore = korScore + engScore + mathScore;
	double avgScore = sumScore/3.0;
%>

<h3>성적 결과</h3>
<p>국어점수 : <%=korScore%> </p>
<p>영어점수 : <%=engScore%> </p>
<p>수학점수 : <%=mathScore%> </p>
<p>총점 : <%=sumScore%> </p>
<p>평균 : <%=avgScore%> </p>
</body>
</html>