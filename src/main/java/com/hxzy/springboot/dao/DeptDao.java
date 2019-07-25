package com.hxzy.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hxzy.springboot.entity.Dept;

public interface DeptDao extends JpaRepository<Dept, Integer>, JpaSpecificationExecutor<Dept> {

}
