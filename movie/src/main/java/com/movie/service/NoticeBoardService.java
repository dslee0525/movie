package com.movie.service;

import java.util.List;

import com.movie.model.Criteria;
import com.movie.model.NoticeBoardVO;

public interface NoticeBoardService {
	
	public List<NoticeBoardVO> noticeList() throws Exception;
	
	public List<NoticeBoardVO> noticeListPaging(Criteria cri) throws Exception;
	
	public NoticeBoardVO noticeDetail(int no) throws Exception;
	
	public void noticeWrite(NoticeBoardVO notice) throws Exception;
	
	public void noticeModify(NoticeBoardVO notice) throws Exception;
	
	public void noticeDelete(NoticeBoardVO notice) throws Exception;
	
	public int noticeCount(Criteria cri) throws Exception;
	
	// 조회수
	public void viewingCount(int no) throws Exception;

	public NoticeBoardVO upToDate() throws Exception;
}
