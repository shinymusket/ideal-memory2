<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 수정</title>
<link type="text/css" rel="stylesheet" href="css/course.css">
</head>
<body>
<%@ include file="/header/header.jsp" %>
	<div id="wrap" align="center">
		<h2>강사 수정</h2>
		<form action="CS?command=lectuerer_update" method="post">
			<table>
				<tr>
					<th>강사 번호</th>
					<td>
						<input type="number" name="idx" value="${lectuerer.idx}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>강사 명</th>
					<td>
						<input type="text" name="name" value="${lectuerer.name}">
					</td>
				</tr>
				<tr>
					<th>전공</th>
					<td>
						<input type="text" name="major" value="${lectuerer.major}">
					</td>
				</tr>
				<tr>
					<th>세부 전공</th>
					<td>
						<input type="text" name="field" value="${lectuerer.field}">
					</td>
				</tr>
				<tr>
					<th>담당 과목</th>
					<td>
						<c:if test="${subject != null}">
							<c:forEach var="sub" items="${subject}" varStatus="status">
								<c:if test="${!status.last}">
									${sub}, 
								</c:if>
								<c:if test="${status.last}">
									${sub}
								</c:if>
							</c:forEach>
						</c:if>
					</td>
				</tr>
				
			</table>
			<input type="button" value="목록" onclick="location.href='CS?command=lectuerer_list'">
			<input type="submit" value="완료">
		</form>
	</div>
<%@ include file="/footer/footer.jsp" %>	
</body>
</html>