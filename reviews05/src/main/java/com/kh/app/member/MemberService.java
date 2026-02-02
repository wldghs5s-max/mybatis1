package com.kh.app.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.SqlSessionTemplate;

public class MemberService {
	
	MemberDao dao = new MemberDao();

	public int join(MemberVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.join(ss,vo);
		if(result!=1) {
			ss.rollback();
			throw new Exception("join fail.. at service");
		}
		ss.commit();
		ss.close();
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		MemberVo dbVo = dao.login(ss,vo);
		ss.close();
		return dbVo;
	}

	public int edit(MemberVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.edit(ss,vo);
		if(result!=1) {
			ss.rollback();
			throw new Exception("닉네임 수정 실패.. 서비스");
		}
		ss.commit();
		ss.close();
		return result;
	}

	public int delete(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.delete(ss,no);
		if(result!=1) {
			ss.rollback();
		}
		ss.commit();
		ss.close();
		return result;
	}

	public List<MemberVo> selectMemberList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<MemberVo> voList = dao.selectMemberList(ss);
		ss.close();
		return voList;
	}

}
