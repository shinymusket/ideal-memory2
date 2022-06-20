<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.beans.Member2" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 자바빈 사용해보기
	// 자바빈 객체를 생성
	com.green.beans.Member2 m1 = new com.green.beans.Member2();

	// 자비빈 객체에 데이터 저장
	m1.setName("홍길동"); // 어떤 변수 : m1, 어떤 필드 : name, 어떤 데이터 : 홍길동
	m1.setUserId("hong");
	
	request.setAttribute("member1", m1); // 데이터 덩어리를 자바빈에 담아 한번에 전송
	// request.getRequestDispatcher("ex01_result.jsp").forward(request, response);

	// 패키지를 임포트해서 처리 할 수 있음.
	Member2 m2 = new Member2();
%>
<%-- 액션 태그로 자바빈 생성 --%>
<jsp:useBean id="m3" class="com.green.beans.Member2" scope="request"></jsp:useBean>
<%--
	com.green.beans.Member m3 = new com.green.beans.Member();
	request.setAttribute("m3", m3);
	
 --%>

이름 : <%=m3.getName() %><br>
<%m3.setName("세요"); %>
이름 : <%=m3.getName() %><br>

</body>
</html>