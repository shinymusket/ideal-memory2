<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! // 선언문은 _jspService 메서드 외부
	public int abs(int n) {
		if(n < 0) {
			n = -n;
		}
	return n;
	
	}

	String name = "홍길동";
	int a = 5, b = -5;
%>


	<%
		String subject = "Servlet";
	
	%>
	<h1>Hello <% out.println(subject); %>!!</h1>
	<hr>
	<%
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		
		out.println(num1 + "+" + num2 + "=" + result); // 10 + 20 = 30
	
	//스크립트릿 내부는 _jspService 메서드 내부
/*		public int abs(int n) {
			if(n < 0) {
				n = -n;
			}
			return n;
		}
		*/
		
		out.println("<br>이름 : " + name + "<br>");
		out.println(a + "의 절대값 : " + abs(a) + "<br>");
		out.println(b + "의 절대값 : " + abs(b) + "<br>");
		
		
	%>

	
	<%= a + "의 절대값 : " + abs(a) %> <br>
	<%-- JSP 전용 주석문 : 노출되면 곤란한 정보 --%>
	
	<!-- HTML 주석문 : 노출되어도 상관없는 정보 -->
	
</body>
</html>