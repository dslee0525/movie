package com.movie.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.movie.model.Criteria;
import com.movie.model.EventBoardVO;
import com.movie.model.FileUploadVO;
import com.movie.model.PageVO;
import com.movie.service.EventBoardService;
import com.movie.service.FileUploadService;
import com.movie.util.UploadFileUtils;

@Controller
@RequestMapping("/event")
public class EventBoardController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private EventBoardService ebService;
	
	@Autowired
	private FileUploadService fuservice;
	
	// 목록 페이지 접근
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(EventBoardVO event, Criteria cri, Model model) throws Exception{
		System.out.println("event 목록페이지 불러오기");
		
		int total = ebService.eventCount(cri);
		model.addAttribute("total",total);
		model.addAttribute("list",ebService.eventListPaging(cri));
		
	}
	// 수정 페이지 접근
	@RequestMapping(value="/past", method=RequestMethod.GET)
	public void pastGet(EventBoardVO event, Criteria cri, Model model) throws Exception{
		System.out.println("지난 이벤트 불러오기");
		
		int total = ebService.eventPastCount(cri);
		System.out.println("total = "+total);
		
		PageVO pv = new PageVO(cri, total);
		System.out.println("pv = "+ pv.getStartPage());
		model.addAttribute("total",total);
		model.addAttribute("list",ebService.eventPastPaging(cri));
	}

	
	// 글쓰기 페이지 접근
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void writeGet(Model model) throws Exception{
		System.out.println("store 글쓰기 페이지 불러오기");
		
		boolean isWrite = true;
		model.addAttribute("isWrite", isWrite);
	}
	
	// 글쓰기 완료
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePost(EventBoardVO event, @RequestParam MultipartFile file) throws Exception{
		System.out.println("글쓰기를 완료하면,");
		
		System.out.println("uploadPath =" +uploadPath);
		System.out.println("EventBoardVO ="+event);
		System.out.println("MultipartFile="+file);
		
		System.out.println("originalName"+file.getOriginalFilename());
		
		FileUploadVO fileVO = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
		event.setFileName(fileVO.getThumbnailName());
		System.out.println("event.getFileName()="+event.getFileName());
		
		ebService.eventWrite(event);
		
		fileVO.setBoardName("event");
		fuservice.fileInsert(fileVO);
		
		return "redirect:list";
	}
	
	// 상세 페이지 접근
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void viewGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("이벤트 상세페이지 불러오기");
		
		ebService.viewingCount(no);
		model.addAttribute("detail",ebService.eventDetail(no));
		
		FileUploadVO fileVO = new FileUploadVO();
		fileVO.setBno(no);
		fileVO.setBoardName("event");
		model.addAttribute("detailFile",fuservice.fileDetail(fileVO));
		
	}
	
	// 수정 페이지 접근
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("store 글 수정페이지 불러오기");
		model.addAttribute("detail", ebService.eventDetail(no));
		
		FileUploadVO fileVO = new FileUploadVO();
		fileVO.setBno(no);
		fileVO.setBoardName("event");
		model.addAttribute("detailFile",fuservice.fileDetail(fileVO));
	}
	
	// 수정 페이지 수정 후
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(EventBoardVO event, @RequestParam int fno, @RequestParam MultipartFile file) throws Exception{
		System.out.println("store 글 수정페이지 수정완료");
		
		if(!file.getOriginalFilename().isEmpty()) {
		    System.out.println("uploadPath="+uploadPath);
			
			System.out.println("수정하고싶은 파일을 넣으면");
			System.out.println("originalName"+file.getOriginalFilename());
			
			FileUploadVO fileVO = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			event.setFileName(fileVO.getThumbnailName());
			System.out.println("event.getFileName()="+event.getFileName());

			fileVO.setFno(fno);
			fuservice.fileModify(fileVO);
		} else {
			
		}
		ebService.eventModify(event);
		
		return "redirect:view?no="+event.getNo();
		
	}
	
}
