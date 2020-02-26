package com.movie.model;

public class MovieBoardVO {
	private int no;
	private String title;
	private String titleEn;
	private String content;
	private String watching_age; 
	private String director;
	private String castmates;
	private String genre;
	private String etc_info;
	private String open_date;
	private String state;
	private int cnt;
	private String wr_date;
	private String fileName;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleEn() {
		return titleEn;
	}
	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWatching_age() {
		return watching_age;
	}
	public void setWatching_age(String watching_age) {
		this.watching_age = watching_age;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCastmates() {
		return castmates;
	}
	public void setCastmates(String castmates) {
		this.castmates = castmates;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getEtc_info() {
		return etc_info;
	}
	public void setEtc_info(String etc_info) {
		this.etc_info = etc_info;
	}
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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
		return "MovieBoardVO [no=" + no + ", title=" + title + ", titleEn=" + titleEn + ", content=" + content
				+ ", watching_age=" + watching_age + ", director=" + director + ", castmates=" + castmates + ", genre="
				+ genre + ", etc_info=" + etc_info + ", open_date=" + open_date + ", state=" + state + ", cnt=" + cnt
				+ ", wr_date=" + wr_date + ", fileName=" + fileName + "]";
	}
	
}
