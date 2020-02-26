package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.FaqBoardMapper;
import com.movie.model.Criteria;
import com.movie.model.FaqBoardVO;

@Service
public class FaqBoardServiceImpl implements FaqBoardService{

	@Autowired
	private FaqBoardMapper fbm;
	
	@Override
	public List<FaqBoardVO> faqList(FaqBoardVO fv) throws Exception {
		return fbm.faqList(fv);
	}

	@Override
	public List<FaqBoardVO> faqListPaging(Criteria cri) throws Exception {
		return fbm.faqListPaging(cri);
	}

	@Override
	public FaqBoardVO faqDetail(int no) throws Exception {
		return fbm.faqDetail(no);
	}

	@Override
	public void faqWrite(FaqBoardVO faq) throws Exception {
		fbm.faqWrite(faq);
	}

	@Override
	public void faqModify(FaqBoardVO faq) throws Exception {
		fbm.faqModify(faq);
	}

	@Override
	public void faqDelete(FaqBoardVO faq) throws Exception {
		fbm.faqDelete(faq);
	}

	@Override
	public int faqCount(Criteria cri) throws Exception {
		return fbm.faqCount(cri);
	}

	@Override
	public void viewingCount(int no) throws Exception {
		fbm.viewingCount(no);
	}

}
