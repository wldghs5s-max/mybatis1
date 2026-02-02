package com.kh.app.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.SearchVo;
import com.kh.app.member.MemberVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMembervo = (MemberVo)req.getSession().getAttribute("loginMemberVo");
			String searchType = req.getParameter("searchType");
			String searchText = req.getParameter("searchText");
			
			SearchVo vo = new SearchVo();
			vo.setSearchType(searchType);
			vo.setSearchText(searchText);
			
			List<BoardVo> BoardVoList = new BoardService().selectBoardList(vo);
			req.setAttribute("BoardVoList", BoardVoList);
			
			if(loginMembervo==null) {
				req.getSession().setAttribute("alertMsg", "로그인부터...");
				resp.sendRedirect("/home");
			}else {
				req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errMsg", e.getMessage());
			resp.sendRedirect("/error");
		}
	}
}
