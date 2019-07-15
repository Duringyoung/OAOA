package com.hxzy.springboot.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Ryo Liu
 * @category 用户表
 * 
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户ID
	private Integer userId;
	// 用户年龄
	private Integer age;
	// 用户邮箱
	private String email;
	// 入职时间
	private Timestamp hiredate;
	// 真实名字
	private String name;
	// 密码
	private String password;
	// 电话
	private String phone;
	// 1代表正式员工，0代表非正式员工
	private Integer regular;
	// 用户名
	private String username;
	// 工作状态，1：在职；0：离职
	private Integer working;
	// 关联考勤表
	private List<Attendance> attendances;
	// 关联公积金表
	private List<Fund> funds;
	// 关联请假表
	private List<Leave> leaves;
	// 关联社保表
	private List<Social> socials;
	// 关联部门表
	private Dept dept;
	// 关联角色表
	private List<Role> roles;

	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRegular() {
		return regular;
	}

	public void setRegular(Integer regular) {
		this.regular = regular;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getWorking() {
		return working;
	}

	public void setWorking(Integer working) {
		this.working = working;
	}

	// 一对多
	@OneToMany(mappedBy = "user")
	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	// 一对多
	@OneToMany(mappedBy = "user")
	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

	// 一对多
	@OneToMany(mappedBy = "user")
	public List<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	// 一对多
	@OneToMany(mappedBy = "user")
	public List<Social> getSocials() {
		return socials;
	}

	public void setSocials(List<Social> socials) {
		this.socials = socials;
	}

	// 多对一
	@ManyToOne
	@JoinColumn(name = "dept_id")
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	// 多对多
	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}