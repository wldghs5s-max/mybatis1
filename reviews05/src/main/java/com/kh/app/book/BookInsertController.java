package com.kh.app.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.MemberVo;

@WebServlet("/book/insert")
public class BookInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMembervo = (MemberVo)req.getSession().getAttribute("loginMemberVo");
		if(loginMembervo==null || !loginMembervo.getId().equals("user01")) {
			req.getSession().setAttribute("alertMsg", "관리자 로그인후 접근가능");
			resp.sendRedirect("/home");
		}else {
			req.getRequestDispatcher("/WEB-INF/views/book/insert.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			req.setCharacterEncoding("UTF-8");
			String title = req.getParameter("title");
			String price = req.getParameter("price");
			BookVo vo = new BookVo();
			vo.setTitle(title);
			vo.setPrice(price);
			
			int result = new BookService().insert(vo);
			
			if(result!=1) {
				throw new Exception("도서등록 오류..");
			}
			resp.sendRedirect("/book/list");
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/book/list");
		}
		
	}
}
