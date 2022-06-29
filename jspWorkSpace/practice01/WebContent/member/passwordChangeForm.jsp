<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<div>
		<%@ include file="/home/sidebar.jsp" %>
	</div>
	<div class="w3-padding-large" style="margin-left:300px;margin-right:70px">
		<h3>비밀번호 변경</h3>
		<div class="w3-container">
			<form action="/practice01/PasswdChange.do" method="post" name="frm">
				<input class="w3-input w3-border" style="width:50%" type="password" name="passwd" id="passwd" required="required" placeholder="비밀번호">
				<input class="w3-input w3-border" style="width:50%" type="password" name="passwdc" id="passwdc" required="required" placeholder="비밀번호 확인">
				<input class="w3-button w3-section w3-black w3-gray" type="button" value="변경" onclick="check()">
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function check() {
		var passwd = document.getElementById('passwd').value;
		var passwdc = document.getElementById('passwdc').value;
		
		if (passwd == "") {
			alert("비밀번호를 입력하세요.");
			passwd.focus();
			return false;
		}
		
		if (passwdc == "") {
			alert("비밀번호 확인 란을 입력하세요.");
			passwdc.focus();
			return false;
		}
		
		if (passwd != passwdc) {
			alert("비밀번호가 일치하지 않습니다.")
			passwd = "";
			passwdc = "";
			passwd.focus();
		}
		
		alert("비밀번호가 변경되었습니다.")
		document.frm.submit();
	}
</script>
</html>