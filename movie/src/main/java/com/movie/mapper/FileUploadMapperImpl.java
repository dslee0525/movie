package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.FileUploadVO;


@Repository
public class FileUploadMapperImpl implements FileUploadMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "com.movie.mapper.FileUploadMapper";
	
	@Override
	public List<FileUploadVO> fileList() throws Exception {
		List list = sqlSession.selectList(namespace+".fileList");
		return list;
	}
	@Override
	public FileUploadVO fileDetail(FileUploadVO file) throws Exception {
		FileUploadVO fileVO=sqlSession.selectOne(namespace+".fileDetail", file);
		return fileVO;
	}
	@Override
	public void fileInsert(FileUploadVO file) throws Exception {
		sqlSession.insert(namespace+".fileInsert", file);
	}
	@Override
	public void fileModify(FileUploadVO file) throws Exception {
		sqlSession.update(namespace+".fileModify", file);
		
	}
	@Override
	public void fileDelete(FileUploadVO file) throws Exception {
		sqlSession.delete(namespace+".fileDelete", file);
		
	}

}
