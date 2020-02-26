package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.model.Criteria;
import com.movie.model.NoticeBoardVO;
import com.movie.model.PageVO;
import com.movie.service.NoticeBoardService;

@Controller
@RequestMapping("/notice")
public class NoticeBoardController {
	
	@Autowired
	private NoticeBoardService nbService;
	
	// 목록 페이지 접근
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(Criteria cri, Model model) throws Exception{
		System.out.println("공지사항 목록페이지 불러오기");
		//model.addAttribute("list",nbService.noticeList());
		
		int total = nbService.noticeCount(cri);
		System.out.println("total = "+total);
		
		PageVO pv = new PageVO(cri, total);
		System.out.println("pv = "+ pv.getStartPage());
		
		model.addAttribute("list",nbService.noticeListPaging(cri));
		model.addAttribute("page", pv);
		
	}
	
	// 글쓰기 페이지 접근
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void writeGet(Model model) throws Exception{
		System.out.println("공지사항 글쓰기 페이지 불러오기");
		
		boolean isWrite = true;
		model.addAttribute("isWrite", isWrite);
	}
	
	// 글쓰기 완료
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePost(NoticeBoardVO notice) throws Exception{
		System.out.println("글쓰기를 완료하면");
		nbService.noticeWrite(notice);
		System.out.println("notice"+notice);
		
		return "redirect:list";
	}
	
	// 상세 페이지 접근
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void viewGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("공지사항 상세페이지 불러오기");
		
		nbService.viewingCount(no);
		model.addAttribute("detail",nbService.noticeDetail(no));
		
	}
	
	// 수정 페이지 접근
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("공지사항 글 수정페이지 불러오기");
		model.addAttribute("detail",nbService.noticeDetail(no));
		
	}
	// 수정 페이지 수정 후
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(NoticeBoardVO notice) throws Exception{
		System.out.println("공지사항 글 수정페이지 수정완료");
		nbService.noticeModify(notice);
		
		return "redirect:view?no="+notice.getNo();
		
	}
}
