package com.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.model.MemberVO;
import com.movie.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGet() { 
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(MemberVO member, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("로그인을 하면");
		
		MemberVO user = mService.memberLogin(member);
		
		//model.addAttribute("login",user);
		if(user == null) {
			return "";
		} else {
			System.out.println("성공시!!, 메인화면으로........");
			System.out.println("user.getId()"+user.getId());
			session.setAttribute("user", user);
			System.out.println("session값="+session.getAttribute("user"));
			return "redirect:/main/index";
		}
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void joinGet() {
		System.out.println("join...");
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(MemberVO member) {
		System.out.println("joinPost() 까지  확인......");
		try {
			System.out.println("회원가입 성공");
			mService.memberJoin(member);
			return "redirect:login";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("회원가입 실패");
			
			return "";
		}
		
	}
	
	@RequestMapping(value="/find_pw", method=RequestMethod.GET)
	public void findPwGet() {
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/main/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	public int idCheck(@RequestBody String id) throws Exception {
		System.out.println("아이디 중복체크 확인하기......");
		int cnt = mService.idCheck(id);
		System.out.println("cnt = "+cnt);
		return cnt;
	}
}
