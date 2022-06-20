<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url var="pic" value="images/stairs-g0bc8897f5_1920.jpg" scope="request"></c:url>
<div>${pic}</div>
<hr>
<img src="${pic}" alt="계단" width="500px" height="500px">
</body>
</html>