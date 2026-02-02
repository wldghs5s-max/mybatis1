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
			<div>게시글 번호 : ${vo.no}</div>
			<div>제목 : ${vo.title}</div>
			<div>조회수 : ${vo.hit}</div>
			<div>내용 : ${vo.content}</div>
			<div>작성일자 : ${vo.createdAt}</div>
			<div>수정일자 : ${vo.updatedAt}</div>
		</div>
	</main>
</body>
</html>