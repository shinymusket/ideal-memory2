<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정밀 검사</title>
</head>
<body>
	<h1>정밀 검사</h1>
	<form action="finalExam.jsp" method="POST">
		발열 증상 여부(y/n)
		<input type="radio" name="fever" value="y">
		<input type="radio" name="fever" value="n" checked><br>
		호흡기 증상 여부(y/n)
		<input type="radio" name="respirator" value="y">
		<input type="radio" name="respirator" value="n" checked><br>
		2주내 해외 여행 여부(y/n)
		<input type="radio" name="trip" value="y">
		<input type="radio" name="trip" value="n" checked><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>