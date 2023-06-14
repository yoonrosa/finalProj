package com.fin.proj.volunteer.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fin.proj.common.Pagination;
import com.fin.proj.common.model.vo.PageInfo;
import com.fin.proj.member.model.vo.Member;
import com.fin.proj.volunteer.model.service.VolunteerService;
import com.fin.proj.volunteer.model.vo.Volunteer;

import jakarta.servlet.http.HttpSession;

@Controller
public class VolunteerController {
	
	@Autowired
	private VolunteerService vService;
	
	@GetMapping("volunteer.vo")
	public String volunteer(@RequestParam(value="page", required=false) Integer currentPage, Model model) {
		if(currentPage == null) {
			currentPage = 1;
		}
		
		int volunteerCount = vService.getVolunteerCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, volunteerCount, 5);
		ArrayList<Volunteer> list = vService.selectVolunteerList(pi);
		
		System.out.println(volunteerCount);
		System.out.println(list);
		
		if(list != null) {
			model.addAttribute("pi", pi);
			model.addAttribute("list", list);
			
			return "volunteer";
		}
		return null;
	}
	
	@GetMapping("volunteerDetail.vo")
	public String volunteerDetail(@RequestParam("vNo") int vNo, @RequestParam("page") int page, Model model) {
		Volunteer v = vService.selectVolunteer(vNo);
		System.out.println(v);
		if(v != null) {
			model.addAttribute("v", v);
			model.addAttribute("page", page);
			return "volunteerDetail";
		}
		return null;
	}
	
	@GetMapping("volunteerApply.vo")
	public String volunteerApply() {
		return "volunteerApply";
	}
	
	@GetMapping("volunteerHistory.vo")
	public String volunteerHistory() {
		return "volunteerHistory";
	}
	
	// 관리자
	@GetMapping("volunteerEnroll.vo")
	public String volunteerEnroll() {
		return "volunteerEnroll";
	}
	
	@GetMapping("volunteerEnrollHistory.vo")
	public String volunteerEnrollHistory() {
		return "volunteerEnrollHistory";
	}
	
	@GetMapping("volunteerEdit.vo")
	public String volunteerEdit() {
		return "volunteerEdit";
	}
	
	@PostMapping("insertVolunteer.vo")
	public String insertVolunteer(@ModelAttribute Volunteer v, HttpSession session) {
//		System.out.println((Member)session.getAttribute("loginUser"));
		v.setuNo(((Member)session.getAttribute("loginUser")).getuNo());
		System.out.println(v);
		int result = vService.insertVolunteer(v);
		if(result > 0) {
			return "redirect:volunteerEnrollHistory.vo";
		}
		return null;
	}
}
