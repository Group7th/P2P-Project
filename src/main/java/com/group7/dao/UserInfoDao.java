package com.group7.dao;

import com.group7.entity.UserInfo;

import java.util.List;

/**
 * className:UserInfoDao
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-29 18:40
 */
public interface UserInfoDao {

	/**
	 * 通过用户名查询信息
	 *
	 * @param userName
	 * @return
	 */
	UserInfo login(String userName);

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


