package com.hxzy.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.springboot.entity.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance, Integer>,JpaSpecificationExecutor<Attendance>{
	
	// user  a  dept b  role c
//	@Query("select a.realName,b.deptName,c.roleName,d.attendanceId,d.startTime,d.endTime from User a,Dept b,Role c,Attendance d where User")
//	public void getAttendance();
}
