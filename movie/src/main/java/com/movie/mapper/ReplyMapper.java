package com.movie.mapper;

import java.util.List;

import com.movie.model.Criteria;
import com.movie.model.MovieBoardVO;
import com.movie.model.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> replyList(int bno) throws Exception;
	
	public List<ReplyVO> replyListPaging(int bno, Criteria cri) throws Exception;
	
	public void replyWrite(ReplyVO reply) throws Exception;
	
	public void replyModify(ReplyVO reply) throws Exception;
	
	public void replyDelete(int rno) throws Exception;
	
	public int replyCount(int bno) throws Exception;
	
}
