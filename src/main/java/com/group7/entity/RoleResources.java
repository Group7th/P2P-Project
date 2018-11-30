package com.group7.entity;

/**
 * className:RoleResources
 * discriptoin:角色资源
 * author:毛宇
 * createTime:2018-11-30 00:13
 */
public class RoleResources {

	private Integer roleId;
	private Integer RESOURCESID;

	public RoleResources() {
	}

	public RoleResources(Integer roleId, Integer RESOURCESID) {
		this.roleId = roleId;
		this.RESOURCESID = RESOURCESID;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRESOURCESID() {
		return RESOURCESID;
	}

	public void setRESOURCESID(Integer RESOURCESID) {
		this.RESOURCESID = RESOURCESID;
	}
}
