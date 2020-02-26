package com.movie.mapper;

import java.util.List;

import com.movie.model.Criteria;
import com.movie.model.EventBoardVO;
import com.movie.model.MovieBoardVO;

public interface EventBoardMapper {
	
	public List<EventBoardVO> eventList(EventBoardVO event) throws Exception;
	
	public List<EventBoardVO> eventListPaging(Criteria cri) throws Exception;
	
	//지난이벤트
	public List<EventBoardVO> eventPast(EventBoardVO event) throws Exception;
	
	//지난이벤트 페이징
	public List<EventBoardVO> eventPastPaging(Criteria cri) throws Exception;
	
	public EventBoardVO eventDetail(int no) throws Exception;
	
	public void eventWrite(EventBoardVO event) throws Exception;
	
	public void eventModify(EventBoardVO event) throws Exception;
	
	public void eventDelete(EventBoardVO event) throws Exception;
	
	public int eventCount(Criteria cri) throws Exception;
	
	public int eventPastCount(Criteria cri) throws Exception;
	
	public void viewingCount(int no) throws Exception;
	
	//메인 출력 최신글
	public List<EventBoardVO> upToDate() throws Exception;
}
