package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.Criteria;
import com.movie.model.EventBoardVO;
import com.movie.model.NoticeBoardVO;

@Repository
public class EventBoardMapperImpl implements EventBoardMapper{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.movie.mapper.EventBoardMapper";
	
	@Override
	public List<EventBoardVO> eventList(EventBoardVO event) throws Exception {
		List list = sqlSession.selectList(namespace+".eventList");
		return list;
	}
	
	@Override
	public List<EventBoardVO> eventListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".eventListPaging", cri);
		return list;
	}
	
	@Override
	public List<EventBoardVO> eventPast(EventBoardVO event) throws Exception {
		List list = sqlSession.selectList(namespace+".eventPast");
		return list;
	}
	
	@Override
	public List<EventBoardVO> eventPastPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".eventPastPaging", cri);
		return list;
	}

	@Override
	public EventBoardVO eventDetail(int no) throws Exception {
		EventBoardVO event = sqlSession.selectOne(namespace+".eventDetail", no);
		return event;
	}

	@Override
	public void eventWrite(EventBoardVO event) throws Exception {
		sqlSession.insert(namespace+".eventWrite", event);
		
	}

	@Override
	public void eventModify(EventBoardVO event) throws Exception {
		sqlSession.update(namespace+".eventModify", event);
		
	}

	@Override
	public void eventDelete(EventBoardVO event) throws Exception {
		sqlSession.delete(namespace+".eventDelete", event);
		
	}

	@Override
	public int eventCount(Criteria cri) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".eventCount", cri);
		return cnt;
	}
	
	@Override
	public int eventPastCount(Criteria cri) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".eventPastCount", cri);
		return cnt;
	}

	@Override
	public void viewingCount(int no) throws Exception {
		sqlSession.update(namespace+".viewingCount", no);
		
	}

	@Override
	public List<EventBoardVO> upToDate() throws Exception {
		List list = sqlSession.selectList(namespace+".upToDate");
		return list;
	}

}
