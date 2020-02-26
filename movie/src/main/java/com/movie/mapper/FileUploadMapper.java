package com.movie.mapper;

import java.util.List;

import com.movie.model.FileUploadVO;
import com.movie.model.StoreBoardVO;

public interface FileUploadMapper {
	
	public List<FileUploadVO> fileList() throws Exception;
	
	public FileUploadVO fileDetail(FileUploadVO file) throws Exception;
	
	public void fileInsert(FileUploadVO file) throws Exception;
	
	public void fileModify(FileUploadVO file) throws Exception;
	
	public void fileDelete(FileUploadVO file) throws Exception;
	
}
