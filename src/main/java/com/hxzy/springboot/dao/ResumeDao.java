package com.hxzy.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hxzy.springboot.entity.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>,JpaSpecificationExecutor<Resume>{

}
