package com.hxzy.springboot.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Ryo Liu
 * @category 社保表
 * 
 */
@Entity
@Table(name = "t_social")
public class Social implements Serializable {
	private static final long serialVersionUID = 1L;
	//ID
	private Integer socialId;
	//账户
	private String account;
	//缴纳机构
	private String agency;
	//密码
	private String password;
	//所在单位
	private String unit;
	//关联用户表
	private User user;

	public Social() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "social_id")
	public Integer getSocialId() {
		return socialId;
	}

	public void setSocialId(Integer socialId) {
		this.socialId = socialId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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