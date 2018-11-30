package com.group7.config;

import com.group7.entity.UserInfo;
import com.group7.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;


/**
 * className:MyShiroRealm
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-29 18:37
 */
public class MyShiroRealm extends AuthorizingRealm implements Serializable{

	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 登录认证
	 * 1、authenticationInfo：获取认证消息，如果数据库中没有，返回null，如果得到正确的用户名和密码
	 * 2、AuthenticationInfo  可用simpleAuthenticationInfo实现类，封装获取到的正确的账号和密码
	 * 返回正确类型的对象
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取username
		String userName = (String)token.getPrincipal();
		Session session = SecurityUtils.getSubject().getSession();
		//通过username查询
		UserInfo user = userInfoService.login(userName);
		if(user==null) {
			throw  new UnknownAccountException();
		}
		if (0==user.getEnable()) {
			throw new LockedAccountException(); // 帐号锁定
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user,//用户名
				user.getPassWord(),//密码
				"MyRealm"//realm name
		);
		//设置盐
		//authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
		//当验证信息都通过后，把用户信息放在session里

		session.setAttribute("userSession",user);
		//session.setAttribute("userSessionId",user.getId());
		return authenticationInfo;
	}

	/**
	 * 授权
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//全局通过SecurityUtils.getSubject().getPrincipal()获取用户信息
		UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
		//通过用户名查出来角色
		List<String> strings = userInfoService.seletRole(userInfo.getUserName());
		// 权限信息对象info,用来存放查出的用户的所有的角色（role）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for(String role:strings){
			//角色名称
			System.out.println(role);
			info.addStringPermission(role);
		}
		//返回角色名称
		return info;
	}
}
