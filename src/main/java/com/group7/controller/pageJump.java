package com.group7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * 申恩
 */
@Controller
public class pageJump {
    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/toIndex")
    public String indexPage(){
        return "frontEnd/index";
    }


    /**
     * 跳转我要投资
     * @return
     */
    @RequestMapping("/toInvest")
    public String toInvest(){
        return "frontEnd/invest";
    }

    /**
     * 跳转借贷
     * @return
     */
    @RequestMapping("/toBorrow")
    public String toBorrow(){
        return "frontEnd/borrow";
    }

    /**
     * 跳转账户信息
     * @return
     */
    @RequestMapping("/toNoticelist")
    public String toNoticelist(){
        return "frontEnd/noticelist";
    }


    /**
     * 跳转投资页面
     * @return
     */
    @RequestMapping("/toDetail")
    public String toDetail(){
        return "frontEnd/11112/detail";
    }

    /**
     * 跳转常见问题
     * @return
     */
    @RequestMapping("/toproblem")
    public String toproblem(){
        return "frontEnd/problem";
    }

    /**
     * 跳转登录
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "frontEnd/login";
    }

    /**
     * 跳转注册
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "frontEnd/register";
    }



}
