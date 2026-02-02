<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DETAIL</h1>
	<hr>
	<div>번호 : ${vo.no }</div>
	<div>제목 : ${vo.title }</div>
	<div>내용 : ${vo.content }</div>
	<div>조회수 : ${vo.hit }</div>
	<div>작성일자 : ${vo.createdAt }</div>
	<div>수정일자 : ${vo.updatedAt }</div>
</body>
</html>