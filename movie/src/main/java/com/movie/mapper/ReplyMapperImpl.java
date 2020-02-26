package com.movie.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.Criteria;
import com.movie.model.NoticeBoardVO;
import com.movie.model.ReplyVO;

@Repository
public class ReplyMapperImpl implements ReplyMapper{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.movie.mapper.ReplyMapper";

	@Override
	public List<ReplyVO> replyList(int bno) throws Exception {
		List list = sqlSession.selectList(namespace+".replyList", bno);
		return list;
	}

	@Override
	public List<ReplyVO> replyListPaging(int bno, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		List list = sqlSession.selectList(namespace+".noticeList");
		return list;
	}

	@Override
	public void replyWrite(ReplyVO reply) throws Exception {
		sqlSession.insert(namespace+".replyWrite", reply);
	}

	@Override
	public void replyModify(ReplyVO reply) throws Exception {
		sqlSession.update(namespace+".replyModify", reply);
	}

	@Override
	public void replyDelete(int rno) throws Exception {
		sqlSession.delete(namespace+".replyDelete", rno);
	}

	@Override
	public int replyCount(int bno) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".replyCount", bno);
		return cnt;
	}

}
