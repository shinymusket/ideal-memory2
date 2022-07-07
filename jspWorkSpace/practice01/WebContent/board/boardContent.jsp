<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>${ section }-${ content.board_subject }</title>
</head>
<body>
	<div>
		<%@ include file="/home/sidebar.jsp"%>
	</div>
	<div class="w3-main w3-margin-bottom" style="margin-left: 340px; margin-right: 40px; width: 60%;">
		<div class="w3-center w3-text-white w3-round">
			<h3 style="text-transform: uppercase">${ section }</h3>
		</div>
		<div class="w3-bar">
			<c:if test="${ sel == null && find == null }">
				<button type="button" class="w3-bar-item w3-button w3-border" onclick="location.href='/practice01/BoardList.do?section=${ section }&num=${ num }'">
					<i class="fa fa-bars"></i> 글 목록
				</button>
			</c:if>
			<c:if test="${ sel != null && find != null }">
				<button type="button" class="w3-bar-item w3-button w3-border" onclick="location.href='/practice01/BoardList.do?section=${ section }&num=${ num }&sel=${ sel }&find=${ find }'">
					<i class="fa fa-bars"></i> 글 목록
				</button>
			</c:if>
			<!-- 로그인 하였을때 -->
			<c:if test="${ id != null }">
				<button type="button" class="w3-bar-item w3-button w3-border" onClick="location.href='/practice01/BoardWriteForm.do?section=${ section }'">
					<i class="fa fa-pencil-square-o"></i> 새 글 쓰기
				</button>
			</c:if>
			<!--작성자 일때  -->
			<c:if test="${ content.id == id }">
				<button type="button" class="w3-bar-item w3-button w3-border" onClick="">
					<i class="fa fa-exchange"></i> 글 수정
				</button>
				<button type="button" class="w3-bar-item w3-button w3-border">
					<i class="fa fa-remove"></i> 글 삭제
				</button>
			</c:if>
		</div>
		<!-- 게시글 내용(작성자, 작성일, 조회수, 번호, 제목, 내용) -->
		<div class="w3-article">
			<div class="w3-border w3-padding">
				<i class="fa fa-user"></i> <a href="#">${ content.id }</a><br /> 
				<i class="fa fa-calendar"></i> <fmt:formatDate value="${ content.write_date }" pattern="yy-MM-dd" />
				<div class="w3-right">
					<span><i class="fa fa-eye"></i> ${ content.readcount }</span>
				</div>
			</div>
			<div class="w3-border w3-padding">
				#${ content.board_no } <span class="w3-center w3-xlarge w3-text-blue">${ content.board_subject }</span>
			</div>
			<article class="w3-border w3-large w3-padding">${ content.board_content }</article>
		</div>
	</div>
</body>
</html>
