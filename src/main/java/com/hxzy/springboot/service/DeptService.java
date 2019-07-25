package com.hxzy.springboot.service;

import com.hxzy.springboot.entity.Dept;

public interface DeptService {
	// 根据ID获得Dept对象
	public Dept getDeptById(Integer id);
}
