package com.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.service.EventBoardService;
import com.movie.service.MovieBoardService;
import com.movie.service.NoticeBoardService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private NoticeBoardService nbService;
	
	@Autowired
	private MovieBoardService mbService;
	
	@Autowired
	private EventBoardService ebService;
	
	@RequestMapping(value = "/main/index", method = RequestMethod.GET)
	public void goMain(Model model) throws Exception {
		
		String page = "isMain";
		model.addAttribute("page", page);
		
		model.addAttribute("notice",nbService.upToDate());
		model.addAttribute("movie",mbService.upToDate());
		model.addAttribute("event",ebService.upToDate());
		
	}
	
	@RequestMapping(value = "/phototicket/phototicket", method = RequestMethod.GET)
	public void goPhototicket() throws Exception {
		
	}
	
}
