package com.hxzy.springboot.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
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
	
	@GetMapping("right")
	public String index1() {	
		System.out.println("进来没");
		return "right"; 
	}	
	
	@PostMapping("res_add")
	public String add(@ModelAttribute Resume resume,Model model) {
		System.out.println("添加");
		resumeService.addResume(resume);
		return "right";
	}
	
	@GetMapping("res_page")
	public String page(Model model){
		System.out.println("分页");
		Page<Resume> resumes=resumeService.getPageList(0, 2);
		model.addAttribute("resumes", resumes);
		return "right";
	}
	
	@PostMapping("delete")
	public String delete(@PathVariable(name="id") Integer id) {
		resumeService.deleteResumeById(id);
		return "redirect:/index4";
	}
	
	
	
}
