package com.movie.model;

public class FaqBoardVO {
	private int no;
	private String subject;
	private String category;
	private String content;
	private String writer;
	private String wr_date;
	private int cnt;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWr_date() {
		return wr_date;
	}
	public void setWr_date(String wr_date) {
		this.wr_date = wr_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "FaqBoardVO [no=" + no + ", subject=" + subject + ", category=" + category + ", content=" + content
				+ ", writer=" + writer + ", wr_date=" + wr_date + ", cnt=" + cnt + "]";
	}
	
}
