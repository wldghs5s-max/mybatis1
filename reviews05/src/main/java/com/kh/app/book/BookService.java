package com.kh.app.book;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.SqlSessionTemplate;

public class BookService {
	
	BookDao dao = new BookDao();

	public List<BookVo> selectBookList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<BookVo> dbVo = dao.selectBookList(ss);
		ss.close();
		return dbVo;
	}

	public int insert(BookVo vo) throws Exception {
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

	public BookVo detailView(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		BookVo vo = dao.detailView(ss,no);
		ss.close();
		return vo;
	}

	public int update(BookVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.update(ss,vo);
		if(result==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

}
