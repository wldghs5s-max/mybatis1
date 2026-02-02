<%@page import="java.util.List"%>
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
		
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>가격</th>
					<th>미반납</th>
					<th>등록일자</th>
					<th>수정일자</th>
				</tr>
			</thead>		
			<tbody>
				<%List<BookVo> BookVoList = (List<BookVo>) request.getAttribute("BookVoList");
				for(BookVo vo : BookVoList){
				pageContext.setAttribute("vo", vo);%>
					<tr>
						<td><a href="/book/update?no=${vo.no}">${vo.no }</a></td>
						<td><a href="/book/update?no=${vo.no}">${vo.title}</a></td>
						<td><a href="/book/update?no=${vo.no}">${vo.price}</a></td>
						<td><a href="/book/update?no=${vo.no}">${vo.rentalYn}</a></td>
						<td><a href="/book/update?no=${vo.no}">${vo.createdAt}</a></td>
						<td><a href="/book/update?no=${vo.no}">${vo.updatedAt}</a></td>

					</tr>
					
				<%}%>
			</tbody>

		</table>
			<hr>
		<button onclick="location.href=`/book/insert`">도서 등록</button>
		<table>
			<form action="/book/list" method="get">
				<tr> 
					<td><input type="text" name="searchText" value="제목 검색"></td>
					<td><button>검색</button></td>
				</tr>
			</form>
		</table>
		

	
		
		
		
		
	</main>
</body>
</html>