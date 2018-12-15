package com.group7.controller;


import com.group7.service.WebsiteGuanLiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebsiteGuanLController {

    //引入服务层
    @Autowired
    private WebsiteGuanLiService websiteGuanLiService;

    /**
     * 公告信息列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getNoticeListMap")
    public Object getNoticeListMap(@RequestBody Map map){
        Map maps = new HashMap();
        maps.put("data", websiteGuanLiService.getnoticeGuanLi(map));
        maps.put("total", websiteGuanLiService.getnoticeGuanLiCount(map));
        return maps;
    }

    /**
     * 添加
     * @param map
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addNotice")
    public Object addNotice(@RequestBody Map map,HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");
        map.put("userName",userName);

        return websiteGuanLiService.addNotice(map);
    }


    /**
     * 修改
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateNotice")
    public Object updateNotice(@RequestBody Map map){
        return websiteGuanLiService.updateNotice(map);
    }

    /**
     * 删除
     * @param ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/delectNotice")
    public Object delectNotice(@RequestParam Integer ID){
        return websiteGuanLiService.delectNotice(ID);
    }

    @ResponseBody
    @RequestMapping("/deleteNotices/{ids}")
    public Object deleteNotices(@PathVariable("ids") String[] ids){
        System.out.println("进入批量删除方法");
        System.out.println(ids);
        return websiteGuanLiService.deleteNotices(ids);
    }

}
