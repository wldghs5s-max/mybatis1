package com.kh.app.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.SqlSessionTemplate;

public class BoardService {
	
	private BoardDao dao = new BoardDao();

	public int insert(BoardVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		int result = dao.insert(ss,vo);
		
		if(result==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

	public List<BoardVo> selectBoardList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		List<BoardVo> voList = dao.selectBoardList(ss);
		
		ss.close();
		
		return voList;
	}

	public BoardVo selectBoardByNo(String no) throws Exception {
		//biz
		//ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//dao
		int result = dao.increaseHit(ss,no);
		
		if(result!=1) {
			ss.rollback();
			throw new Exception("게시글 조회수 증가 실패 ... 조회수도 못올리는데 셀렉트는 왜함 걍 하지마..");
		}
		
		BoardVo vo= dao.selectBoardByNo(ss,no);
		//tx
		ss.commit();
		//close
		ss.close();
		return vo;
	}

}
