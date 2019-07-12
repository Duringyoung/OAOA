package com.hxzy.springboot.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * @author Ryo Liu
 * @category 角色表
 * 
 */
@Entity
@Table(name="t_role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	//角色ID
	private Integer roleId;
	//角色名
	private String roleName;
	//关联权限表
	private List<Permission> permissions;
	//关联用户表
	private List<User> users;

	public Role() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	@Column(name="role_name")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	// 多对多
	@ManyToMany
	@JoinTable(
		name="t_role_permission"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permission_id")
			}
		)
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}


	// 多对多
	@ManyToMany(mappedBy="roles")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}