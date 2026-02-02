<%@page import="java.util.List"%>
<%@page import="com.kh.app.member.MemberVo"%>
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
		<h1>회원리스트</h1>
		
		<table border="1">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>닉네임</th>
					<th>생성일자</th>
					<th>수정일자</th>
					<th>탈퇴여부</th>
				</tr>
			</thead>		
			<tbody>
				<%List<MemberVo> MemberVoList = (List<MemberVo>) request.getAttribute("MemberVoList");
				for(MemberVo vo : MemberVoList){
				pageContext.setAttribute("vo", vo);%>
					<tr>
						<td>${vo.no }</td>
						<td>${vo.id }</td>
						<td>${vo.pw}</td>
						<td>${vo.nick}</td>
						<td>${vo.createdAt}</td>
						<td>${vo.updatedAt}</td>
						<td>${vo.quitYn}</td>
						
					</tr>
					
				<%}%>
			</tbody>

		</table>
	</main>
</body>
</html>