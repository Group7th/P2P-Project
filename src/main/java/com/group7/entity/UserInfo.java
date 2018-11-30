package com.group7.entity;

import java.io.Serializable;

/**
 * className:UserInfo
 * discriptoin:
 * 引用Redis 实体类必须序列化
 * 继承Serializable
 * 用户表实体
 * author:毛宇
 * createTime:2018-11-23 16:36
 */
public class UserInfo implements Serializable {

	private Integer id;
	private String userName;//账号
	private String passWord;//密码
	private String salt;//加密密码的盐
	private Integer enable;//用户状态 1:正常状态,2：用户被锁定

	public UserInfo() {
	}

	public UserInfo(Integer id, String userName, String passWord, String salt, Integer enable) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.salt = salt;
		this.enable = enable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
