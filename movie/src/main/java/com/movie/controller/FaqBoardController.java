package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.model.Criteria;
import com.movie.model.FaqBoardVO;
import com.movie.service.FaqBoardService;

@Controller
@RequestMapping("/faq")
public class FaqBoardController {
	
	@Autowired
	private FaqBoardService fbService;
	
	// 목록 페이지 접근
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(FaqBoardVO fv, Criteria cri, Model model) throws Exception{
		System.out.println("faq 목록페이지 불러오기");
		
		int total = fbService.faqCount(cri);
		System.out.println("total="+total);
		model.addAttribute("total",total);
		
		model.addAttribute("list",fbService.faqList(fv));
		
	}
	
	// 글쓰기 페이지 접근
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void writeGet() throws Exception{
		System.out.println("faq 글쓰기 페이지 불러오기");
	}
	
	// 글쓰기 완료
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePost(FaqBoardVO faq) throws Exception{
		System.out.println("글쓰기를 완료하면,");
		fbService.faqWrite(faq);
		
		System.out.println("faq"+faq);

		return "redirect:list";
	}
	
	// 상세 페이지 접근
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void viewGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("faq 상세페이지 불러오기");
		
		fbService.viewingCount(no);
		model.addAttribute("detail",fbService.faqDetail(no));
		
	}
	
	// 수정 페이지 접근
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("faq 글 수정페이지 불러오기");
		model.addAttribute("detail", fbService.faqDetail(no));
		
	}
	
	// 수정 페이지 수정 후
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(FaqBoardVO faq) throws Exception{
		System.out.println("공지사항 글 수정페이지 수정완료");
		fbService.faqModify(faq);;
		
		return "redirect:view?no="+faq.getNo();
		
	}
}
