package com.kh.app.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list")
public class MemberListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMembervo = (MemberVo)req.getSession().getAttribute("loginMemberVo");
			List<MemberVo> voList = new MemberService().selectMemberList();
			
			req.setAttribute("MemberVoList", voList);
			
			if(loginMembervo==null || !loginMembervo.getId().equals("user01")) {
				req.getSession().setAttribute("alertMsg", "관리자 로그인후 접근가능");
				resp.sendRedirect("/home");
			}else {
				req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/error");
		}
		
	}
}
