package com.hxzy.springboot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
//test
/**
 * @author Ryo Liu
 * @category 考勤表
 * 
 */
//修改1234
@Entity
@Table(name = "t_attendance")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;
	// ID
	private Integer attendanceId;
	// 下班时间
	private Timestamp endTime;
	// 上班时间
	private Timestamp startTime;
	// 关联用户表
	private User user;

	public Attendance() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	@Column(name = "end_time")
	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "start_time")
	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	// 多对一
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}