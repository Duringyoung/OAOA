package com.hxzy.springboot.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * @author Ryo Liu
 * @category 部门表
 * 
 */
@Entity
@Table(name = "t_dept")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;
	// ID
	private Integer deptId;
	// 部门名
	private String deptName;
	// 关联用户表
	private List<User> users;

	public Dept() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Column(name = "dept_name")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	// 一对多
	@OneToMany(mappedBy = "dept")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}