package com.movie.model;

public class FileUploadVO {
	private String boardName;
	private int bno;
	private int fno;
	private String fileName;
	private String originalName;
	private String savedPath;
	private String thumbnailName;
	private String wr_date;
	private String mod_date;
	
	public FileUploadVO() {
		
	}
	
	public FileUploadVO(FileUploadVO fileVO) {
		this.boardName = fileVO.boardName;
		this.bno = fileVO.bno;
		this.fno = fileVO.fno;
		this.fileName = fileVO.fileName;
		this.originalName = fileVO.originalName;
		this.savedPath = fileVO.savedPath;
		this.wr_date = fileVO.wr_date;
		this.mod_date = fileVO.mod_date;
	}
	
	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getSavedPath() {
		return savedPath;
	}
	public void setSavedPath(String savedPath) {
		this.savedPath = savedPath;
	}
	public String getWr_date() {
		return wr_date;
	}
	public void setWr_date(String wr_date) {
		this.wr_date = wr_date;
	}
	public String getMod_date() {
		return mod_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	
	public String getThumbnailName() {
		return thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	@Override
	public String toString() {
		return "FileUploadVO [boardName=" + boardName + ", bno=" + bno + ", fno=" + fno + ", fileName=" + fileName
				+ ", originalName=" + originalName + ", savedPath=" + savedPath + ", thumbnailName=" + thumbnailName
				+ ", wr_date=" + wr_date + ", mod_date=" + mod_date + "]";
	}

}
