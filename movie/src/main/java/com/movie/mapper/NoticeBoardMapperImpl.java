package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.Criteria;
import com.movie.model.NoticeBoardVO;

@Repository
public class NoticeBoardMapperImpl implements NoticeBoardMapper{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.movie.mapper.NoticeBoardMapper";
	
	@Override
	public List<NoticeBoardVO> noticeList() throws Exception {
		List list = sqlSession.selectList(namespace+".noticeList");
		return list;
	}

	@Override
	public NoticeBoardVO noticeDetail(int no) throws Exception {
		NoticeBoardVO notice = sqlSession.selectOne(namespace+".noticeDetail", no);
		return notice;
	}

	@Override
	public void noticeWrite(NoticeBoardVO notice) throws Exception {
		sqlSession.insert(namespace+".noticeWrite", notice);
		
	}

	@Override
	public void noticeModify(NoticeBoardVO notice) throws Exception {
		sqlSession.update(namespace+".noticeModify", notice);
		
	}

	@Override
	public void noticeDelete(NoticeBoardVO notice) throws Exception {
		sqlSession.delete(namespace+".noticeDelete", notice);
		
	}

	@Override
	public List<NoticeBoardVO> noticeListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".noticeListPaging", cri);
		return list;
	}

	@Override
	public int noticeCount(Criteria cri) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".noticeCount", cri);
		return cnt;
	}

	@Override
	public void viewingCount(int no) throws Exception {
		sqlSession.update(namespace+".viewingCount", no);
		
	}

	@Override
	public NoticeBoardVO upToDate() throws Exception {
		NoticeBoardVO notice = sqlSession.selectOne(namespace+".upToDate");
		return notice;
	}

}
