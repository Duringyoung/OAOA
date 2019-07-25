package com.hxzy.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.springboot.entity.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>,JpaSpecificationExecutor<Resume>{
	
	@Modifying
	@Transactional
	@Query("delete from Resume s where s.resumeId in (?1)")
	public void deleteBatch(List<Integer> ids);
	 
//	@Query("select res.resumeName from Resume res where resumeName like CONCAT('%',:names,'%')")
//	public List<Resume> getResumeListss(String names);
}
