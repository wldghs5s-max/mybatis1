package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			MemberVo vo = new MemberVo();
			vo.setId(userId);
			vo.setPw(userPw);
			
			MemberVo loginMemberVo = new MemberService().login(vo);
			
			if(loginMemberVo==null) {
				throw new Exception("로그인 오류...");
			}
			req.getSession().setAttribute("loginMemberVo", loginMemberVo);
			resp.sendRedirect("/home");
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/error");
		}
	}
}
