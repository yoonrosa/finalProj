package com.fin.proj.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fin.proj.member.model.service.MemberService;
import com.fin.proj.member.model.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping("loginView.me")
	public String loginView() {
		return "login";
	}
	
	@GetMapping(value="login.me")
	public String login(@RequestParam(value="uId") String uId,
						@RequestParam(value="uPwd") String uPwd,
						Model model, HttpSession session) {
		
		Member loginUser = mService.login(uId, uPwd);
		System.out.println(loginUser);
		
		return "로그인 성공";
	}
	
	@RequestMapping("enroll.me")
	public String enroll() {
		return "enroll";
	}
	
	@RequestMapping("findId.me")
	public String findId() {
		return "findId";
	}
	
	@RequestMapping("findPwd.me")
	public String findPwd() {
		return "findPwd";
	}

}