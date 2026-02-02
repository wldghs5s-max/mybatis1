package com.kh.app.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book/update")
public class BookUpdateController extends HttpServlet{
	String no;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			no = req.getParameter("no");
			BookVo vo = new BookService().detailView(no);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/book/update.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/error");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String title = req.getParameter("title");
			String price = req.getParameter("price");
			int rental = Integer.parseInt(req.getParameter(("rental")));
			BookVo vo = new BookVo();
			vo.setTitle(title);
			vo.setPrice(price);
			vo.setNo(no);

			if(rental==1) {
				vo.setRentalYn("N");
			}
			else{
				vo.setRentalYn("Y");
			}
			int result = new BookService().update(vo);
			if(result!=1) {
				throw new Exception("도서 수정 오류...");
			}
			resp.sendRedirect("/book/list");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/error");
		}
		
	}
	
	
	
}



















