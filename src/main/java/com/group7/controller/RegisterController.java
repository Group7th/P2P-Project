package com.group7.controller;

import com.group7.entity.User;
import com.group7.service.UserService;
import com.group7.util.ShowApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * ClassName:RegisterController
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-24 09:40
 */

@Controller
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private UserService userService;

    /**
     * 注册方法
     * @param user
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Map<String,String> register(User user){
        System.out.println(user.toString());
        int i = userService.register(user);
        System.out.println(i);
        Map<String,String> map = new HashMap<>();
        if(i>0){
            map.put("msg","success");
        }else{
            map.put("msg","fail");
        }
        return map;
    }

    /**
     * 用户名验重
     * @param userName
     * @return
     */
    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String,String> checkUserName(@RequestParam String userName) {
        String s = userService.checkRepeat(userName);
        Map<String,String> map = new HashMap<>();
        if(s!=null&&s!=""){
            map.put("msg","fail");
        }else{
            map.put("msg","success");
        }
        return map;
    }

    /**
     * 手机号验重
     * @param phone
     * @return
     */
    @RequestMapping("/checkPhone")
    @ResponseBody
    public Map<String,String> checkPhone(@RequestParam String phone) {
        String s = userService.checkRepeatPhone(phone);
        Map<String,String> map = new HashMap<>();
        if(s!=null&&s!=""){
            map.put("msg","fail");
        }else{
            map.put("msg","success");
        }
        return map;
    }



        /***
         * 身份证接口测试
         */
    @RequestMapping("/getIdCard")
    @ResponseBody
    public String getIdCard(){
        String s = (new ShowApiRequest("http://route.showapi.com/25-3", "76850", "3ae9b0a4bcb346dabeca64447a7406f4"))
                .addTextPara("id","411523199507192014")
                .post();
        return s;
    }

    /***
     * 短信模板提交测试
     */
    @RequestMapping("/getMessage")
    @ResponseBody
    public String get(){
        String res = (new ShowApiRequest("http://route.showapi.com/28-2","76850","3ae9b0a4bcb346dabeca64447a7406f4"))
                .addTextPara("content","尊敬的用户您好!您本次的验证码是:[yzm],有效时间为5分钟!")
                .addTextPara("title","中兴财富")
                .post();
        return res;
    }

    /**
     * 修改短信模板
     * @return
     */
    @RequestMapping("/alterMould")
    @ResponseBody
    public String alterModule(){
        String res = (new ShowApiRequest("http://route.showapi.com/28-10","76850","3ae9b0a4bcb346dabeca64447a7406f4"))
                .addTextPara("content","尊敬的用户您好!您本次的验证码是:[code],有效时间为3分钟!")
                .addTextPara("title","中兴财富")
                .addTextPara("tNum","T170317003567")
                .addTextPara("notiPhone","13592535690")
                .post();
        return res;
    }

    /***
     * 短信模板是否通过测试
     */
    @RequestMapping("/getMould")
    @ResponseBody
    public String modelOk(){
        String res = (new ShowApiRequest("http://route.showapi.com/28-3","76850","3ae9b0a4bcb346dabeca64447a7406f4"))
                .addTextPara("nomalTemplate","2")
                .post();
        return res;
    }

    /**
     * 发送短信
     * @return
     */
    @RequestMapping("/sendMessage")
    @ResponseBody
    public Map sendMessage(@RequestParam String phone, HttpSession session){
        int randomNum = (int)((Math.random()*9+1)*100000);
        Map tempMap = new HashMap();
//        String res = (new ShowApiRequest("http://route.showapi.com/28-1","76850","3ae9b0a4bcb346dabeca64447a7406f4"))
//                .addTextPara("mobile",phone)
//                .addTextPara("content","{\"name\":\"严浩天\",\"code\":\""+randomNum+"\",\"minute\":\"3\"}")
//                .addTextPara("tNum","T170317003567")
//                .post();
        String attrName = "vcode";
        session.setAttribute("vcode",randomNum);
//        session.setAttribute("vcode","123456");
        this.removeAttrbute(session, attrName);
        tempMap.put("vcode",randomNum);
//        tempMap.put("vcode","123456");
        tempMap.put("sessionId",session.getId());
        return tempMap;
    }

    /**
     * 设置5分钟后删除session中的验证码
     * @param session
     * @param attrName
     */
    private void removeAttrbute(final HttpSession session, final String attrName) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 删除session中存的验证码
                session.removeAttribute(attrName);
                timer.cancel();
            }
        }, 6*10 * 1000);
    }

    /**
     * 判断验证码是否超时
     * @param session
     * @return
     */
    @RequestMapping("/hasVcode")
    @ResponseBody
    public Map hasVcode(HttpSession session){
        Object vcode = session.getAttribute("vcode");
        System.out.println(vcode);
        Map tempMap = new HashMap();
        if(vcode!=null){
            tempMap.put("msg","success");
        }else {
            tempMap.put("msg","fail");
        }
        return tempMap;
    }


    /**
     * 删除短信模板
     * @return
     */
    @RequestMapping("/deleteMould")
    @ResponseBody
    public String deleteMould(){
        String res = (new ShowApiRequest("http://route.showapi.com/28-9","76850","3ae9b0a4bcb346dabeca64447a7406f4"))
                .addTextPara("tNum","T170317003566")
                .post();
        return res;
    }


}
