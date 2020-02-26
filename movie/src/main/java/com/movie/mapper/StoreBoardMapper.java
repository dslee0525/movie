package com.movie.mapper;

import java.util.List;

import com.movie.model.Criteria;
import com.movie.model.StoreBoardVO;

public interface StoreBoardMapper {
	
	public List<StoreBoardVO> storeList(StoreBoardVO store) throws Exception;
	
	public List<StoreBoardVO> storeListPaging(Criteria cri) throws Exception;
	
	public StoreBoardVO storeDetail(int no) throws Exception;
	
	public void storeWrite(StoreBoardVO store) throws Exception;
	
	public void storeModify(StoreBoardVO store) throws Exception;
	
	public void storeDelete(StoreBoardVO store) throws Exception;
	
	public int storeCount(Criteria cri) throws Exception;
	
}
