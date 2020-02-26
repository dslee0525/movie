package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.model.Criteria;
import com.movie.model.MovieBoardVO;

@Repository
public class MovieBoardMapperImpl implements MovieBoardMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "com.movie.mapper.MovieBoardMapper";
	

	@Override
	public List<MovieBoardVO> movieList(MovieBoardVO movies) throws Exception {
		List list = sqlSession.selectList(namespace+".movieList", movies);
		return list;
	}

	@Override
	public List<MovieBoardVO> movieListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".movieListPaging", cri);
		return list;
	}

	@Override
	public MovieBoardVO movieDetail(int no) throws Exception {
		MovieBoardVO movies = sqlSession.selectOne(namespace+".movieDetail", no);
		return movies;
	}

	@Override
	public void movieWrite(MovieBoardVO movies) throws Exception {
		sqlSession.insert(namespace+".movieWrite", movies);
	}

	@Override
	public void movieModify(MovieBoardVO movies) throws Exception {
		sqlSession.update(namespace+".movieModify", movies);
	}

	@Override
	public void movieDelete(MovieBoardVO movies) throws Exception {
		sqlSession.delete(namespace+".movieDelete", movies);
	}

	@Override
	public int movieCount(Criteria cri) throws Exception {
		int cnt = sqlSession.update(namespace + ".movieCount", cri);
		return cnt;
	}

	@Override
	public void viewingCount(int no) throws Exception {
		sqlSession.update(namespace+".viewingCount", no);
	}

	
	//메인페이지 글 출력
	@Override
	public List<MovieBoardVO> upToDate() throws Exception {
		List list = sqlSession.selectList(namespace+".upToDate");
		return list;
	}
	
	

}
