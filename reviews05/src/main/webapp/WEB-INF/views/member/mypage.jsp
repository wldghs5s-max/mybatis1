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
		<h1>마이페이지</h1>
		<hr>
		<form action="/member/mypage" method="post">
			<input type="text" name="userNick" placeholder="변경할닉네임">
			<button>닉네임 수정하기</button>
			
		</form>
		<hr>
		<button onclick="location.href=`/member/delete`">회원탈퇴하기</button>
	</main>
</body>
</html>