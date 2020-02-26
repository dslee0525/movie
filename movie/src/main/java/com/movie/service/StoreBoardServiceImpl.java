package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.StoreBoardMapper;
import com.movie.model.Criteria;
import com.movie.model.StoreBoardVO;

@Service
public class StoreBoardServiceImpl implements StoreBoardService{
	
	@Autowired
	private StoreBoardMapper sbm;
	
	@Override
	public List<StoreBoardVO> storeList(StoreBoardVO store) throws Exception {
		return sbm.storeList(store);
	}

	@Override
	public List<StoreBoardVO> storeListPaging(Criteria cri) throws Exception {
		return sbm.storeListPaging(cri);
	}

	@Override
	public StoreBoardVO storeDetail(int no) throws Exception {
		return sbm.storeDetail(no);
	}

	@Override
	public void storeWrite(StoreBoardVO store) throws Exception {
		sbm.storeWrite(store);
	}

	@Override
	public void storeModify(StoreBoardVO store) throws Exception {
		sbm.storeModify(store);
	}

	@Override
	public void storeDelete(StoreBoardVO store) throws Exception {
		sbm.storeDelete(store);
	}

	@Override
	public int storeCount(Criteria cri) throws Exception {
		return sbm.storeCount(cri);
	}

}
