<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.select"/></title>
</head>
<body>
	<h2><spring:message code="member.select"/></h2>
	<form:form modelAttribute="listCommand">
		<p>
			<label> <spring:message code="member.from"/>: <form:input path="from"/> </label>
			~
			<label> <spring:message code="member.to"/> : <form:input path="to"/> </label>
			<input type="submit" value="<spring:message code="select"/>">
		</p>
	</form:form>
	<c:if test="${!empty members}">
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
			<c:forEach var="m" items="${members}">
				<tr>
					<td>${m.id}</td>
					<td>
						<a href="<c:url value="/member/detail/${m.id}"/>">${m.email}</a>
					</td>
					<td>${m.name}</td>
					<td>
						<fmt:formatDate value="${m.registerDate}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>