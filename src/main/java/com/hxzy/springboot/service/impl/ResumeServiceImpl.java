package com.hxzy.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.hxzy.springboot.dao.ResumeDao;
import com.hxzy.springboot.entity.Resume;
import com.hxzy.springboot.service.ResumeService;

@Component("resumeServiceImpl")
public class ResumeServiceImpl implements ResumeService{
	ResumeDao resumeDao;
	
	@Resource
	public void setResumeDao(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	@Override
	public void addResume(Resume resume) {
		// TODO Auto-generated method stub
		resumeDao.save(resume);
	}

	@Override
	public void deleteResumeById(Integer id) {
		// TODO Auto-generated method stub
		resumeDao.deleteById(id);
	}

	@Override
	public void updateResume(Resume resume) {
		// TODO Auto-generated method stub
		resumeDao.save(resume);
	}

	@Override
	public List<Resume> getResumeList() {
		// TODO Auto-generated method stub
		return resumeDao.findAll();
	}

	@Override
	public Page<Resume> getPageList(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable=new PageRequest(pageNum,pageSize);
		Page<Resume> pages=resumeDao.findAll(pageable);
		return pages;
	}
	
}
