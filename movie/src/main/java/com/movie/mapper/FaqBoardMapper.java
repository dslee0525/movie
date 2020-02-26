package com.movie.mapper;

import java.util.List;

import com.movie.model.Criteria;
import com.movie.model.FaqBoardVO;

public interface FaqBoardMapper {
	
	public List<FaqBoardVO> faqList(FaqBoardVO fv) throws Exception;
	
	public List<FaqBoardVO> faqListPaging(Criteria cri) throws Exception;
	
	public FaqBoardVO faqDetail(int no) throws Exception;
	
	public void faqWrite(FaqBoardVO faq) throws Exception;
	
	public void faqModify(FaqBoardVO faq) throws Exception;
	
	public void faqDelete(FaqBoardVO faq) throws Exception;
	
	public int faqCount(Criteria cri) throws Exception;
	
	public void viewingCount(int no) throws Exception;

}
