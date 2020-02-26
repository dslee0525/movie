package com.movie.mapper;

import com.movie.model.MemberVO;

public interface MemberMapper {

	public MemberVO memberLogin(MemberVO member) throws Exception;
	
	public void memberJoin(MemberVO member) throws Exception;
	
	public int idCheck(String id) throws Exception;
	
}
