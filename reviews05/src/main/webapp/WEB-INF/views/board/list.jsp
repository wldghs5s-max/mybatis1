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
		
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>		
			<tbody>
				<%List<BoardVo> BoardVoList = (List<BoardVo>) request.getAttribute("BoardVoList");
				for(BoardVo vo : BoardVoList){
				pageContext.setAttribute("vo", vo);%>
					<tr>
						<td><a href="/board/detail?no=${vo.no}">${vo.no }</a></td>
						<td><a href="/board/detail?no=${vo.no}">${vo.title}</a></td>
						<td>${vo.writerNick}</td>
						<td>${vo.hit }</td>

					</tr>
					
				<%}%>
			</tbody>

		</table>
			<hr>
		<button onclick="location.href=`/board/write`">게시글 작성하기</button>
		<table>
			<form action="/board/list" method="get">
				<tr> 
					<td>
					  <select name="searchType" >
					    <option value="1">제목</option>
					    <option value="2">내용</option>
					    <option value="3">제목+내용</option>
					  </select>
					</td>
					<td><input type="text" name="searchText"></td>
					<td><button>검색</button></td>
				</tr>
			</form>
		</table>
		

	
		
		
		
		
	</main>
</body>
</html>