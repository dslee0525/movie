package com.movie.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadVO_bak {

	private int bno;
	private int fno;
	private MultipartFile file;
	private String oriFilename;
	private String fileUrl;
	private String remark;
	private String wr_date;
	private String mod_date;
	
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
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getOriFilename() {
		return oriFilename;
	}
	public void setOriFilename(String oriFilename) {
		this.oriFilename = oriFilename;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	@Override
	public String toString() {
		return "FileUploadVO [bno=" + bno + ", fno=" + fno + ", file=" + file + ", oriFilename=" + oriFilename
				+ ", fileUrl=" + fileUrl + ", remark=" + remark + ", wr_date=" + wr_date + ", mod_date=" + mod_date
				+ "]";
	}
	
}
