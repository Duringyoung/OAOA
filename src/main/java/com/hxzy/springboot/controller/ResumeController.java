package com.hxzy.springboot.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

		return "resRight"; 
	}	
	
	//添加用户
	@GetMapping("res_add") 
	public String add(@ModelAttribute Resume resume,Model model) {		
		System.out.println(resume.getSex());
		resumeService.addResume(resume);
		return "redirect:/res_page";
	}
	//分页显示列表
	@GetMapping("res_page")
	public String resPage(@RequestParam(value="pageNum", defaultValue="0") Integer pageNum,@RequestParam(value="names",defaultValue="") String names,Model model){
		//每页显示数据条数
		int pageSize=5;
		//初始页面
		int num=1;
		//总条数
		int page=resumeService.getSum();	
		//最后一页
		int max;
		if(page%pageSize==0) {		
			max=page/pageSize-1;
		}else{
			max=page/pageSize;
		}		
		if(num<=1) {
			num=0; 
		}	
		model.addAttribute("num", num);
		model.addAttribute("max", max);
//		System.out.println("names="+names+"\n"+"pageNum="+pageNum);
		
		if(names==null||names.equals("")) {
			Page<Resume> resumes=resumeService.getPageList(pageNum, pageSize);
			model.addAttribute("resumes", resumes);	
		}else{
			List<Resume> list=resumeService.getResumeLists(names);
			model.addAttribute("resumes",list);	
		};						
		return "resRight";
	}
	
	//按ID删除
	@GetMapping("res_delete_{id}")
	public String resDelete(@PathVariable(name="id") Integer id) {
		resumeService.deleteResumeById(id);
		return "redirect:/res_page";
	}
	
	//按ID查询
	@GetMapping("res_getResume_{id}")
	public String getResume(@PathVariable(name="id") Integer id,HttpSession session) {
		session.setAttribute("resume", resumeService.getResume(id));
		return "resUpdate";
	}
	
	//更新
	@GetMapping("res_update")
	public String resUpdate(@ModelAttribute Resume resume) {
		resumeService.updateResume(resume);
		return "forward:/res_page";
	}
	//批量删除
	@GetMapping("res_delete")
	public String batchDelet(@RequestParam String tempString) {
		String resId[]=tempString.split(",");
		List<Integer> list=new ArrayList<Integer>();
		for(String id:resId) {
			list.add(Integer.parseInt(id));
		}
		resumeService.batchDelet(list);
		return "redirect:/res_page";
	}
	
	@GetMapping("res_getResumes")
	public String getResumeLists(@RequestParam String names, Model model){
//		System.out.println(names);		
		List<Resume> list=resumeService.getResumeLists(names);
		model.addAttribute("resumes", list);
		return "resRight";
	}
	
//	@GetMapping("res_page_getResumes")
//	public String resPageResumes(@RequestParam(defaultValue="0") Integer pageNum,@RequestParam String names, Model model){
//		//每页显示数据条数
//		int pageSize=5;
//		//初始页面
//		int num=1;
//		//总条数
//		int page=resumeService.getSum();	
//		//最后一页
//		int max;
//		if(page%pageSize==0) {		
//			max=page/pageSize-1;
//		}else{
//			max=page/pageSize;
//		}		
//		if(num<=1) {
//			num=0;
//		}	
//		model.addAttribute("num", num);
//		model.addAttribute("max", max);
//		List<Resume> list=resumeService.getResumeLists(names);
//		
//		Page<Resume> resumes=resumeService.getPageList(pageNum, pageSize);	
//		model.addAttribute("resumes", resumes);		
//		return "resRight";
//	}
}
