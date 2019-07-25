package com.hxzy.springboot.service;

import java.util.List;

import com.hxzy.springboot.entity.Attendance;

public interface AttendanceService {
	public List<Attendance> getAttendance(int id);
	
	public void getUser(int id);
	
	public void addAttendance(Attendance attendance);
}
