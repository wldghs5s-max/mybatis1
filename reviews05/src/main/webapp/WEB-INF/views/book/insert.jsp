<%@page import="com.kh.app.member.MemberVo"%>
<%@page import="com.kh.app.book.BookVo"%>
<%@page import="java.util.List"%>
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
		<h1>도서 등록</h1>
		<form action="/book/insert" method="post">
			<input type="text" name="title" placeholder="제목">
			<br>
			<input type="number" name="price" placeholder="가격">
			<br>
			<button>도서 등록</button>
		</form>
	</main>
</body>
</html>