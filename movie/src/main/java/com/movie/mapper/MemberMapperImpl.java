package com.movie.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.movie.mapper.MemberMapper";
	
	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		MemberVO user = sqlSession.selectOne(namespace+".memberLogin", member);
		return user;
	}

	@Override
	public void memberJoin(MemberVO member) throws Exception {
		sqlSession.insert(namespace+".memberJoin", member);
	}

	@Override
	public int idCheck(String id) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".idCheck", id);
		return cnt;
	}

}
