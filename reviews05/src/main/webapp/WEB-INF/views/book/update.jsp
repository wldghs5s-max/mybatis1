<%@page import="com.kh.app.book.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/mypage.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/layout.jsp" %>
	<main>
		<h1>게시글 상세보기</h1>
	
		<hr>
		<form action="/book/update" method="post">
			<% BookVo vo = (BookVo)request.getAttribute("vo"); %>
			<div>도서 번호 : ${vo.no}</div>
			<div>제목 : ${vo.title}</div>
			<div>가격 : ${vo.price}</div>
			<div>대여중 : ${vo.rentalYn}</div>
			<div>작성일자 : ${vo.createdAt}</div>
			<div>수정일자 : ${vo.updatedAt}</div>
			<hr>
			<input type="text" name="title" value="${vo.title}">
			<br>
			<input type="number" name="price" value="${vo.price}">
			<br>
			<select name="rental">
				<option value="1">대여가능(반납완)</option>
				<option value="2">대여불가(미반납)</option>
			</select>
			<br>
			<button>변경사항 저장하기</button>
			
		</form>
	</main>
</body>
</html>