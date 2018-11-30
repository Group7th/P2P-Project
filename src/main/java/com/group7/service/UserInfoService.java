package com.group7.service;

import com.group7.entity.UserInfo;

import java.util.List;

/**
 * className:UserInfoService
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-29 18:41
 */
public interface UserInfoService {

	/**
	 * 获取登录时的用户名查询出信息
	 *
	 * @param UserName
	 * @return
	 */
	UserInfo login(String UserName);

	/**
	 * 根据userName查询角色
	 *
	 * @param userName
	 * @return
	 */
	List<String> seletRole(String userName);

	/**
	 * 根据资源查出来权限
	 * @param userName
	 * @return
	 */
	List<String> selectPermission(String userName);
}

