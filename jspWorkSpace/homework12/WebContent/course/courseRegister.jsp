<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 등록</title>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>

	<div id="wrap" align="center">
		<h2>교과목 등록</h2>
		
		<form action="CS?command=course_register" method="post">
			<table>
				<tr>
					<th>교과목 코드</th>
					<td>
						<input type="text" name="id" required="required">
					</td>
				</tr>
				<tr>
					<th>과목 명</th>
					<td>
						<input type="text" name="courseName">
					</td>
				</tr>
				<tr>
					<th>담당 강사</th>
					<td>
						<select name="lectuer" required="required">
							<option value=''>담당 강사 선택</option>
							<c:forEach var="lectuer" items="${lectuerList}">
								<option value="${lectuer}">${lectuer}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>학점</th>
					<td>
						<input type="number" name="credit" required="required">
					</td>
				</tr>
				<tr>
					<th>요일</th>
					<td>
						<input type="radio" name="week" value="1" checked="checked">월
						<input type="radio" name="week" value="2">화
						<input type="radio" name="week" value="3">수
						<input type="radio" name="week" value="4">목
						<input type="radio" name="week" value="5">금
						<input type="radio" name="week" value="6">토
					</td>
				</tr>
				<tr>
					<th>시작</th>
					<td>
						<input type="text" name="startHour" required="required">
					</td>
				</tr>
				<tr>
					<th>종료</th>
					<td>
						<input type="text" name="endHour" required="required">
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