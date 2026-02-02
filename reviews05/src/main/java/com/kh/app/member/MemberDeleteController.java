package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = ((MemberVo)req.getSession().getAttribute("loginMemberVo"));
			String no = loginMemberVo.getNo();
			int result = new MemberService().delete(no);
			if(result!=1) {
				throw new Exception("삭제 실패...");
			}
			req.getSession().removeAttribute("loginMemberVo");
			req.getSession().setAttribute("alertMsg", "회원탈퇴 성공!");
			resp.sendRedirect("/home");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/error");
		}
	}
	
}
