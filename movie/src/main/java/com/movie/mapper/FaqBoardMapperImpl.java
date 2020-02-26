package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.Criteria;
import com.movie.model.FaqBoardVO;

@Repository
public class FaqBoardMapperImpl implements FaqBoardMapper{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.movie.mapper.FaqBoardMapper";

	@Override
	public List<FaqBoardVO> faqList(FaqBoardVO fv) throws Exception {
		List list = sqlSession.selectList(namespace + ".faqList",fv);
		return list;
	}

	@Override
	public List<FaqBoardVO> faqListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace + ".faqListPaging", cri);
		return list;
	}

	@Override
	public FaqBoardVO faqDetail(int no) throws Exception {
		FaqBoardVO faq = sqlSession.selectOne(namespace + ".faqListPaging", no);
		return faq;
	}

	@Override
	public void faqWrite(FaqBoardVO faq) throws Exception {
		sqlSession.insert(namespace + ".faqWrite", faq);
		
	}

	@Override
	public void faqModify(FaqBoardVO faq) throws Exception {
		sqlSession.update(namespace + ".faqModify", faq);
	}

	@Override
	public void faqDelete(FaqBoardVO faq) throws Exception {
		sqlSession.update(namespace + ".faqDelete", faq);
	}

	@Override
	public int faqCount(Criteria cri) throws Exception {
		int cnt = sqlSession.selectOne(namespace + ".faqCount", cri);
		return cnt;
	}

	@Override
	public void viewingCount(int no) throws Exception {
		sqlSession.update(namespace + ".viewingCount", no);
	}

}
