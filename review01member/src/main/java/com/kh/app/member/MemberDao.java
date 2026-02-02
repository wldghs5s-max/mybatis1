package com.kh.app.member;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {

	public int insert(SqlSession ss, MemberVo vo) {
		
		return ss.insert("MemberMapper.join",vo);
	}

}
