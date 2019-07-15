package com.hxzy.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hxzy.springboot.dao.UserDao;
import com.hxzy.springboot.entity.User;
import com.hxzy.springboot.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

}
