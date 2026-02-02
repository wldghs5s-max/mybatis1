package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.JDBCTemplate;

public class MemberDao {

	public int join(SqlSession ss, MemberVo vo) throws Exception {
		
		return ss.insert("MemberMapper.join",vo);
	}

	public MemberVo login(SqlSession ss, MemberVo vo) throws Exception {
		return ss.selectOne("MemberMapper.login",vo);
		
	}

}

















