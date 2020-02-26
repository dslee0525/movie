package com.movie.model;

public class PageMaker {
	
	private int totalCount; //전체게시물 갯수
	private int pageNum; // 현재 페이지 번호
	private int contentAmount=10; // 한페이지당 몇개 표시
	private int startPage=1; //현재 페이지 블록의 시작페이지
	private int endPage=5; //현재 페이지 블록의 마지막 페이지
	private boolean prev=false; //이전 버튼
	private boolean next; //다음 버튼
	private int crrntblock; // 현재 페이지 블록 
	private int lastblock; // 마지막 페이지 블록
	
	public void prevnext(int pageNum) {
		if(pageNum>0 && pageNum<6) {
			setPrev(false);
			setNext(true);
		} else if(getLastblock() == getCrrntblock()){
			setPrev(true);
			setNext(false);
		} else {
			setPrev(true);
			setNext(true);
		}
	}
	
	public int calcpage(int totalCount, int contentAmount) {
		//전체 페이지수 계산하는 함수
		int totalpage = totalCount/contentAmount;
		if(totalCount%contentAmount>0) {
			totalpage++;
		}
		return totalpage;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getContentAmount() {
		return contentAmount;
	}
	public void setContentAmount(int contentAmount) {
		this.contentAmount = contentAmount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int crrntblock) {
		this.startPage = (crrntblock*5)-4;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int getlastblock, int getcrrntblock) {
		if(getlastblock == getcrrntblock) {
			this.endPage = calcpage(getTotalCount(), getContentAmount());
		}else {
			this.endPage= getStartPage()+4;
		}
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCrrntblock() {
		return crrntblock;
	}
	public void setCrrntblock(int pageNum) {
		//페이지번호를 통해 구한다
		// 페이지번호/페이지그룹안에 페이지개수
		this.crrntblock = pageNum/5;
		if(pageNum%5>0){
			this.crrntblock++;
		}
	}
	public int getLastblock() {
		return lastblock;
	}
	public void setLastblock(int totalCount) {
		
		this.lastblock = totalCount/(5*this.contentAmount);
		if(totalCount%(5*this.contentAmount)>0) {
			this.lastblock++;
		}
	}
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", pageNum=" + pageNum + ", contentAmount=" + contentAmount
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", crrntblock=" + crrntblock + ", lastblock=" + lastblock + "]";
	}
	
}
