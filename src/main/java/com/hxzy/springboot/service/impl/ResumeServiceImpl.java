package com.hxzy.springboot.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
	//分页查询
	@Override
	public Page<Resume> getPageList(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable=new PageRequest(pageNum,pageSize);
		Page<Resume> pages=resumeDao.findAll(pageable);
		return pages;
	}

	@Override
	public int getSum() {
		// TODO Auto-generated method stub
		return (int) resumeDao.count();
	}

	@Override
	public Resume getResume(Integer id) {
		// TODO Auto-generated method stub
		return resumeDao.getOne(id);
	}

	@Override
	public void batchDelet(List<Integer> id) {
		// TODO Auto-generated method stub
		resumeDao.deleteBatch(id);
	}
	//模糊查询
	@Override
	public List<Resume> getResumeLists(String names) {
		// TODO Auto-generated method stub
		return resumeDao.findAll(new Specification<Resume>() {			
			@Override
			public Predicate toPredicate(Root<Resume> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate predicate=cb.conjunction();
				if(names!=null&&!names.equals("")) {
					predicate.getExpressions().add(cb.like(root.get("resumeName"), "%"+names+"%"));
				}			
				return predicate;
			}
		});
	}
	
//	@Override
//	public Page<Resume> getResumeLists(String names,int pageNum, int pageSize) {
//		// TODO Auto-generated method stub
//		
//		if(names==null) {
//			Pageable pageable=new PageRequest(pageNum,pageSize);
//			Page<Resume> pages=resumeDao.findAll(pageable);
//			return pages;
//		}else {
//			return resumeDao.findAll(new Specification<Resume>() {			
//				@Override
//				public Predicate toPredicate(Root<Resume> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//					// TODO Auto-generated method stub
//					Predicate predicate=cb.conjunction();
//					if(names!=null&&!names.equals("")) {
//						predicate.getExpressions().add(cb.like(root.get("resumeName"), "%"+names+"%"));
//						
//					}			
//					return predicate;
//				}
//			});
//		}
//	}
	
}
