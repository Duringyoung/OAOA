package com.hxzy.springboot.controller;

import javax.annotation.Resource;

import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hxzy.springboot.service.AttendanceService;

@Controller
public class AttendanceController {
	
	AttendanceService attendanceService;
	
	@Resource
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	
	@GetMapping("att_page")
	public String index(Model model) {

//		model.addAttribute("att", attendanceService.getAttendance());
		return "attRight";
	}
	
}
