package com.kh.app.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.SearchVo;
import com.kh.app.db.SqlSessionTemplate;

public class BoardService {
	
	BoardDao dao = new BoardDao();

	public int write(BoardVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		int result = dao.write(ss,vo);
		if(result!=1) {
			ss.rollback();
			throw new Exception("게시글 작성실패.. 서비스");
		}
		ss.commit();
		ss.close();
		return result;
	}

	public List<BoardVo> selectBoardList(SearchVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<BoardVo> dbVo = dao.selectBoardList(ss,vo);
		ss.close();
		return dbVo;
	}

	public BoardVo selectBoardByNo(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		BoardVo vo = dao.selectBoardByNo(ss, no);
		ss.close();
		return vo;
	}

}
