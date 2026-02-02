package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/mypage")
public class MemberMypageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMembervo = (MemberVo)req.getSession().getAttribute("loginMemberVo");
		if(loginMembervo==null) {
			req.getSession().setAttribute("alertMsg", "로그인부터...");
			resp.sendRedirect("/home");
		}else {
			req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String userNick = req.getParameter("userNick");
			MemberVo loginMemberVo = ((MemberVo)req.getSession().getAttribute("loginMemberVo"));
			String no = loginMemberVo.getNo();
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setNick(userNick);
			int result = new MemberService().edit(vo);
			
			if(result!=1) {
				throw new Exception("닉네임 변경 오류...");
			}
			String userId = loginMemberVo.getId();
			String userPw = loginMemberVo.getPw();
			MemberVo login = new MemberVo();
			login.setId(userId);
			login.setPw(userPw);
			req.getSession().removeAttribute("loginMemberVo");
			MemberVo dbVo = new MemberService().login(login);
			req.getSession().setAttribute("loginMemberVo", dbVo);
			resp.sendRedirect("/home");
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/error");
		}
		
	}
}




















