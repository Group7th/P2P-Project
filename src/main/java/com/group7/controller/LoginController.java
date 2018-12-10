package com.group7.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * className:LoginController
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-23 16:30
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) throws Exception{
		String userName= request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		Subject subject = SecurityUtils.getSubject();
		if(userName!=null&&!"".equals(userName)) {
			UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
			try {
				subject.login(token);
				return "redirect:/toIndex";
			} catch (AuthenticationException exception) {
				//清除session
				token.clear();
				//自定义信息
				String msg="";
				if (UnknownAccountException.class.getName().equals(exception+"")) {
					msg = "您输入的账号不存在~";
				} else if (IncorrectCredentialsException.class.getName().equals(exception.getClass().getName())) {
					msg = "您输入的密码不正确~";
				} else if (LockedAccountException.class.getName().equals(exception.getClass().getName()) ){
					msg = " 您的账号已经被锁定 无法登入系统~";
				} else {
					msg = "账号或者密码错误~";
				}
				model.addAttribute("msg", msg);
				// 此方法不处理登录成功,由shiro进行处理
				return "frontEnd/login";
			}
		}
		return null;
	}

	/**
	 * 用户注销，跳转到登陆页面
	 * @param request
	 * @return
	 */
	@RequestMapping("UserExit")
	public String UserExit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userSession");
		String s =(String) session.getAttribute("userSession");
		System.out.println("-------------------"+s);
		return "frontEnd/login";
	}
}
