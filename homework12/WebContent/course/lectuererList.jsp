<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 목록</title>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>

	<div id="wrap" align="center">
		<h2 align="left">${count}명의 강사가 있습니다.</h2>
			<div class="right" align="right">
				<input type="button" value="교과목 보기" onclick="location.href='CS?command=course_list'">
			</div>
			<br>
			<table>
				<tr>
					<th>번호</th>
					<th>강사명</th>
					<th>전공</th>
				</tr>
				
				<c:forEach var="Lectuerer" items="${LectuererList}">
					<tr>
						<td>${Lectuerer.idx}</td>
						<td><a href="CS?command=lectuerer_info&id=${Lectuerer.idx}">${Lectuerer.name}</a></td>
						<td>${Lectuerer.major}</td>
					</tr>
				</c:forEach>

			</table>
			<br>
			<div class="right" align="right">
				<input type="button" value="강사 등록" onclick="location.href='CS?command=lectuerer_register_form'">
			</div>
	</div>

<%@ include file="/footer/footer.jsp" %>
</body>
</html>