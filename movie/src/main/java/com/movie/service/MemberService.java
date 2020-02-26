package com.movie.service;

import com.movie.model.MemberVO;

public interface MemberService {
	
	public MemberVO memberLogin(MemberVO member) throws Exception;
	
	public void memberJoin(MemberVO member) throws Exception;
	
	public int idCheck(String id) throws Exception;

}
