<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>숫자 표기</h3>
<fmt:formatNumber value="1234567.89"/><br>
<fmt:formatNumber value="1234567.89" groupingUsed="false"/><br>
<fmt:formatNumber value=".89" type="percent"/><br>
<fmt:formatNumber value="5000" type="currency"/><br>
<fmt:formatNumber value="5000" type="currency" currencySymbol="₤"/><br>
<hr>

<h3>소수점 표시</h3>
<fmt:formatNumber value="1234567.891234567" pattern="#,#00.0#"/><br> <!-- 1,234,567.89 -->
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#"/><br>
<fmt:formatNumber value="1234567.8" pattern="#,#00.000"/><br>
<fmt:formatNumber value="12.8" pattern="#,#00.000"/><br>
<fmt:formatNumber value="12.8" pattern="0,000,000.000"/><br>

<hr>
<h3>날짜 표기</h3>
<c:set var="now" value="<%=new java.util.Date() %>"/>
<fmt:formatDate value="${now}"/><br>
<fmt:formatDate value="${now}" type="time"/><br>
<fmt:formatDate value="${now}" type="both"/><br>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/><br>

<hr>
<fmt:timeZone value="GMT">
	GMT : <fmt:formatDate value="${now}" type="both"/><br> 
</fmt:timeZone>

<fmt:timeZone value="GMT+9">
	GMT+9 : <fmt:formatDate value="${now}" type="both"/><br> 
</fmt:timeZone>

<hr>
톰캣 서버의 기본 로케일 : <%=response.getLocale() %>
<fmt:setLocale value="zh_CN"/>
로케일을 중국으로 설정한 후 로케일 확인 : <%=response.getLocale() %>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>
<hr>
톰캣 서버의 기본 로케일 : <%=response.getLocale() %>
<fmt:setLocale value="ja_JP"/>
로케일을 일본으로 설정한 후 로케일 확인 : <%=response.getLocale() %>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>
<hr>
<fmt:setLocale value="en_US"/>
로케일을 미국으로 설정한 후 로케일 확인 : <%=response.getLocale() %>
통화 : <fmt:formatNumber value="10000" type="currency"/><br>
날짜 : <fmt:formatDate value="${now}" type="both"/><br>


</body>
</html>



