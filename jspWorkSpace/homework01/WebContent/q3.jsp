<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
<style>
	table, td {border: 1px solid #ccc; border-collapse: collapse} 
	table {float:left; margin-left:20px;}
</style>
</head>
<body>
<%
	response.setContentType("text/html;charset=UTF-8");
	String[] dans = request.getParameterValues("dan");
%>
<h1>구구단</h1>
<%
for(String dan:dans) {
			int i = Integer.parseInt(dan); %>
			<table>
<%
			for (int j = 1; j <= 9; j++) {
%>				
				<tr>
				<td>
				<%= i + " X " + j + " = " + i*j%>
				</td>
				</tr>
<%				
			}
%>
			</table>
<%
		}
%>

</body>
</html>