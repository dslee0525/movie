package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.MemberMapper;
import com.movie.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mm;
	
	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		
		return mm.memberLogin(member);
	}

	@Override
	public void memberJoin(MemberVO member) throws Exception {
		mm.memberJoin(member);
	}

	@Override
	public int idCheck(String id) throws Exception {
		return mm.idCheck(id);
		
	}

}
