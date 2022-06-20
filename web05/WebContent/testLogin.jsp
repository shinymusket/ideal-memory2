<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//저장된 데이터
	String s_id = "pink";
	String s_pwd = "pong";
	String s_name = "아기상어";
%>

<%
	//입력된 데이터
	String user_id = request.getParameter("userId");
	String user_pwd = request.getParameter("userPwd");

	//로그인 처리
	if(s_id.equals(user_id) && s_pwd.equals(user_pwd)) {
		// 로그인 성공시 => 로그인 정보를 세션에 저장
				
		session.setAttribute("name", s_name);
		session.setAttribute("id", s_id);
		response.sendRedirect("main.jsp");
	} else {
		// 로그인 실패시 => 홈메이지로 돌아가기
		response.sendRedirect("loginForm.jsp");
	}
%>