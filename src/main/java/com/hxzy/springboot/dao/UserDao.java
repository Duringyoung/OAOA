package com.hxzy.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.springboot.entity.User;

public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
	// 根据用户名和密码查找用户
	@Query("from User where username=:#{#user.username} and password =:#{#user.password}")
	public User getUser(User user);

	@Modifying
	@Transactional
	@Query("delete from User where userId in (?1)")
	public void deleteMany(List<Integer> ids);
}
