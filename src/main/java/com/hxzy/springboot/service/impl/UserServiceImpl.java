package com.hxzy.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.hxzy.springboot.dao.UserDao;
import com.hxzy.springboot.entity.User;
import com.hxzy.springboot.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	@Override
	public Page<User> getUsers(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		Page<User> users = userDao.findAll(pageable);
		return users;
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return (int) userDao.count();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}

	@Override
	public void deleteMany(List<Integer> ids) {
		// TODO Auto-generated method stub
		userDao.deleteMany(ids);
	}

}
