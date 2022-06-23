<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파라미터로 넘겨줄 값 입력</h2>
	<form action="ex04_result.jsp" method="POST">
		숫자1 : <input type="number" name="num1"><br>
		숫자2 : <input type="number" name="num2"><br>
		<input type="submit" value="합계">
	</form>
</body>
</html>