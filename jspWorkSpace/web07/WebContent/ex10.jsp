<%@page import="com.green.beans.Member2"%>
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
<c:set var="str" value="Hello" scope="request"></c:set>
<%
	request.setAttribute("str", "Hello");
%>

저장된 값 출력 : <%=request.getAttribute("str") %><br>
EL 표기로 출력 : ${str}<br>
<hr>
<c:set var="str2" value="${str}" scope="request"></c:set>
<c:set var="add" value="${10+20}" scope="request"></c:set>
합계 : ${add}<br>
<c:set var="bool" value="${10>20}" scope="request"></c:set>
10>20 결과 : ${bool}<br>
<hr>
<c:set var="m1" value="<%=new com.green.beans.Member2()%>" scope="request"></c:set>
<c:set target="${m1}" property="userId" value="ko"></c:set>
<c:set target="${m1}" property="userName" value="고길동"/>
<c:set target="${m1}" property="userPwd">
	1234
</c:set>
아이디 : ${m1.userId}<br>
비밀번호 : ${m1.userPwd}<br>
이름 : ${m1.userName}<br>
<hr>
<c:set var="chk" value="테스트"></c:set>
변수 선언후 chk 값 : ${chk}<br>
<c:remove var="chk"/>
변수 삭제후 chk 값 : ${chk}<br>
<hr>

<c:out value="${m1.userName}"></c:out>

</body>
</html>