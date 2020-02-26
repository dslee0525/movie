package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.EventBoardMapper;
import com.movie.model.Criteria;
import com.movie.model.EventBoardVO;

@Service
public class EventBoardServiceImpl implements EventBoardService {

	@Autowired
	private EventBoardMapper ebm;	
	
	@Override
	public List<EventBoardVO> eventList(EventBoardVO event) throws Exception {
		return ebm.eventList(event);
	}

	@Override
	public List<EventBoardVO> eventListPaging(Criteria cri) throws Exception {
		return ebm.eventListPaging(cri);
	}
	
	@Override
	public List<EventBoardVO> eventPast(EventBoardVO event) throws Exception {
		return ebm.eventPast(event);
	}
	
	@Override
	public List<EventBoardVO> eventPastPaging(Criteria cri) throws Exception {
		return ebm.eventPastPaging(cri);
	}

	@Override
	public EventBoardVO eventDetail(int no) throws Exception {
		return ebm.eventDetail(no);
	}

	@Override
	public void eventWrite(EventBoardVO event) throws Exception {
		ebm.eventWrite(event);
	}

	@Override
	public void eventModify(EventBoardVO event) throws Exception {
		ebm.eventModify(event);
	}

	@Override
	public void eventDelete(EventBoardVO event) throws Exception {
		ebm.eventDelete(event);
	}

	@Override
	public int eventCount(Criteria cri) throws Exception {
		return ebm.eventCount(cri);
	}

	@Override
	public int eventPastCount(Criteria cri) throws Exception {
		return ebm.eventPastCount(cri);
	}
	
	
	@Override
	public void viewingCount(int no) throws Exception {
		ebm.viewingCount(no);
	}

	@Override
	public List<EventBoardVO> upToDate() throws Exception {
		return ebm.upToDate();
	}

}
