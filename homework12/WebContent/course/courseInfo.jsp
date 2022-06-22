<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 상세보기</title>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>
	<div id="wrap" align="center">
		<h2>교과목 상세보기</h2>
		<table>
			<tr>
				<th>교과목 코드</th>
				<td>${course.id}</td>
			</tr>
			<tr>
				<th>과목 명</th>
				<td>${course.name}</td>
			</tr>
			<tr>
				<th>담당 강사</th>
				<td>${course.lecturer}</td>
			</tr>
			<tr>
				<th>학점</th>
				<td>${course.credit}</td>
			</tr>
			<tr>
				<th>요일</th>
				<td>${course.week}</td>
			</tr>
			<tr>
				<th>시작</th>
				<td>
					<fmt:formatNumber value="${course.startHour}" pattern="0000"/>
				</td>
			</tr>
			<tr>
				<th>종료</th>
				<td>
					<fmt:formatNumber value="${course.endHour}" pattern="0000"/>
				</td>
			</tr>
		</table>
		<input type="button" value="수정">
		<input type="button" value="삭제">
		<input type="button" value="목록" onclick="location.href='CS?command=course_list'">
	</div>
<%@ include file="/footer/footer.jsp" %>
</body>
</html>