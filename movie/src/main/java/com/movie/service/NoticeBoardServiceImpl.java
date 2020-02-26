package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.NoticeBoardMapper;
import com.movie.model.Criteria;
import com.movie.model.NoticeBoardVO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{
	
	@Autowired
	private NoticeBoardMapper nbm;
	
	@Override
	public List<NoticeBoardVO> noticeList() throws Exception {
		return nbm.noticeList();
	}

	@Override
	public List<NoticeBoardVO> noticeListPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return nbm.noticeListPaging(cri);
	}

	@Override
	public NoticeBoardVO noticeDetail(int no) throws Exception {
		// TODO Auto-generated method stub
		return nbm.noticeDetail(no);
	}

	@Override
	public void noticeWrite(NoticeBoardVO notice) throws Exception {
		nbm.noticeWrite(notice);
		
	}

	@Override
	public void noticeModify(NoticeBoardVO notice) throws Exception {
		nbm.noticeModify(notice);
	}

	@Override
	public void noticeDelete(NoticeBoardVO notice) throws Exception {
		nbm.noticeDelete(notice);
	}

	@Override
	public int noticeCount(Criteria cri) throws Exception {
		return nbm.noticeCount(cri);
	}

	@Override
	public void viewingCount(int no) throws Exception {
		nbm.viewingCount(no);
		
	}

	@Override
	public NoticeBoardVO upToDate() throws Exception {
		return nbm.upToDate();
	}

}
