<%@page import="com.kh.app.member.MemberVo"%>
<%@page import="com.kh.app.board.BoardVo"%>
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
		<h1>작성하기</h1>
		<form action="/board/write" method="post">
			<input type="text" name="title" placeholder="제목" size=120 maxlength=50>
			<br>
			<textarea name= "content" rows="30px" cols="123px" placeholder="내용작성하기"></textarea>	
			<br>
			<button>게시글 작성완료</button>
		</form>
	</main>
</body>
</html>