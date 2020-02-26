package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.FileUploadMapper;
import com.movie.model.FileUploadVO;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Autowired
	private FileUploadMapper fum;
	
	@Override
	public List<FileUploadVO> fileList() throws Exception {
		return fum.fileList();
	}

	@Override
	public FileUploadVO fileDetail(FileUploadVO file) throws Exception {
		return fum.fileDetail(file);
	}
	
	@Override
	public void fileInsert(FileUploadVO file) throws Exception {
		fum.fileInsert(file);
	}

	@Override
	public void fileModify(FileUploadVO file) throws Exception {
		fum.fileModify(file);
	}

	@Override
	public void fileDelete(FileUploadVO file) throws Exception {
		fum.fileDelete(file);
	}

}
