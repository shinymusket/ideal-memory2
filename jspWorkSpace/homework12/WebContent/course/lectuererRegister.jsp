<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 등록</title>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>
	<div id="wrap">
		<h2>강사 등록</h2>
		<form action="CS?command=lectuerer_register" method="post">
			<table>
				<tr>
					<th>강사 번호</th>
					<td>
						<input type="number" name="idx" value="${seqNum}" readonly="readonly">
					</td> 
				</tr>
				<tr>
					<th>강사 명</th>
					<td>
						<input type="text" name="name" required="required">
					</td> 
				</tr>
				<tr>
					<th>전공</th>
					<td>
						<input type="text" name="major" required="required">
					</td> 
				</tr>
				<tr>
					<th>세부 전공</th>
					<td>
						<input type="text" name="field" required="required">
					</td> 
				</tr>
			</table>
			<input type="button" value="목록" onclick="location.href='CS?command=course_list'">
			<input type="submit" value="완료">
		</form>
	</div>
<%@ include file="/footer/footer.jsp" %>	
</body>
</html>