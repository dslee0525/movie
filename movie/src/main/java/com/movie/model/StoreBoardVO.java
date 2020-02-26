package com.movie.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class StoreBoardVO {
	
	private int no;
    private String subject;
    private String category;
    private String summary;
    private String content;
    private String component;
    private String expiry_date;
    private int price;
    private int sale_price;
    private String wr_date;
    private String fileName;
    
    
    /* 
	private String filename;
	private List<MultipartFile> files;
	
	private FileUploadVO filevo; */
    
	/*
	 * public String getFile() { return file; } public void setFile(String file) {
	 * this.file = file; }
	 */
    
    
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSale_price() {
		return sale_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	public String getWr_date() {
		return wr_date;
	}
	public void setWr_date(String wr_date) {
		this.wr_date = wr_date;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "StoreBoardVO [no=" + no + ", subject=" + subject + ", category=" + category + ", summary=" + summary
				+ ", content=" + content + ", component=" + component + ", expiry_date=" + expiry_date + ", price="
				+ price + ", sale_price=" + sale_price + ", wr_date=" + wr_date + ", fileName=" + fileName + "]";
	}
 
}
