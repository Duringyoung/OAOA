package com.hxzy.springboot.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * @author Ryo Liu
 * @category 权限表
 * 
 */
@Entity
@Table(name = "t_permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	//权限ID
	private Integer permissionId;
	//权限名称
	private String permissionName;
	//权限Url
	private String permissionUrl;
	//关联角色表
	private List<Role> roles;

	public Permission() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission_id")
	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Column(name = "permission_name")
	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Column(name = "permission_url")
	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	// 多对多
	@ManyToMany(mappedBy = "permissions")
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}