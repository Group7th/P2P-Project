package com.group7.controller;


import com.group7.service.JinNangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于锦囊
 * 申恩
 */
@Controller
public class JinNangController {

    @Autowired
    private JinNangService jinNangService;


    /**
     * 添加一条锦囊
     * @param map
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("faBuJinNang")
    public int  faBuJinNang(@RequestBody Map map,HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userSession");
        int userId = jinNangService.getId(userName);
        map.put("userName",userName);
        map.put("userId",userId);
        return jinNangService.addJInNang(map);
    }


    /**
     * 获取锦囊列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getJinNangListMap")
    public Object getJinNangListMap(@RequestParam Map map){
        map.put("type",1);
        return jinNangService.getJinNangListMap(map);
    }

    /**
     * 获取锦囊列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getJinNangXinXi")
    public Object getJinNangXinXi(@RequestParam Map map){
        System.out.println("进入方法"+map.get("id"));
        map.put("type",2);
        return jinNangService.getJinNangListMap(map);
    }
}
