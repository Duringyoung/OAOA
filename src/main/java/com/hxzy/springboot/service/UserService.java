package com.hxzy.springboot.service;

import java.util.List;

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

	// 增加用户
	public void addUser(User user);

	// 查找全部
	public List<User> findAll();

	// 根据ID删除用户
	public void deleteById(int id);
	
	public void deleteMany(List<Integer> ids);
	// 更新用户
	public void UpdateUser(User user);

	// 根据ID得到用户
	public User getUserById(int id);

	/**
	 * 模糊查询
	 */
//	public List<User> getUsers(User user);
}
