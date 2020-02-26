package com.movie.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.movie.model.FileUploadVO;
import com.movie.model.StoreBoardVO;
import com.movie.service.FileUploadService;
import com.movie.service.StoreBoardService;
import com.movie.util.UploadFileUtils;

@Controller
@RequestMapping("/store")
public class StoreBoardController {
	
	//@Autowired
	//ServletContext servletContext;
	
	//@Resource(name="uploadPath")
	//private String uploadPath;
	
	//private String uploadPath = "C:\\Users\\14Z950\\Desktop\\java_programing\\uploadTest";
	
	@Autowired
	private StoreBoardService sbService;
	
	@Autowired
	private FileUploadService fus;
	
	// 목록 페이지 접근
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(StoreBoardVO store, Model model) throws Exception{
		System.out.println("store 목록페이지 불러오기");
		/*
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("list",sbService.storeList(store));
		paramMap.put("uploadPath",uploadPath); paramMap.put("file",fus.fileList());
		*/
		
		model.addAttribute("list",sbService.storeList(store));
		//model.addAttribute("file",fus.fileList());
		//model.addAttribute("boardList", paramMap);
	}
	
	// 글쓰기 페이지 접근
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void writeGet() throws Exception{
		System.out.println("store 글쓰기 페이지 불러오기");
	}
	
	// 글쓰기 완료
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePost(StoreBoardVO store, @RequestParam MultipartFile file, HttpServletRequest request) throws Exception{
		String root_path = request.getSession().getServletContext().getRealPath("/"); 
		System.out.println("root_path="+root_path);
	    String file_path = "resources/upload";
	    String uploadPath=root_path+file_path;
	    System.out.println("uploadPath="+uploadPath);
		
		System.out.println("글쓰기를 완료하면");
		System.out.println("uploadPath =" +uploadPath);
		System.out.println("StoreBoardVO="+store);
		System.out.println("MultipartFile="+file);
		
		System.out.println("originalName"+file.getOriginalFilename());
		
		FileUploadVO fileVO = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
		//System.out.println("thumbnail = "+thumbnail);
		//model.addAttribute("thumbnail", thumbnail);
		
		store.setFileName(fileVO.getThumbnailName());
		System.out.println("store.getFileName()="+store.getFileName());
		
		sbService.storeWrite(store);
		
		fileVO.setBoardName("store");
		fus.fileInsert(fileVO);
		//model.addAttribute("fileVO", fileVO);
		
		return "redirect:list";
	}
	
	// 상세 페이지 접근
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void viewGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("store 상세페이지 불러오기");
	
		model.addAttribute("detail",sbService.storeDetail(no));
		
		FileUploadVO fileVO = new FileUploadVO();
		fileVO.setBno(no);
		fileVO.setBoardName("store");
		model.addAttribute("detailFile",fus.fileDetail(fileVO));
	}
	
	// 수정 페이지 접근
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(@RequestParam int no, Model model) throws Exception{
		System.out.println("store 글 수정페이지 불러오기");
		model.addAttribute("detail", sbService.storeDetail(no));
		
		FileUploadVO fileVO = new FileUploadVO();
		fileVO.setBno(no);
		fileVO.setBoardName("store");
		model.addAttribute("detailFile",fus.fileDetail(fileVO));
	}
	
	// 수정 페이지 수정 후
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(StoreBoardVO store, @RequestParam int fno, @RequestParam MultipartFile file, HttpServletRequest request) throws Exception{
		System.out.println("store 글 수정페이지 수정완료");
		System.out.println("file="+file);
		System.out.println("file.getOriginalFilename="+file.getOriginalFilename()+"이게뭐람......");
		
		if(!file.getOriginalFilename().isEmpty()) {
			String root_path = request.getSession().getServletContext().getRealPath("/"); 
			System.out.println("root_path="+root_path);
		    String file_path = "resources/upload";
		    String uploadPath=root_path+file_path;
		    System.out.println("uploadPath="+uploadPath);
			
			System.out.println("수정하고싶은 파일을 넣으면");
			System.out.println("originalName"+file.getOriginalFilename());
			
			FileUploadVO fileVO = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			store.setFileName(fileVO.getThumbnailName());
			System.out.println("store.getFileName()="+store.getFileName());

			fileVO.setFno(fno);
			fus.fileModify(fileVO);
		} else {
			
		}
		
		sbService.storeModify(store);
		
		return "redirect:view?no="+store.getNo();
		
	}
}
