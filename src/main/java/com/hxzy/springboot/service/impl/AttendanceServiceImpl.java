package com.hxzy.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.springboot.dao.AttendanceDao;
import com.hxzy.springboot.entity.Attendance;
import com.hxzy.springboot.service.AttendanceService;
@Component("attendanceServiceImpl")
public class AttendanceServiceImpl implements AttendanceService{
	AttendanceDao attendanceDao;
	
	@Resource
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}


	@Override
	public List<Attendance> getAttendance(int id) {
		// TODO Auto-generated method stub
		
		return attendanceDao.findAll();
	}


	@Override
	public void addAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getUser(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
