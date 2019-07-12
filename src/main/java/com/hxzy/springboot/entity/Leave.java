package com.hxzy.springboot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * @author Ryo Liu
 * @category 请假表
 * 
 */
@Entity
@Table(name="t_leave")
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;
	//ID
	private Integer leaveId;
	//结束请假的时间
	private Timestamp endLeave;
	//开始请假的时间
	private Timestamp startLeave;
	//关联用户表
	private User user;

	public Leave() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leave_id")
	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}


	@Column(name="end_leave")
	public Timestamp getEndLeave() {
		return endLeave;
	}

	public void setEndLeave(Timestamp endLeave) {
		this.endLeave = endLeave;
	}


	@Column(name="start_leave")
	public Timestamp getStartLeave() {
		return startLeave;
	}

	public void setStartLeave(Timestamp startLeave) {
		this.startLeave = startLeave;
	}


	// 多对一
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}