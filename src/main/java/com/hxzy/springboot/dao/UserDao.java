package com.hxzy.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.springboot.entity.User;

public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
	//根据用户名和密码查找用户
	@Query("from User where username=:#{#user.username} and password =:#{#user.password}")
	public User getUser(User user);
}
