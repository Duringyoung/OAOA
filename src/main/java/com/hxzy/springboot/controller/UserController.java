package com.hxzy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hxzy.springboot.entity.User;
import com.hxzy.springboot.service.UserService;

public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/loginuser")
	public String login(@ModelAttribute User user) {
		User u1 = userService.getUser(user);
		if(u1!=null) {
			return "info";
		}
		return "/";
	}
}
