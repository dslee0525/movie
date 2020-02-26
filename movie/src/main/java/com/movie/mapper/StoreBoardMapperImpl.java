package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.Criteria;
import com.movie.model.StoreBoardVO;

@Repository
public class StoreBoardMapperImpl implements StoreBoardMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "com.movie.mapper.StoreBoardMapper";
	
	@Override
	public List<StoreBoardVO> storeList(StoreBoardVO store) throws Exception {
		List list = sqlSession.selectList(namespace+".storeList", store);
		return list;
	}

	@Override
	public List<StoreBoardVO> storeListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".storeListPaging", cri);
		return list;
	}

	@Override
	public StoreBoardVO storeDetail(int no) throws Exception {
		// TODO Auto-generated method stub
		StoreBoardVO store = sqlSession.selectOne(namespace+".storeDetail", no);
		return store;
	}

	@Override
	public void storeWrite(StoreBoardVO store) throws Exception {
		sqlSession.insert(namespace+".storeWrite", store);
	}

	@Override
	public void storeModify(StoreBoardVO store) throws Exception {
		sqlSession.update(namespace+".storeModify", store);
	}

	@Override
	public void storeDelete(StoreBoardVO store) throws Exception {
		sqlSession.delete(namespace+".storeDelete", store);
	}

	@Override
	public int storeCount(Criteria cri) throws Exception {
		int cnt = sqlSession.update(namespace + ".storeCount", cri);
		return cnt;
	}

}
