package com.hxzy.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hxzy.springboot.dao.DeptDao;
import com.hxzy.springboot.entity.Dept;
import com.hxzy.springboot.service.DeptService;

@Component
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;

	@Override
	public Dept getDeptById(Integer id) {
		// TODO Auto-generated method stub
		return deptDao.getOne(id);
	}

}
