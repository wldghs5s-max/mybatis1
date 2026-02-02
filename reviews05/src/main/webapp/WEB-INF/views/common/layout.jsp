<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/static/css/layout.css">

<header>
	<div><a href="/home"><img src="/static/img/home.png" height="177px"></a></div>
	<div><a href="/home"><img src="/static/img/add.png" height="177px"></a></div>
		<div id="loginArea">
		
			
			<% if(session.getAttribute("loginMemberVo") == null){ %>
				<form action="/member/login" method="post">
					<input type="text" name="userId" placeholder="아이디">
					<input type="submit" value="로그인">
					<input type="password" name="userPw" placeholder="비밀번호">
					<a href="/member/join">회원가입</a>
					<a href="/member/find">ID/PW 찾기</a>
				</form>
			<% }else{ %>
				<div>
					${loginMemberVo.nick} 님 환영합니다.
					<hr>
					<a href="/member/mypage">마이페이지</a>
					<br>
					<a href="/member/logout">로그아웃</a>
				</div>
			<% } %>
			
		</div>
</header>

<nav>
	<div><a href="/board/list">게시판</a></div>
	<div><a href="/book/list">도서대여관리</a></div>
	<div><a href="/gallery/list">갤러리</a></div>
	<div><a href="/member/list">회원관리</a></div>
</nav>

	<% if(session.getAttribute("alertMsg") != null){ %>
			<script>
				alert("${alertMsg}");
			</script>
	<% } %>
	
	<% session.removeAttribute("alertMsg"); %>