package com.group7.entity;

import java.io.Serializable;

/**
 * className:UserRole
 * discriptoin:
 * 中间表 用户角色
 * author:毛宇
 * createTime:2018-11-29 20:13
 */
public class UserRole implements Serializable {

	private Integer userId;//用户id
	private Integer roleId;//角色id

	/**
	 * 构造
	 * @param userId
	 * @param roleId
	 */
	public UserRole(Integer userId, Integer roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
