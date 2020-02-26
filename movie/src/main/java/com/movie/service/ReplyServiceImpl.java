package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.ReplyMapper;
import com.movie.model.Criteria;
import com.movie.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper rm;

	@Override
	public List<ReplyVO> replyList(int bno) throws Exception {
		return rm.replyList(bno);
	}

	@Override
	public List<ReplyVO> replyListPaging(int bno, Criteria cri) throws Exception {
		return rm.replyListPaging(bno, cri);
	}

	@Override
	public void replyWrite(ReplyVO reply) throws Exception {
		rm.replyWrite(reply);
	}

	@Override
	public void replyModify(ReplyVO reply) throws Exception {
		rm.replyModify(reply);
	}

	@Override
	public void replyDelete(int rno) throws Exception {
		rm.replyDelete(rno);
	}

	@Override
	public int replyCount(int bno) throws Exception {
		return rm.replyCount(bno);
	}
	
	

}
