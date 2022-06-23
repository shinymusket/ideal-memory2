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
	String fever = request.getParameter("fever");
	String respirator = request.getParameter("respirator");
	String trip = request.getParameter("trip");

	if (fever.equalsIgnoreCase("n") && respirator.equalsIgnoreCase("n") && trip.equalsIgnoreCase("n")) {
%>
    <jsp:forward page="negative.jsp"></jsp:forward>
<%		
	} else {
		int r = (int) (Math.random() * 100) + 1;
		if (r % 2 == 0) {
%>			
			<jsp:forward page="positive.jsp"></jsp:forward>	
<%	
		} else {
%>
	<jsp:forward page="negative.jsp"></jsp:forward>			
<%
		}
%>

<%
	}

%>
</body>
</html>