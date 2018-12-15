package com.group7.controller;

import com.group7.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 公告信息
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 获取公告列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("getNoteceListMap")
    public Object getNoteceListMap(@RequestParam Map map){
        //System.out.println(map.get("id"));
     return noticeService.getNotice(map);
    }
}
