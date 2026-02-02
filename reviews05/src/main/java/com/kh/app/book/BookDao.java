package com.kh.app.book;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BookDao {

	public List<BookVo> selectBookList(SqlSession ss) {
		return ss.selectList("BookMapper.selectBookList");
	}

	public int insert(SqlSession ss, BookVo vo) {
		return ss.insert("BookMapper.insert", vo);
	}

	public BookVo detailView(SqlSession ss, String no) {
		return ss.selectOne("BookMapper.detailView", no);
	}

	public int update(SqlSession ss, BookVo vo) {
		return ss.update("BookMapper.update",vo);
	}

}
