package com.group7.controller;

import com.group7.service.diagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 图表
 * 申恩
 */
@Controller
public class diagramController {

    @Autowired
    private diagramService diagramservice;

    @ResponseBody
    @RequestMapping("getJieDaiXinxi")
    public Object getJieDaiXinxi(){
        List<Map> JieDaiXinxi = new ArrayList<>();
        List<Map> daikuan = diagramservice.getDaikuan();
        Map jiedai= new HashMap();
        for (Map map:daikuan) {

        }
        List<Map> huankuan =diagramservice.getHuankuan();
        for (Map map2:huankuan) {

        }

        jiedai.put("daikuan",daikuan);
        jiedai.put("huankuan",huankuan);
        return jiedai;
    }

}
