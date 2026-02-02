<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/layout.jsp" %>
	<h1>회원가입</h1>
	<hr>
	<form action="/member/join" method="post">
		<input type="text" name="userId" placeholder="아이디 입력">
		<br>
		<input type="password" name="userPw" placeholder="비밀번호 입력">
		<br>
		<input type="text" name="userNick" placeholder="닉네임 입력">
		<br>
		<button>회원가입</button>
	</form>
</body>
</html>