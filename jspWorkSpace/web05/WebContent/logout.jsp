<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션의 정보를 삭제
//	session.removeAttribute("name");
//	session.removeAttribute("id");
	
	// 세션의 정보를 한꺼번에 삭제
	session.invalidate();
	
%>

<script>
	alert('로그아웃이 정상적으로 되었습니다.');
	location.href="loginForm.jsp";
</script>