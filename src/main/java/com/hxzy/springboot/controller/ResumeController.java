package com.hxzy.springboot.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.hxzy.springboot.entity.Resume;
import com.hxzy.springboot.service.ResumeService;

@Controller
public class ResumeController {
	
	private ResumeService resumeService;
	
	@Resource(name="resumeServiceImpl")
	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
//	@GetMapping("/")
//	public String index() {		
//		return "left"; 
//	}

//	@GetMapping("right")
//	public String index1() {	
//		return "right"; 
//	}	
//	
//	
//	@PostMapping("add")
//	public String add(@ModelAttribute Resume resume,Model model) {
//		resumeService.addResume(resume);
//		return "index4";
//	}
//	
//	@PostMapping("delete")
//	public String delete(@PathVariable(name="id") Integer id) {
//		resumeService.deleteResumeById(id);
//		return "redirect:/index4";
//	}
	
}
