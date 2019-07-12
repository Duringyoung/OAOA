package com.hxzy.springboot.service;

import com.hxzy.springboot.entity.User;

public interface UserService {
	/**
	 * 根据用户名和密码查询用户
	 */
	public User getUser(User user);
}
