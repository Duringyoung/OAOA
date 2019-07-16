package com.hxzy.springboot.service;

import org.springframework.data.domain.Page;

import com.hxzy.springboot.entity.User;

public interface UserService {
	/**
	 * 根据用户名和密码查询用户
	 */
	public User getUser(User user);

	/**
	 * 分页显示
	 */
	public Page<User> getUsers(int page, int size);

	/**
	 * 得到总条数
	 */
	public Integer getCount();
}
