package com.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.movie.model.Criteria;
import com.movie.model.FileUploadVO;
import com.movie.model.MemberVO;
import com.movie.model.PageVO;
import com.movie.model.ReplyVO;
import com.movie.model.StoreBoardVO;
import com.movie.service.FileUploadService;
import com.movie.service.ReplyService;
import com.movie.service.StoreBoardService;
import com.movie.util.UploadFileUtils;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService rservice;

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO reply, HttpServletRequest request){

		System.out.println("ReplyVO :"+reply);
		ResponseEntity<String> entity = null;
		HttpSession session = request.getSession();
		
		try {
			MemberVO userId = (MemberVO)session.getAttribute("userId");
			reply.setReplyer(userId.getId());
			System.out.println("reply.getReplyer()="+reply.getReplyer());
			rservice.replyWrite(reply);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno){
		System.out.println("bno :"+bno);
		ResponseEntity<List<ReplyVO>> entity = null;

		try {
			entity = new ResponseEntity<List<ReplyVO>>(rservice.replyList(bno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value="/all/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPaging(@PathVariable("bno") int bno, @PathVariable("page") int page){
		System.out.println("bno :"+bno);

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria cri =new Criteria();
			cri.setPageNum(page);

			int cnt = rservice.replyCount(bno);
			PageVO pv = new PageVO(cri, cnt);

			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> list = rservice.replyListPaging(bno, cri);

			map.put("list", list); //게시판 관련
			map.put("pv", pv); //페이징 관련

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			System.out.println("entity==>"+entity);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value="/{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReplyVO reply){
		System.out.println("ReplyVO :"+rno);
		ResponseEntity<String> entity = null;

		try {
			reply.setRno(rno);
			rservice.replyModify(reply);

			entity = new ResponseEntity<String>("Modify", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	

	@RequestMapping(value="/{rno}", method= RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno") int rno){
		
		System.out.println("ReplyVO :"+rno);
		ResponseEntity<String> entity = null;

		try {
			
			rservice.replyDelete(rno);
			entity = new ResponseEntity<String>("Delete", HttpStatus.OK);
		
		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);

		}

		return entity;
	}
}
