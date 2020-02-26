package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mapper.MovieBoardMapper;
import com.movie.model.Criteria;
import com.movie.model.MovieBoardVO;

@Service
public class MovieBoardServiceImpl implements MovieBoardService{
	
	@Autowired
	private MovieBoardMapper mbm;

	@Override
	public List<MovieBoardVO> movieList(MovieBoardVO movies) throws Exception {
		return mbm.movieList(movies);
	}

	@Override
	public List<MovieBoardVO> movieListPaging(Criteria cri) throws Exception {
		return mbm.movieListPaging(cri);
	}

	@Override
	public MovieBoardVO movieDetail(int no) throws Exception {
		return mbm.movieDetail(no);
	}

	@Override
	public void movieWrite(MovieBoardVO movies) throws Exception {
		mbm.movieWrite(movies);
	}

	@Override
	public void movieModify(MovieBoardVO movies) throws Exception {
		mbm.movieModify(movies);
	}

	@Override
	public void movieDelete(MovieBoardVO movies) throws Exception {
		mbm.movieDelete(movies);
	}

	@Override
	public int movieCount(Criteria cri) throws Exception {
		return mbm.movieCount(cri);
	}

	@Override
	public void viewingCount(int no) throws Exception {
		mbm.viewingCount(no);
	}

	@Override
	public List<MovieBoardVO> upToDate() throws Exception {
		return mbm.upToDate();
	}
}
