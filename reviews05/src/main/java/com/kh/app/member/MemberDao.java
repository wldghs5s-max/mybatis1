package com.kh.app.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {

	public int join(SqlSession ss, MemberVo vo) {
		return ss.insert("MemberMapper.join" , vo);
	}

	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("MemberMapper.login",vo);
	}

	public int edit(SqlSession ss, MemberVo vo) {
		return ss.update("MemberMapper.editNick",vo);
	}

	public int delete(SqlSession ss, String no) {
		return ss.update("MemberMapper.delete",no);
	}

	public List<MemberVo> selectMemberList(SqlSession ss) {
		return ss.selectList("MemberMapper.selectMemberList");
		
	}

}
