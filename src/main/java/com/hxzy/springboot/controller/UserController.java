package com.hxzy.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.springboot.entity.Dept;
import com.hxzy.springboot.entity.User;
import com.hxzy.springboot.service.DeptService;
import com.hxzy.springboot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;

	// 从主页跳转登录页
	@GetMapping("/")
	public String form() {

		return "index";
	}

	// 接收action请求
	@PostMapping("/loginuser")
	public String login(@ModelAttribute User user, HttpSession session) {
		User u1 = userService.getUser(user);
		if (u1 != null) {
			session.setAttribute("user1", user);
			return "left";
		}
		return "login";
	}

	// 右边显示页面
	@GetMapping("yuangong")
	public String yuangong(Model model) {
		List<User> userlist = userService.findAll();
		model.addAttribute("userlist", userlist);
		return "yuangong";
	}

	// 添加用户
	@GetMapping("yuangong/add")
	public String ygadd(@ModelAttribute User user, @RequestParam String deptId) {
		Dept dept = deptService.getDeptById(Integer.parseInt(deptId));
		user.setDept(dept);
		userService.addUser(user);
		return "redirect:/yuangong";
	}

	// 得到单个用户
	@GetMapping("yuangong/get/{id}")
	public String getygById(@PathVariable(name = "id") Integer id, Model model) {
		User u = userService.getUserById(id);
		model.addAttribute("user",u);
		return "ygupdate";
	}

	// 更新用户
	@GetMapping("yuangong/update")
	public String ygupdate(@ModelAttribute User user) {
		userService.UpdateUser(user);
		return "redirect:/yuangong";
	}

	// 批量删除用户
	@GetMapping("yuangong/delMany")
	public String ygdelMany(@RequestParam String IDstring) {
		System.out.println(IDstring);
		String ids[] = IDstring.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (String id : ids) {
			list.add(Integer.parseInt(id));
		}
		userService.deleteMany(list);
		return "redirect:/yuangong";
	}

	// 删除单个用户
	@GetMapping("yuangong/del/{id}")
	public String ygdel(@PathVariable(name = "id") Integer id) {
		userService.deleteById(id);
		return "redirect:/yuangong";
	}

}
