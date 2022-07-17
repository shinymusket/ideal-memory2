<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직원 등록</title>
</head>
<body>
	<h1>교직원 등록</h1>
	<input type="button" value="홈으로" onclick="location.href='../index'">
	<form action="./staff_register" method="POST">
		<table border="1">
			<tr>
				<th>교직원 코드</th>
				<td>
					<input type="text" name="staff_num" id="staff_num" value="${nextSeq}" readonly="readonly">
				</td>
				<th>구분</th>
				<td>
					<select name="staff_cls" id="staff_cls"> <!-- 구분항목도 추가할 수 있도록 추후 수정 예정 -->
						<option value="원장">원장</option>
						<option value="교사">교사</option>
						<option value="영양사">영양사</option>
						<option value="버스기사">버스기사</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="staff_id" id="staff_id">
				</td>
				<th>이름</th>
				<td>
					<input type="text" name="staff_name" id="staff_name"> 
				</td>
			</tr>
			<tr>
				<th>주민등록번호</th>
				<td>
					<input type="text" name="staff_rrn" id="staff_rrn" placeholder="ex)110011-0000000">
				</td>
				<th>주소</th>
				<td>
					<input type="text" name="staff_addr" id="staff_addr">
				</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" name="staff_zipcode" id="staff_zipcode">
				</td>
				<th>연락처</th>
				<td>
					<input type="tel" name="staff_tel" id="staff_tel">
				</td>
			</tr>
			<tr>
				<th>입사일</th>
				<td>
					<input type="text" name="staff_hireD" id="staff_hireD" placeholder="예)220716">
				</td>
				<th>퇴사일</th>
				<td>
					<input type="text" name="staff_retireD" id="staff_retireD">
				</td>
			</tr>
			<tr>
				<th>재직여부</th>
				<td>
					<select name="staff_workYn" id="staff_workYn">
						<option value="Y">재직</option>
						<option value="N">퇴사</option>
					</select>
				</td>
				<th>월급</th>
				<td>
					<input type="number" name="staff_salary" id="staff_salary"> 
				</td>
			</tr>
			<tr>
				<th colspan="2">이메일</th>
				<td colspan="2">
					<input type="email" name="staff_email" id="staff_email">
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="등록"> <!-- 추후 유효성 검사 구현 / 그런데 유효성 검사가 꼭 필요할지? 주민등록번호 입력값 유효성 검사가 꼭 필요해보인다.-->
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>