package com.group7.serviceImpl;

import com.group7.dao.UserInfoDao;
import com.group7.entity.UserInfo;
import com.group7.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * className:UserInfoServiceImpl
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-29 18:42
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;

	/**
	 * 根据用户名查询信息
	 * @param UserName
	 * @return
	 */
	@Override
	public UserInfo login(String UserName) {
		return userInfoDao.login(UserName);
	}

	/**
	 * 根据用户名查询角色
	 * @param userName
	 * @return
	 */
	@Override
	public List<String> seletRole(String userName) {
		return userInfoDao.seletRole(userName);
	}

	/**
	 * 根据用户名查询权限
	 * @param userName
	 * @return
	 */
	@Override
	public List<String> selectPermission(String userName) {
		return userInfoDao.selectPermission(userName);
	}
}
