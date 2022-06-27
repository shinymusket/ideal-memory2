<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원 정보 수정</title>
<link type="text/css" rel="stylesheet" href="css/shopping.css">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>
	<div class="container" align="center">
		<h2>홈쇼핑 회원 등록</h2>
		<form action="SS?command=member_update" method="post" name="frm">
			<table>
				<tr>
					<th>회원번호</th>
					<td>
						<input type="number" name="custno" id="custno" value="${member.custno}" readonly="readonly"> 
					</td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td>
						<input type="text" name="custname" id="custname" value="${member.custname}"> 
					</td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td>
						<input type="tel" name="phone" id="phone" value="${member.phone}"> 
					</td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td>
						<input type="text" name="address" id="address" value="${member.address}"> 
					</td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td>
						<input type="text" name="joindate" id="joindate" value="${member.joindate}" readonly="readonly"> 
					</td>
				</tr>
				<tr>
					<th>고객 등급 [A:VIP, B:일반, C:직원]</th>
					<td>
						<input type="text" name="grade" id="grade" value="${member.grade}"> 
					</td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td>
						<input type="text" name="city" id="city" value="${member.city}"> 
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="check();">
						<input type="button" value="조회" onclick="location.href='SS?command=member_select'"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="../footer/footer.jsp" %>
<script type="text/javascript">
	function check() {
		var custname = document.getElementById("custname").value;
		var phone = document.getElementById("phone").value;
		var address = document.getElementById("address").value;
		var grade = document.getElementById("grade").value;
		var city = document.getElementById("city").value;
		
		if (custname == "") {
			alert("회원 성명이 입력되지 않았습니다.");
			custname.focus();
			return false;
		};
		
		if (phone == "") {
			alert("회원 전화가 입력되지 않았습니다.");
			phone.focus();
			return false;
		};
		
		if (address == "") {
			alert("회원 주소가 입력되지 않았습니다.");
			address.focus();
			return false;
		};
		
		if (grade == "") {
			alert("고객 등급이 입력되지 않았습니다.");
			grade.focus();
			return false;
		};
		
		if (city == "") {
			alert("도시 코드가 입력되지 않았습니다.");
			city.focus();
			return false;
		};
		
		alert("회원정보수정이 완료 되었습니다!");
		document.frm.submit();
	}
	
</script>
</body>
</html>