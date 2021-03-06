package com.movie.mapper;

import java.util.List;

import com.movie.model.Criteria;
import com.movie.model.MovieBoardVO;

public interface MovieBoardMapper {
	
	public List<MovieBoardVO> movieList(MovieBoardVO movies) throws Exception;
	
	public List<MovieBoardVO> movieListPaging(Criteria cri) throws Exception;
	
	public MovieBoardVO movieDetail(int no) throws Exception;
	
	public void movieWrite(MovieBoardVO movies) throws Exception;
	
	public void movieModify(MovieBoardVO movies) throws Exception;
	
	public void movieDelete(MovieBoardVO movies) throws Exception;
	
	public int movieCount(Criteria cri) throws Exception;
	
	// 조회수
	public void viewingCount(int no) throws Exception;
	
	public List<MovieBoardVO> upToDate() throws Exception;
	
}
