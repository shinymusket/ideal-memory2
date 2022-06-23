<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 수정</title>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>
	<div id="wrap" align="center">
		<h2>교과목 수정</h2>
			<form action="CS?command=course_update" method="post">
			<table>
				<tr>
					<th>교과목 코드</th>
					<td>
						<input type="text" name="id" value="${course.id}">
					</td>
				</tr>
				<tr>
					<th>과목 명</th>
					<td>
						<input type="text" name="name" value="${course.name}">
					</td>
				</tr>
				<tr>
					<th>담당 강사</th>
					<td>
						<select name="lectuer">
							<c:forEach var="lectuer" items="${lectuerList}">
								<c:if test="${lectuer eq course.lecturer}">
									<option value="${lectuer}" selected="selected">${lectuer}</option>
								</c:if>
								<c:if test="${lectuer ne course.lecturer}">
									<option value="${lectuer}">${lectuer}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>학점</th>
					<td>
						<input type="number" name="credit" value="${course.credit}">
					</td>
				</tr>
				<tr>
					<th>요일</th>
					<td>
						<c:if test="${course.week eq '월'}">
							<input type="radio" name="week" value="1" checked="checked">월
							<input type="radio" name="week" value="2">화
							<input type="radio" name="week" value="3">수
							<input type="radio" name="week" value="4">목
							<input type="radio" name="week" value="5">금
							<input type="radio" name="week" value="6">토
						</c:if>
						
						<c:if test="${course.week eq '화'}">
							<input type="radio" name="week" value="1">월
							<input type="radio" name="week" value="2" checked="checked">화
							<input type="radio" name="week" value="3">수
							<input type="radio" name="week" value="4">목
							<input type="radio" name="week" value="5">금
							<input type="radio" name="week" value="6">토
						</c:if>
						
						<c:if test="${course.week eq '수'}">
							<input type="radio" name="week" value="1">월
							<input type="radio" name="week" value="2">화
							<input type="radio" name="week" value="3" checked="checked">수
							<input type="radio" name="week" value="4">목
							<input type="radio" name="week" value="5">금
							<input type="radio" name="week" value="6">토
						</c:if>
						
						<c:if test="${course.week eq '목'}">
							<input type="radio" name="week" value="1">월
							<input type="radio" name="week" value="2">화
							<input type="radio" name="week" value="3">수
							<input type="radio" name="week" value="4" checked="checked">목
							<input type="radio" name="week" value="5">금
							<input type="radio" name="week" value="6">토
						</c:if>
						
						<c:if test="${course.week eq '금'}">
							<input type="radio" name="week" value="1">월
							<input type="radio" name="week" value="2">화
							<input type="radio" name="week" value="3">수
							<input type="radio" name="week" value="4">목
							<input type="radio" name="week" value="5" checked="checked">금
							<input type="radio" name="week" value="6">토
						</c:if>
						
						<c:if test="${course.week eq '토'}">
							<input type="radio" name="week" value="1">월
							<input type="radio" name="week" value="2">화
							<input type="radio" name="week" value="3">수
							<input type="radio" name="week" value="4">목
							<input type="radio" name="week" value="5">금
							<input type="radio" name="week" value="6" checked="checked">토
						</c:if>
					</td>
				</tr>
				<tr>
					<th>시작</th>
					<td>
						<input type="text" name="startHour" value="${course.startHour}">
					</td>
				</tr>
				<tr>
					<th>종료</th>
					<td>
						<input type="text" name="endHour" value="${course.endHour}">
					</td>
				</tr>
			</table>
			<input type="button" value="목록" onclick="location.href='CS?command=course_list'">
			<input type="reset" value="취소">
			<input type="submit" value="완료">
		
		</form>
	</div>


<%@ include file="/footer/footer.jsp" %>
</body>
</html>