package com.movie.model;

public class EventBoardVO {
	private int no;
	private String subject;
	private String content;
	private String writer;
	private String wr_date;
	private String open_date;
	private String end_date;
	private int cnt;
	private String fileName;
	
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
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "EventBoardVO [no=" + no + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", wr_date=" + wr_date + ", open_date=" + open_date + ", end_date=" + end_date + ", cnt=" + cnt
				+ ", fileName=" + fileName + "]";
	}
	
	
}
