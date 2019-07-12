package com.hxzy.springboot.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @author Ryo Liu
 * @category 简历表
 * 
 */
@Entity
@Table(name="t_resume")
public class Resume implements Serializable {
	private static final long serialVersionUID = 1L;
	//ID
	private Integer resumeId;
	//年龄
	private Integer age;
	//学历
	private String education;
	//工作经验
	private String experience;
	//姓名
	private String name;
	//性别
	private String sex;
	//职业技能
	private String skill;
	//专业
	private String speciality;

	public Resume() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resume_id")
	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}


	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}


	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}


	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}