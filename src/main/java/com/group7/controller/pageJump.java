package com.group7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * 申恩
 */
@Controller
public class pageJump {

    /**
     * 身份证验证界面
     * @return
     */
    @RequestMapping("/toIdentity")
    public String toIdentity(){
        return "backStage/IDCardIdentity";
    }

    /**
     * 支付密码界面
     * @return
     */
    @RequestMapping("/toPay")
    public String toPay(){
        return "backStage/IpayPassword";
    }

    /**
     * 跳转上传页面
     * @return
     */
    @RequestMapping("toUpload")
    public String upLoadPage(){
        return "backStage/Upload";
    }

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("toIndex")
    public String indexPage(){
        return "frontEnd/index";
    }

    /**
     * 跳转我要投资
     * @return
     */
    @RequestMapping("toInvest")
    public String toInvest(){
        return "frontEnd/invest";
    }

    /**
     * 跳转借贷
     * @return
     */
    @RequestMapping("toBorrow")
    public String toBorrow(){
        return "frontEnd/borrow";
    }

    /**
     * 跳转账户信息
     * @return
     */
    @RequestMapping("toAccount")
    public String toAccount(){
        return "frontEnd/Account";
    }


    /**
     * 跳转投资页面
     * @return
     */
    @RequestMapping("toDetail")
    public String toDetail(){
        return "frontEnd/11112/detail";
    }

    /**
     * 跳转常见问题
     * @return
     */
    @RequestMapping("toproblem")
    public String toproblem(){
        return "frontEnd/problem";
    }

    /**
     * 跳转登录
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "frontEnd/login";
    }

    /**
     * 跳转注册
     * @return
     */
    @RequestMapping("toRegister")
    public String toRegister(){
        return "frontEnd/register";
    }

    /**
     * 跳转公告列表
     * @return
     */
    @RequestMapping("toNoticelist")
    public String toNoticelist(){
        return "frontEnd/noticelist";
    }

    /**
     * 个人中心首页
     * @return
     */
//    @RequestMapping("toGeRenZhongXinShouYe")
//    public String toGeRenZhongXinShouYe(){
//        return "yirenbaopage/GRZX";
//    }

    /**
     * 个人中心充值
     * @return
     */
    @RequestMapping("toGRZXChongZhi1")
    public String toGRZXChongZhi1(){
        return "yirenbaopage/个人中心-充值.html";

    }

    /**
     * 兑换记录
     * @return
     */
    @RequestMapping("toGRZXDuiHuan")
    public String toGRZXDuiHuan(){
        return "yirenbaopage/个人中心-兑换历史.html";

    }

    /**
     * 回款计划
     * @return
     */
    @RequestMapping("toGRZXHuiKuan")
    public String toGRZXHuiKuan(){
        return "yirenbaopage/个人中心-回款计划.html";
    }

    /**
     * 开通第三方
     * @return
     */
    @RequestMapping("toGRZXKaiTong1")
    public String toGRZXKaiTong1(){
        return "yirenbaopage/个人中心-开通第三方.html";
    }


    /**
     * 我的红包
     * @return
     */
    @RequestMapping("toGRZXHongBao")
    public String toGRZXHongBao(){
        return "yirenbaopage/个人中心-我的红包.html";
    }

    /**
     * 投资纪录
     * @return
     */
    @RequestMapping("toGRZXTouZi")
    public String toGRZXTouZi(){
        return "yirenbaopage/个人中心-投资记录.html";
    }

    /**
     * 提现
     * @return
     */
    @RequestMapping("toGRZXTiXian1")
    public String toGRZXTiXian1(){
        return "yirenbaopage/个人中心-提现.html";
    }

    /**
     * 系统消息
     * @return
     */
    @RequestMapping("toGRZXXiTongXiaoXi")
    public String toGRZXXiTongXiaoXi(){
        return "yirenbaopage/个人中心-系统消息.html";
    }


    /**
     * 账号设置
     * @return
     */
//    @RequestMapping("toGRZXZhangHao")
//    public String toGRZXZhangHao(){
//        return "yirenbaopage/个人中心-账户设置.html";
//    }

    /**
     * 资金纪录
     * @return
     */
    @RequestMapping("toGRZXZiJin")
    public String toGRZXZiJin(){
        return "yirenbaopage/个人中心-资金记录 .html";
    }


}
