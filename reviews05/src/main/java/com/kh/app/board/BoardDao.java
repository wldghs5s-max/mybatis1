package com.kh.app.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.SearchVo;

public class BoardDao {

	public int write(SqlSession ss, BoardVo vo) {
		return ss.insert("BoardMapper.write",vo);
	}

	public List<BoardVo> selectBoardList(SqlSession ss, SearchVo vo) {
		return ss.selectList("BoardMapper.selectBoardList",vo);
	}

	public BoardVo selectBoardByNo(SqlSession ss, String no) {
		return ss.selectOne("BoardMapper.selectBoardByNo",no);
	}

	public int hitBoard(SqlSession ss, String no) {
		return ss.update("BoardMapper.hitBoard",no);
	}

}
