package com.movie.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.movie.model.FileUploadVO;
import com.movie.model.MemberVO;
import com.movie.model.MovieBoardVO;
import com.movie.model.ReplyVO;
import com.movie.service.FileUploadService;
import com.movie.service.MovieBoardService;
import com.movie.service.ReplyService;
import com.movie.util.UploadFileUtils;

@Controller
@RequestMapping("/movies")
public class MovieBoardController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private MovieBoardService mbService;
	
	@Autowired
	private ReplyService rservice;
	
	@Autowired
	private FileUploadService fuservice;
	
	// 목록 페이지 접근
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(MovieBoardVO movies, Model model) throws Exception{
		System.out.println("무비차트 목록페이지 불러오기");
		model.addAttribute("list",mbService.movieList(movies));
	}
	
	// 글쓰기 페이지 접근
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void writeGet(Model model) throws Exception{
		System.out.println("무비차트 글쓰기 페이지 불러오기");
		
		boolean isWrite = true;
		model.addAttribute("isWrite", isWrite);
		
	}
	
	// 글쓰기 완료
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePost(MovieBoardVO movies, @RequestParam MultipartFile file) throws Exception{
		System.out.println("글쓰기를 완료하면");
		
		System.out.println("uploadPath =" +uploadPath);
		System.out.println("MovieBoardVO ="+movies);
		System.out.println("MultipartFile="+file);
		
		System.out.println("originalName"+file.getOriginalFilename());
		
		FileUploadVO fileVO = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
		//System.out.println("thumbnail = "+thumbnail);
		//model.addAttribute("thumbnail", thumbnail);
		
		movies.setFileName(fileVO.getThumbnailName());
		System.out.println("movies.getFileName()="+movies.getFileName());
		
		mbService.movieWrite(movies);
		
		fileVO.setBoardName("movies");
		fuservice.fileInsert(fileVO);
		//model.addAttribute("fileVO", fileVO);
		
		return "redirect:list";
	}
	
	// 상세 페이지 접근
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void viewGet(@RequestParam int no, Model model, HttpSession session) throws Exception{
		System.out.println("무비 상세페이지 불러오기");
		
		mbService.viewingCount(no);
		model.addAttribute("detail",mbService.movieDetail(no));
		
		FileUploadVO fileVO = new FileUploadVO();
		fileVO.setBno(no);
		fileVO.setBoardName("movies");
		model.addAttribute("detailFile",fuservice.fileDetail(fileVO));
		
		model.addAttribute("list",rservice.replyList(no));
		
	}
	
	// 수정 페이지 접근
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("무비차트 글 수정페이지 불러오기");
		model.addAttribute("detail",mbService.movieDetail(no));
		
		FileUploadVO fileVO = new FileUploadVO();
		fileVO.setBno(no);
		fileVO.setBoardName("movies");
		model.addAttribute("detailFile",fuservice.fileDetail(fileVO));
	}
	// 수정 페이지 수정 후
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(MovieBoardVO movies, @RequestParam int fno, @RequestParam MultipartFile file) throws Exception{
		System.out.println("공지사항 글 수정페이지 수정완료");
		
		if(!file.getOriginalFilename().isEmpty()) {
		    System.out.println("uploadPath="+uploadPath);
			
			System.out.println("수정하고싶은 파일을 넣으면");
			System.out.println("originalName"+file.getOriginalFilename());
			
			FileUploadVO fileVO = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			movies.setFileName(fileVO.getThumbnailName());
			System.out.println("movies.getFileName()="+movies.getFileName());

			fileVO.setFno(fno);
			fuservice.fileModify(fileVO);
		} else {
			
		}
		mbService.movieModify(movies);
		
		return "redirect:view?no="+movies.getNo();
		
	}
}
