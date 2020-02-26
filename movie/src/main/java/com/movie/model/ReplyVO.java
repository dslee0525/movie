package com.movie.model;

public class ReplyVO {
	private int bno;
	private int rno;
	private String replytxt;
    private String replyer;
    private String wr_date;
    private String mod_date;
    
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReplytxt() {
		return replytxt;
	}
	public void setReplytxt(String replytxt) {
		this.replytxt = replytxt;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
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
		return "ReplyVO [bno=" + bno + ", rno=" + rno + ", replytxt=" + replytxt + ", replyer=" + replyer + ", wr_date="
				+ wr_date + ", mod_date=" + mod_date + "]";
	}
    
}
