package com.movie.service;

import java.util.List;

import com.movie.model.FileUploadVO;

public interface FileUploadService {

	public List<FileUploadVO> fileList() throws Exception;
	
	public FileUploadVO fileDetail(FileUploadVO file) throws Exception;
	
	public void fileInsert(FileUploadVO file) throws Exception;
	
	public void fileModify(FileUploadVO file) throws Exception;
	
	public void fileDelete(FileUploadVO file) throws Exception;
	
}
