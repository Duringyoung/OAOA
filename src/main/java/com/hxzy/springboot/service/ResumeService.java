package com.hxzy.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hxzy.springboot.entity.Resume;

public interface ResumeService {
	public Resume getResume(Integer id);
	
	public void addResume(Resume resume);

	public void deleteResumeById(Integer id);

	public void updateResume(Resume resume);

	public List<Resume> getResumeList();

	// 分页 pageNum 文档页数（第几页） pageSize 每页显示的数据条数
	public Page<Resume> getPageList(int pageNum, int pageSize);
	//获取数据总条数
	public int getSum();
	//批量删除
	public void batchDelet(List<Integer> id);
	//模糊查询
	public List<Resume> getResumeLists(String names);

}
