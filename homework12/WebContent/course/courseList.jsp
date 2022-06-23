<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 목록</title>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>

	<div id="wrap" align="center">
		<h2 align="left">총 ${count}개의 교과목이 있습니다.</h2>
			<div class="right" align="right">
				<input type="button" value="강사 보기" onclick="location.href='CS?command=lectuerer_list'">
			</div>
			<br>
			<table>
				<tr>
					<th>과목 코드</th>
					<th>과목 명</th>
					<th>학점</th>
					<th>담당 강사</th>
					<th>요일</th>
				</tr>
				
				<c:forEach var="course" items="${courseList}">
					<tr>
						<td>${course.id}</td>
						<td><a href="CS?command=course_info&id=${course.id}">${course.name}</a></td>
						<td>${course.credit}</td>
						<td>${course.lecturer}</td>
						<td>${course.week}</td>
					</tr>
				</c:forEach>

			</table>
			<br>
			<div class="right" align="right">
				<input type="button" value="교과목 등록" onclick="location.href='CS?command=course_register_form'">
			</div>
	</div>

<%@ include file="/footer/footer.jsp" %>
</body>
</html>