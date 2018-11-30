package com.group7.entity;

import java.io.Serializable;

/**
 * className:Role
 * discriptoin:
 *角色表实体
 * author:毛宇
 * createTime:2018-11-29 19:37
 */
public class Role implements Serializable {

	private Integer id;//角色id
	private String roleDesc;//角色描述

	public Role() {
	}

	/**
	 * 构造
	 * @param id
	 * @param roleDesc
	 */
	public Role(Integer id, String roleDesc) {
		this.id = id;
		this.roleDesc = roleDesc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
