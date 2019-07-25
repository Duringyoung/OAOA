package com.hxzy.springboot.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.hxzy.springboot.entity.User;
import com.hxzy.springboot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 从主页跳转登录页
	@GetMapping("/")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "left";
	}

	// 接收action请求
	@PostMapping("/loginuser")
	public String login(@ModelAttribute User user, HttpSession session) {
		User u1 = userService.getUser(user);
		if (u1 != null) {
			session.setAttribute("loginuser", user);
			return "left";
		}
		return "index";
	}
//	@GetMapping("/")
//	public String form1(Model model) {
//		model.addAttribute("user", new User());
//		return "right";
//	}
}
