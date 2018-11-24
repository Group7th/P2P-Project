package com.group7.controller;

import com.group7.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:InvestController
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-23 21:12
 */
//扫描控制层
@Controller
public class InvestController {

    @Autowired  //依赖注入
    private InvestService investService;

    @ResponseBody
    @RequestMapping("/invest")
    public Object invest(@RequestParam Map map){
        System.out.println(map);
        System.out.println(map.get("month"));
        System.out.println(map.get("type"));
        List<Map> inves = investService.getInves(map);
        int invesCount = investService.getInvesCount(map);
        Map tempMap = new HashMap();
        tempMap.put("inves",inves);
        tempMap.put("invesCount",invesCount);
        return tempMap;
    }
}
