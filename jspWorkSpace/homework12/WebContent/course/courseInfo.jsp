<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 상세보기</title>
<script src="./jQuery/jquery-3.6.0.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>
		<form action="" name="frm">
			<input type="hidden" name="id" value="${course.id}">
		</form>
	<div id="wrap" align="center">
		<h2>교과목 상세보기</h2>
		<table>
			<tr>
				<th>교과목 코드</th>
				<td id="id">${course.id}</td>
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
		
		<input type="button" value="수정" onclick="location.href='CS?command=course_update_form&id=${course.id}'">
		<button id="btn" type="button" onclick="del()">삭제</button>
		<input type="button" value="목록" onclick="location.href='CS?command=course_list'">
	</div>
<%@ include file="/footer/footer.jsp" %>
</body>
<script type="text/javascript">
	
	
	
	function del() {
		var result = confirm("삭제하시겠습니까?");
		if (result == true) {
			url = "CS?command=delete_course&id="+document.frm.id.value;
			location.replace(url);
			
			// document.write('삭제!');
			// location.href = LinkTest;
			// "CS?command=deleteCourse&id="+document.frm.id.value
		} else {
			
		}
	}




</script>
</html>