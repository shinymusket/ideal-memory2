<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호 확인</title>
</head>
<body>
	<div id="wrap">
		<h1>암호 확인</h1>
		<form action="BS" method="post">
		<input type="hidden" name="command" value="board_check_pass">
		<input type="hidden" name="num" value="${param.num}">
			<table>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="확인">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						${msg}
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>